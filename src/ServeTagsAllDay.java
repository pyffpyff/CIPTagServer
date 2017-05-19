import com.ab.gti.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ServeTagsAllDay{
	public static void main(String[] args){
		int lpnum = 12897;
		String line;
		String retval;

		try{
			//create listening socket
			ServerSocket tserver = new ServerSocket(lpnum);
			String[] userargs = {"-jucs","cip://2:192.168.56.10/1:4","-gtiServerPort", "4000"};
			String[] SGargs = {"-jucs","cip://2:192.168.56.122/1:4","-gtiServerPort", "4000"};
			Wrapper SG = new Wrapper(SGargs);
			Wrapper user = new Wrapper(userargs);
			System.out.println("Should be connected");

			while(true){
				try{
					Socket tclient = tserver.accept();
					BufferedReader reqstream = new BufferedReader(new InputStreamReader(tclient.getInputStream()));
					PrintWriter outstream = new PrintWriter(tclient.getOutputStream(),true);
					
					line = reqstream.readLine();
					
					retval = processInput(SG,user,line);
					
					outstream.println(retval);					
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

	public static String processInput(Wrapper SG, Wrapper user, String req){
		try{
			String[] items = req.split(" ");
			String method = items[0];
			String plc = items[1];
			
			String retval;
			
			if(plc.equals("SG")){
				retval = processMore(SG,method,items);
				return retval;
			}
			else if(plc.equals("user")){
				retval = processMore(user,method,items);
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
		return null;
	}
	
	public static String processMore(Wrapper w, String method, String[] items){
		String retval;
		if(method.equals("read")){
			retval = handleRead(w,items);
			return retval;
		}
		else if(method.equals("write")){
			retval = handleWrite(w,items);
			return retval;
		}
		else{
			System.out.println("invalid method type");
			return null;
		}
		
	}
	
	public static String handleWrite(Wrapper w, String[] items){
		try{
			List<String> tagNames = new ArrayList<String>();
			List<Object> tagValues = new ArrayList<Object>();

			for(int i = 2; i < items.length; i++){
				String[] parts = items[i].split(":");
				tagNames.add(parts[0]);
				if(parts[1].equals("true") || parts[1].equals("True")){
					tagValues.add(new Boolean(true));
				}
				else if(parts[1].equals("false") || parts[1].equals("False")){
					tagValues.add(new Boolean(false));
				}
				else{
					tagValues.add(Float.parseFloat(parts[1]));
				}
			}

			String[] nameArray = new String[tagNames.size()];
			tagNames.toArray(nameArray);
			Object[] valueArray = new Object[tagValues.size()];
			tagValues.toArray(valueArray);
			
			if(nameArray.length == 1){
				//String[] parts = items[2].split(":");
				w.writeTag(nameArray[0], valueArray[0]);  //commented for testing
				System.out.println(nameArray[0].toString());
				System.out.println(valueArray[0].toString());
			}
			else if(nameArray.length > 1){
				w.writeTags(nameArray, valueArray); //commented for testing
				System.out.println(nameArray.toString());
				System.out.println(valueArray.toString());
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
	
	public static String handleRead(Wrapper w, String[] items){
		try{
			System.out.println("handleRead() called");
			List<String> tagNames = new ArrayList<String>();
			
			for(int i = 2;i < items.length; i++){
				tagNames.add(items[i]);
			}
			String[] nameArray = new String[tagNames.size()];
			tagNames.toArray(nameArray);

			System.out.print(String.format("%d", nameArray.length));
			if(nameArray.length == 1){
				Object retval = w.readTag(items[2]); //commented for testing
				String output = String.format("%s:%s\n", items[2] ,retval.toString());
				return output;
			}
			else if(nameArray.length > 1){
				Object[] retval = w.readTags(nameArray); //commented for testing
				String output = "";
				for(int j = 0;j < retval.length; j++){					
					output = output.concat(String.format("%s:%s",nameArray[j],retval[j].toString()));
					if(j != retval.length - 1){
						output = output.concat(",");
					}
					System.out.println(output);
				}
				output = output.concat("\n");
				return output;
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

}