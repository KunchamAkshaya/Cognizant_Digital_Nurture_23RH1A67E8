public class VirtualThreadDemo{
 public static void main(String[] a){
  for(int i=1;i<=1000;i++){
   int id=i;
   Thread.startVirtualThread(()->System.out.println("VT "+id));
  }
 }}