//import com.ab.gti.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.io.IOException;
import java.io.InputStreamReader;
import model.DCMGmodel;

public class ServeModelTags{
	public static void main(String[] args){
		int lpnum = 12897;
		long prev = System.currentTimeMillis();
		long now = 0;
		long modelet = 0;
		long modelinterval = 20;
		long itrcounter = 0;
		String line;
		String retval;
		

		//create model object
		DCMGmodel dcmg = new DCMGmodel();

		try{
			//create listening socket
			ServerSocketChannel tserver = ServerSocketChannel.open();
			tserver.socket().bind(new InetSocketAddress(lpnum));
			tserver.configureBlocking(false);
			//ServerSocket tserver = new ServerSocket(lpnum);
			String[] userargs = {"-jucs","cip://2:192.168.56.10/1:4","-gtiServerPort", "4000"};
			String[] SGargs = {"-jucs","cip://2:192.168.56.122/1:4","-gtiServerPort", "4000"};
			
			
			
			//this is where we would create new Wrapper objects if we were using a PLC
			//Wrapper SG = new Wrapper(SGargs);
			//Wrapper user = new Wrapper(userargs);
			System.out.println("Should be connected");

			while(true){
				try{
					//System.out.println("haven't accepted yet");
					//Socket tclient = tserver.accept();
					//System.out.println("accepted conn\n");

					SocketChannel tclient = tserver.accept();
					
					
					now = System.currentTimeMillis();
					modelet = now - prev;
					if(modelet > modelinterval){
						//System.out.println(now);
						dcmg.solvemodel(false);
						prev = System.currentTimeMillis();
						itrcounter++;
						//System.out.println(itrcounter);
					}
					if(tclient != null){
						//BufferedReader reqstream = new BufferedReader(new InputStreamReader(tclient.getInputStream()));
						//PrintWriter outstream = new PrintWriter(tclient.getOutputStream(),true);
						ByteBuffer recbuff = ByteBuffer.allocate(8192);
						
						
						//System.out.println("Before Receipt");
						
						//line = reqstream.readLine();
						//System.out.println(line);
						tclient.read(recbuff);
						recbuff.flip();
						Charset charset = Charset.forName("UTF-8");
						CharsetDecoder decoder = charset.newDecoder();
						CharBuffer charBuffer = decoder.decode(recbuff);
						line = charBuffer.toString();
						//System.out.println(line);

						//line = reqstream.readLine();
						//retval = processInput(SG,user,line);
						//System.out.println("about to process");
						retval = processInput(dcmg, line);
						//System.out.println("just processed");
						//System.out.println(line);
						if(retval != null){
							//System.out.println(retval);

							//outstream.println(retval);
							ByteBuffer buffer = ByteBuffer.wrap(retval.getBytes());
							tclient.write(buffer);
						}
						else{
							String nullmsg = "null";
							ByteBuffer buffer = ByteBuffer.wrap(nullmsg.getBytes());
							tclient.write(buffer);
							//System.out.println("return value is null");
						}

						//System.out.println("wrote");

					}				
				}
				catch(IOException e){
					System.out.println(e);
				}
			}
		}	
		catch(IOException e){
			System.out.println(e);
		}
		catch(Exception E){
			System.out.println(E);
		}
	}

