package dhbw.verteilteSysteme.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	private static void handleConnection(Socket client) throws IOException{
    	Scanner in = new Scanner (client.getInputStream());
    	PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    	
    	String input = in.nextLine();
    	
    	out.println(String.format("You entered: %s", input));
    }
    public static void main( String[] args ) throws IOException
    {
        ServerSocket server = new ServerSocket(4321);
        
        while(true){
        	Socket client = null;
        	
        	try{
        		client = server.accept();
        		handleConnection(client);
        	} catch (IOException e){
        		e.printStackTrace();
        	} finally{
        		if (client != null){
        			try{
        				client.close();
        			}catch (IOException e){
        				
        			}
        		}
        	}
        }
        
    }
    
}
