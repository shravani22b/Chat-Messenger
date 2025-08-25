import java.net.*;
import java.io.*;

class Client 
{
    public static void main(String Arg[]) 
    {
        System.out.println("Client application is running...");

        try 
        {
            Socket sobj = new Socket("localhost", 2100);

            System.out.println("Connection established with the server..");

            PrintStream ps = new PrintStream(sobj.getOutputStream());

            BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
                                                                                                
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            String str1, str2;
            System.out.println("Chat Massanger application started...");

            while (!(str1 = br2.readLine()).equals("end")) 
            {
                ps.println(str1);
                str2 = br1.readLine();

                if (str2 == null) 
                { 
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server says : " + str2);
                System.out.println("Enter the message for server : ");
                
            }
            ps.println("end");

            System.out.println("Thank you for using the Chat Application..");

            br1.close();
            br2.close();
            ps.close();
            sobj.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

