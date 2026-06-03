import java.sql.*;
public class JdbcSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("age"));
            }
            con.close();
        } catch(Exception e){ e.printStackTrace(); }
    }
}