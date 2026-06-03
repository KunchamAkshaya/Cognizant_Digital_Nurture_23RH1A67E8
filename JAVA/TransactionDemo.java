import java.sql.*;
public class TransactionDemo{
 public static void main(String[] args)throws Exception{
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
  con.setAutoCommit(false);
  try{
   PreparedStatement d=con.prepareStatement("UPDATE accounts SET balance=balance-100 WHERE id=1");
   PreparedStatement c=con.prepareStatement("UPDATE accounts SET balance=balance+100 WHERE id=2");
   d.executeUpdate(); c.executeUpdate();
   con.commit();
   System.out.println("Transfer Successful");
  }catch(Exception e){ con.rollback(); }
 }
}