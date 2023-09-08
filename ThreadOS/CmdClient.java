
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CmdClient extends Thread {
    int Currport;

    public CmdClient(String[] argv){
        Currport = Integer.parseInt(argv[0]);
    }


    public void run(){
        try{
            Socket sock = new Socket("localhost", Currport);
            System.out.println(sock.isConnected());
            while(true){
                Runner(sock);
            }
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
        SysLib.exit();
    }

    public static void Runner(Socket sock) throws IOException{
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter word");
            String curr = scan.nextLine();
            System.out.println(sock.isConnected());
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            pout.println(curr);  
            if(curr.contains("bye")){
                sock.close();
            }      
            InputStream in = sock.getInputStream();
            Scanner reader = new Scanner(new InputStreamReader(in));
            PrintWriter print = new PrintWriter("output.txt");
            while(reader.hasNext()){
                System.out.println(reader.nextLine());
                Runner(sock);
            }
        }
        catch(Exception r){
            throw r;
        }
    }

}
