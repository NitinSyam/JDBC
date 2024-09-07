import java.sql.*;
public class Test {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "#ma09ni16#");
            
            String sql = "delete Student where rank > ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 75000);
            System.out.println(pstmt.executeUpdate() + " row(s) deleted");
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
