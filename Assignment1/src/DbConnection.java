import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author manaswee
 *
 */
public class DbConnection {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manaswee","root", "admin");
		
	     st = con.createStatement();
		
		 rs= st.executeQuery("SELECT * FROM medical_record");
		 
		 ResultSetMetaData rs1 =rs.getMetaData();
			for(int i=1; i<=rs1.getColumnCount() ; i++){
				System.out.print(rs1.getColumnName(i)+"\t ");
			}
			System.out.println();
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getString(4));
		}

	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			rs.close();
			st.close();
			con.close();
		}
	}

}
