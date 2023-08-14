
import java.sql.*;
public class items {
	public static void main(String[]args)throws Exception{
		select();
	}
	public void getconnectivity() throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/Pastry";
		String username="root";
		String password="1101";
		String Query="insert into products values(?,?,?,?,?,?)";
		
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(Query);
		pst.setInt(1,16);
		pst.setString(2,"Cookies");
		pst.setString(3,"10");
		pst.setString(4,"03-06-23");
		pst.setString(5,"02-06-23");
		pst.setInt(6,70);
		pst.executeUpdate();
		con.close();
	}
	
	public static void selectall() throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/Pastry";
		String username="root";
		String password="1101";
		String Query="select*from products";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(Query);
		while(rs.next()) {
			System.out.println("product id:"+rs.getInt(1));
			System.out.println("product name:"+rs.getString(2));
			System.out.println("product quantity:"+rs.getString(3));
			System.out.println("product manufacdate:"+rs.getString(4));
			System.out.println("product expdate:"+rs.getString(5));
			System.out.println("product price:"+rs.getString(6));
		}
		
		con.close();
	}
	
	public static void update() throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/Pastry";
		String username="root";
		String password="1101";
		String Query="update products set name='Cupcake' where id=15 ";
		String Query1="update products set quantity=2 where id=15 ";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(Query1);
		int pastryitems=pst.executeUpdate();
		System.out.println(pastryitems);
		con.close();
	}
	
	public static void delete() throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/Pastry";
		String username="root";
		String password="1101";
		String Query="delete from products where id=13 ";
		
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(Query);
		int pastryitems=pst.executeUpdate();
		System.out.println(pastryitems);
		con.close();
	}
	public static void select() throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/Pastry";
		String username="root";
		String password="1101";
		String Query="select*from products where price=70 ";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(Query);
		while(rs.next()) {
			String pastry=rs.getString("name");
			int items=rs.getInt("quantity");
			System.out.println("product name:"+pastry);
			System.out.println("product quantity:"+items);
		}
		
		con.close();
	}
}
