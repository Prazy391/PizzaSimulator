
import java.io.*;
import java.net.*;

public class DateClient extends Thread {
    int Currport;

    public DateClient(String[] argv){
        Currport = Integer.parseInt(argv[0]);
    }


    public void run(){
        try{
            Socket sock = new Socket("localhost", Currport);
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            String line;
            while((line = bin.readLine()) != null){
                System.out.println(line);
            }
            sock.close();
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
        SysLib.exit();
    }

}
