package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DatabaseDrive.Conn;
import entity.UserAccount;

public class UserAccountdao {
	
	//²éÑ¯Ò»¸öuser
		public static UserAccount getUser(String id) throws Exception{
			UserAccount user = new UserAccount();
			Connection conn = Conn.getConnection();
			String sql="" +
	   				" select * from users " +
					" where id=? ";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				user.setUserId(rs.getString("id"));
				user.setUserName(rs.getString("name"));
				user.setUserPwd(rs.getString("passwords"));
				user.setRole(rs.getString("roles"));
			}
			return user;
		}
		
		public static List<UserAccount> getAllUser() throws Exception{
			List<UserAccount> userAccounts = new ArrayList<UserAccount>();

			Connection conn = Conn.getConnection();
			String sql="" +
					" select * from users ";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				UserAccount user = new UserAccount();
				user.setUserId(rs.getString("id"));
				user.setUserName(rs.getString("name"));
				user.setUserPwd(rs.getString("passwords"));
				user.setRole(rs.getString("roles"));
				userAccounts.add(user);
			}
			return userAccounts;
		}
		
		public static boolean delete(String id) throws Exception{
			Connection conn = Conn.getConnection();
			String sql="" +
					" delete from users " +
					" where id=? ";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.execute();
			return true;
		}
		public static boolean addUser(UserAccount user) throws Exception{
			Connection conn = Conn.getConnection();
			String sql =""+
					"insert into users "+
					"values("+
					"?,?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, user.getUserId());
			ptmt.setString(2, user.getUserPwd());
			ptmt.setString(3, user.getUserName());
			ptmt.setString(4, user.getRole());
			ptmt.execute();
			return true;
		}
		public static boolean modify(UserAccount user) throws Exception{
			delete(user.getUserId());
			addUser(user);
			return true;
		}
}
