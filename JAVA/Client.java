import java.io.*;import java.net.*;
public class Client{
 public static void main(String[] a)throws Exception{
  Socket s=new Socket("localhost",5000);
  BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
  PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
  pw.println("Hello Server");
  System.out.println(br.readLine());
 }}