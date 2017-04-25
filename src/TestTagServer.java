import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestTagServer{
	public static void main(String[] args){

		try{
			String queries[] = {"read user BRANCH_1_BUS_1_LOAD_1_User",
					"write user BRANCH_1_BUS_1_LOAD_1_User:false",
					"read user BRANCH_1_BUS_1_LOAD_1_User",
					"read user BRANCH_1_BUS_1_LOAD_1_User BRANCH_1_BUS_2_LOAD_1_User",
					"write user BRANCH_1_BUS_1_LOAD_1_User:true BRANCH_1_BUS_2_LOAD_1_User:false",
					"read user BRANCH_1_BUS_1_LOAD_3_Current"};
			for(int i = 0; i < queries.length; i++){	
				Socket tsocket = new Socket("127.0.0.1",12897);
				PrintWriter tquery = new PrintWriter(tsocket.getOutputStream(),true);
				BufferedReader tin = new BufferedReader(new InputStreamReader(tsocket.getInputStream()));
				System.out.println("\ncreated test socket");

				if(tsocket != null && tquery != null && tin != null){
					System.out.println("Beginning to write");

					System.out.println(String.format("new query: %s",queries[i]));
					tquery.println(queries[i]);
					System.out.println("query sent");
					System.out.println("do we get here?");
					String responseLine = null;
					/*
					while((responseLine = tin.readLine())!= null){
						System.out.println(responseLine);
					}
					//responseLine = tin.readLine();
					*/					
					
					if(tin.ready()){
						System.out.println("ready to read");
						responseLine = tin.readLine();
					}
					
					//responseLine = "ok";
					System.out.println(String.format("server says: %s",responseLine));

					try{
						Thread.sleep(2000);
					}
					catch(Exception e){
						System.out.println(e);
					}

					tquery.close();
					tin.close();
					tsocket.close();

				}
			}					
		}
		catch(UnknownHostException e){
			System.out.println("trying to connect to unknown host");
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}