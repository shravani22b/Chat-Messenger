import java.net.*;
import java.io.*;

class Server 
{
    public static void main(String Arg[]) 
    {
        System.out.println("Server application is running...");

        try 
        {
            ServerSocket ssobj = new ServerSocket(2100);
            System.out.println("Server is waiting for client at port number 2100");

            Socket sobj = ssobj.accept(); 
            System.out.println("Connection established with the client..");

            PrintStream ps = new PrintStream(sobj.getOutputStream());

            BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
                                                                                                  

            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            String str1, str2;
            System.out.println("Chat Massanger application started...");

            while ((str1 = br1.readLine()) != null) 
            {

                if (str1.equalsIgnoreCase("end")) 
                {
                    System.out.println("Client ended the chat.");
                    break;
                }
                System.out.println("Client says : " + str1);
                System.out.println("Enter message for client : ");
                str2 = br2.readLine();
                ps.println(str2);
            }
            System.out.println("Thank you for using the Chat Application..");

        
            br1.close();
            br2.close();
            ps.close();
            sobj.close();
            ssobj.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
