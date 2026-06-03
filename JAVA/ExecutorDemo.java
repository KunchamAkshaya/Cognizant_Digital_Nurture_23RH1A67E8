import java.util.concurrent.*;
public class ExecutorDemo{
 public static void main(String[] a)throws Exception{
  ExecutorService ex=Executors.newFixedThreadPool(3);
  Future<Integer> f1=ex.submit(()->10);
  Future<Integer> f2=ex.submit(()->20);
  Future<Integer> f3=ex.submit(()->30);
  System.out.println(f1.get()); System.out.println(f2.get()); System.out.println(f3.get());
  ex.shutdown();
 }}