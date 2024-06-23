import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ser=new ServerSocket(1234); //Port number passed
			
			System.out.println("\n SERVER WAITING.... ");
			Socket client=ser.accept();
			
			System.out.println("\n CLIENT CONNECTED.... ");
			
			InetAddress ip=client.getInetAddress(); // InetAddress is used to print information
			
			System.out.println("\n Address : "+ip.getHostAddress());
			System.out.println("\n Name : "+ip.getHostName());
			
			System.out.println("\n Name : "+ip.getLocalHost());
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			
			Scanner scan=new Scanner(System.in);
			String str="";
			
			//dos.writeUTF("WELCOME CLIENT.... ");
			
			while(!str.equals("QUIT"))
			{
				System.out.println("\n MSG FOR CLIENT : ");
				str=scan.nextLine();
				dos.writeUTF(str);
				
				str=dis.readUTF();
				System.out.println("\n MSG FROM CLIENT : "+str);
			}
			
			dis.close();
			dos.close();
			client.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SERVER ERROR : "+e.getMessage());
		}
	}
}
