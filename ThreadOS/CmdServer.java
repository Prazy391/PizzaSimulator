import java.net.*;
import java.util.Scanner;
import java.io.*;
public class CmdServer extends Thread
{
    ServerSocket sock;
    int port = 5000;

    public void run(){
        try {
            while(true){
                if(port > 5500)
                    port = 5000;
                
                sock = new ServerSocket(port);
                System.out.println("Listening on socket "+sock.getLocalPort());
                /* now listen for connections */
                Socket client = sock.accept();
                Runner(client);    
                /* close the socket and resume */
                /* listening for connections */ 
            }           
        }
        catch(IOException ioe){
            if(ioe instanceof BindException){
                port++;
                run();
            }
            else{
                System.err.println(ioe);
            }
        }
    }

    public static void Runner(Socket client) throws IOException{
        while(true){
            InputStream in = client.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String reverseLine = "";
            String line;
            while((line = bin.readLine()) != null){
                if(line.contains("bye") || line.contains("exit")){
                    SysLib.exit();
                }
                if(line.contains("whoami")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                if(line.contains("ls")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                if(line.contains("pwd")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                if(line.contains("ps")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                if(line.contains("man")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                if(line.contains("echo")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                if(line.contains("date")){
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(line);
                    BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));
                    String s = "";
                    String out = "";
                    while((s = stdInput.readLine()) != null){
                        out = out+" "+s;
                    }
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(out);
                    Runner(client);
                    break;
                }
                for(int i = line.length() - 1; i >= 0 ; i--){
                    reverseLine = reverseLine+""+line.charAt(i);
                }
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                pout.println(reverseLine);
                Runner(client);
            }
        }
    }
    
}
