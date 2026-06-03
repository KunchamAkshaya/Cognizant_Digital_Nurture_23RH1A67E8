import java.io.*;import java.net.*;
public class Server{
 public static void main(String[] a)throws Exception{
  ServerSocket ss=new ServerSocket(5000);
  Socket s=ss.accept();
  BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
  PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
  System.out.println("Client: "+br.readLine());
  pw.println("Hello Client");
 }}