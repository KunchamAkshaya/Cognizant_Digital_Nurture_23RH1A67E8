import java.lang.reflect.*;
public class ReflectionDemo{
 public static void main(String[] a)throws Exception{
  Class<?> c=Class.forName("Student");
  for(Method m:c.getDeclaredMethods()) System.out.println(m.getName());
  Object o=c.getDeclaredConstructor().newInstance();
  c.getMethod("display").invoke(o);
 }}