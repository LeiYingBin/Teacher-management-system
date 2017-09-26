package teachersAMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import DatabaseDrive.Conn;

public class UserAccountdao {
	HashMap<String,String> hm= new HashMap<String,String>();
	public UserAccountdao(){
		hm.put("userId", "id");
		hm.put("userName", "name");
		hm.put("userPwd", "passwords");
		hm.put("role", "grants");
	}
	public String selectUserAccountField(String field, String userId) throws Exception{
		String result = "";
		Connection conn = Conn.getConnection();
		String sql=""+
				" select * from users "+
				"where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, Integer.parseInt(userId));
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			result=rs.getString(hm.get(field));
		}
		return result;
		
	}
	public boolean updateUserAccountField(String field, String userId,String value) throws Exception{
		String dbfield = hm.get(field);
		Connection conn = Conn.getConnection();
		String sql="" +
				" update users " +
				"set "+dbfield+"=?"+
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, value);
		ptmt.setInt(2, Integer.parseInt(userId));
		ptmt.execute();
		
		return true;
		
	}
	public boolean deleteUserAccount(String userId) throws Exception{
		Connection conn = Conn.getConnection();
		String sql="" +
				" delete from users " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, userId);
		ptmt.execute();
		return true;
		
	}
	public boolean insertUserAccount(HashMap<String,String> AUser) throws Exception{
		Connection conn = Conn.getConnection();
		String sql =""+
				"insert into users "+
				"values("+
				"?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, AUser.get("userId"));
		ptmt.setString(2, AUser.get("userPwd"));
		ptmt.setString(3, AUser.get("userName"));
		ptmt.setString(4,AUser.get("role"));
		ptmt.execute();
		return true;
		
	}
	/**
	 * 返回指定数量条用户信息记录
	 * @param quantity 若quantity 为零，则 返回全部
	 * @return HashMap 数组， 键值类型都为 String
	 * @throws Exception 
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?>[] selectUserAccount(int quantity) throws Exception{
		HashMap<?,?>[] mapa = new HashMap<?,?>[quantity];
		Connection conn = Conn.getConnection();
		String sql="" +
				"select * from users ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		int flag=0;
		if(rs.last()&&quantity==0){
			mapa=new HashMap<?,?>[rs.getRow()] ;
		}
		rs.beforeFirst();
		while(rs.next()){
			HashMap<String,String> a = new HashMap<String,String>();
			if(flag==quantity&&quantity!=0)
				break;
			a.put("userId", rs.getString(hm.get("userId")));
			a.put("userName", rs.getString(hm.get("userName")));
			a.put("userPwd", rs.getString(hm.get("userPwd")));
			a.put("role", rs.getString(hm.get("role")));
			mapa[flag]=a;
			flag++;
		}
		return mapa;
		
	}
	/**
	 * 返回指定用户的信息记录
	 * @param userId
	 * @return HashMap 数组， 键值类型都为 String
	 * @throws Exception 
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<String,String> selectUserAccount(String userId) throws Exception{
		HashMap<String,String> user = new HashMap<String,String>();
		Connection conn = Conn.getConnection();
		String sql="" +
   				" select * from users " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, userId);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			user.put("userId", rs.getString(hm.get("userId")));
			user.put("userName", rs.getString(hm.get("userName")));
			user.put("userPwd", rs.getString(hm.get("userPwd")));
			user.put("role", rs.getString(hm.get("role")));
			
		}
		return user;
		
	}
}
