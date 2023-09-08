import java.net.*;
import java.io.*;
public class DateServer extends Thread
{
    private ServerSocket sock;
    public static void main(String[] args) throws Exception{
        new DateServer();
    }

    public void run(){
        try {
            ServerSocket sock = new ServerSocket(0);
            System.out.println("Listening on socket "+sock.getLocalPort());
            /* now listen for connections */
            System.out.println("Waiting for connection" + sock.getLocalPort());
            Socket client = sock.accept();
            System.out.println("Accepted a connection from: "+ client.getInetAddress());
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            /* write the Date to the socket */
            pout.println(new java.util.Date().toString());
            /* close the socket and resume */
            client.close();
            /* listening for connections */            
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
        SysLib.exit();
    }
    
}
