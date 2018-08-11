package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import connection.MyConnection;

public class UserDao {
	private Connection con=MyConnection.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	public User authenticate(String uname,String pswd)
	{
		User ub = null;
		try {
			ps = con.prepareStatement("select * from users where username = ? and password = ?");
			ps.setString(1, uname);
			ps.setString(2, pswd);
			rs = ps.executeQuery();
			if(rs.next())
			{
				ub = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			
			}
			else{
				System.out.println("invalid...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ub;
	}

	public boolean addUser(String uname, String pswd,int userid)
	{
		boolean flag=false;
		try {
			ps = con.prepareStatement("insert into users values(?,?,?)");
			ps.setInt(1,userid);
			ps.setString(2, uname);
			ps.setString(3, pswd);
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println("user entered");
				flag = true;
			}
			else {System.out.println("user not entered");
			flag =  false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
}
}