	public static String processInput(DCMGmodel dcmg, String req){
		try{
			//System.out.println("processInput() called");
			String[] items = req.split(" ");
			String method = items[0].trim();
			String plc = items[1].trim();
			
			String retval;
			
			if(plc.equals("SG")){
				//retval = processMore(SG,method,items);
				retval = processMore(dcmg,method,items);
				return retval;
			}
			else if(plc.equals("user")){
				//retval = processMore(user,method,items);
				retval = processMore(dcmg,method,items);
				return retval;
			}
			else{
				System.out.println("invalid PLC type");
				return null;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("got to end of processInput()");
		return null;
	}
	
	public static String processMore(DCMGmodel dcmg, String method, String[] items){
		String retval;
		//System.out.println("processMore() called");
		if(method.equals("read")){
			//retval = handleRead(w,items);
			retval = handleRead(dcmg,items);
			return retval;
		}
		else if(method.equals("write")){
			//retval = handleWrite(w,items);
			retval = handleWrite(dcmg, items);
			return retval;
		}
		else{
			System.out.println("invalid method type");
			return null;
		}
		
	}
	
	public static String handleWrite(DCMGmodel dcmg, String[] items){
		try{
			//System.out.println("handleWrite() called");
			List<String> tagNames = new ArrayList<String>();
			List<Object> tagValues = new ArrayList<Object>();

			for(int i = 2; i < items.length; i++){
				String[] parts = items[i].split(":");
				//System.out.print(String.format("parts: %s , %s",parts[0], parts[1]));
				tagNames.add(parts[0].trim());
				if(parts[1].trim().equals("true") || parts[1].trim().equals("True")){
					//System.out.println("we're supposed to write true");
					tagValues.add(new Boolean(true));
				}
				else if(parts[1].trim().equals("false") || parts[1].trim().equals("False")){
					//System.out.println("we're supposed to write false");
					tagValues.add(new Boolean(false));
				}
				else{
					//System.out.println("we're supposed to write a float");
					tagValues.add(Float.parseFloat(parts[1]));
				}
			}
			//System.out.println("after for loop in write");

			String[] nameArray = new String[tagNames.size()];
			tagNames.toArray(nameArray);
			Object[] valueArray = new Object[tagValues.size()];
			tagValues.toArray(valueArray);
			
			if(nameArray.length == 1){
				String[] parts = items[2].split(":");
				//w.writeTag(parts[0], parts[1]);  //commented for testing
				writeModelTag(dcmg,nameArray[0],valueArray[0]);
				
				//System.out.println(parts[0].toString());
				//System.out.println(parts[1].toString());
			}
			else if(nameArray.length > 1){
				//w.writeTags(nameArray, valueArray); //commented for testing
				writeModelTags(dcmg,nameArray,valueArray);
				
				//System.out.println(nameArray.toString());
				//System.out.println(valueArray.toString());
			}
			else{
				return null;
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}	
		return null;
	}
	
	public static String handleRead(DCMGmodel dcmg, String[] items){
		try{
			//System.out.println("handleRead() called");
			List<String> tagNames = new ArrayList<String>();
			
			for(int i = 2;i < items.length; i++){
				tagNames.add(items[i].trim());
			}
			String[] nameArray = new String[tagNames.size()];
			tagNames.toArray(nameArray);

			//System.out.print(String.format("%d", nameArray.length));
			if(nameArray.length == 1){
				//Object retval = w.readTag(items[2]); //commented for testing
				//Object retval = new Boolean("true");   //inserted for testing
				Object retval = readModelTag(dcmg,nameArray[0]);
				String output = String.format("%s:%s\n", nameArray[0] ,retval.toString());
				return output;
			}
			else if(nameArray.length > 1){
				//Object[] retval = w.readTags(nameArray); //commented for testing
				//Object[] retval = {new Boolean(false), new Boolean(true)};
				Object[] retval = readModelTags(dcmg,nameArray);
				String output = "";
				for(int j = 0;j < retval.length; j++){					
					output = output.concat(String.format("%s:%s",nameArray[j],retval[j].toString()));
					if(j != retval.length - 1){
						output = output.concat(",");
					}
					//System.out.println(output);
				}
				output = output.concat("\n");
				return output;
			}
			else{
				System.out.println("read returned null :(");
				return null;
			}

		}
		catch(Exception e){
			System.out.println(e);
		}
		//System.out.println("got to end of handle read but shouldn't have");
		return null;
	}
	
	public static Object[] readModelTags(DCMGmodel dcmg, String[] tags){
		//System.out.println("readModelTags(); called");
		Object[] results = new Object[tags.length];
		Object[] dummyvals = new Object[1];
		results = dcmg.fakeinterface("read",tags,dummyvals);
		
		return results;
	}
	
	public static Object readModelTag(DCMGmodel dcmg, String tag){
		//System.out.println("readModelTag() called");
		Object result = new Object();
		Object[] dummyvals = new Object[1];
		String[] tags = new String[1];
		tags[0] = tag;
		Object[] results = dcmg.fakeinterface("read", tags, dummyvals);
		result = results[0];
		//System.out.println(result);
		return result;		
	}
	
	public static void writeModelTag(DCMGmodel dcmg, String tag, Object value){
		//System.out.println("writeModelTag() called");
		Object[] values = new Object[1];
		String[] tags = new String[1];
		values[0] = value;
		tags[0] = tag;
		dcmg.fakeinterface("write", tags, values);
		//System.out.println("writeModelTag() returning");
	}
	
	public static void writeModelTags(DCMGmodel dcmg, String[] tags, Object[] values){
		//System.out.println("writeModelTags() called");
		dcmg.fakeinterface("write", tags, values);
		//System.out.println("writeModelTags() returning");
	}
	
	

}