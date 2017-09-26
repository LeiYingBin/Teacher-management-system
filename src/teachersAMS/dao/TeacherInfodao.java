package teachersAMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;

import DatabaseDrive.Conn;

public class TeacherInfodao {
	HashMap<String,String> hm= new HashMap<String,String>();
	public TeacherInfodao(){
		hm.put("tId", "id");
		hm.put("tName", "name");
		hm.put("tSex", "sex");
		hm.put("tBirthday", "birthday");
		hm.put("tTitle", "title");
		hm.put("tDepartment", "college");
		hm.put("tEducation", "education");
	}
	public String selectTInfoField(String field, String userId) throws Exception{
		String result = "";
		String dbfield= hm.get(field);
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from  teacher" +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, userId);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			result=rs.getString(dbfield);
		}
		return result;
		
	}
	public boolean updateTInfoField(String field, String userId,String value) throws Exception{
		String dbfield= hm.get(field);
		Connection conn = Conn.getConnection();
		String sql=""+
				"update teacher "+
				"set "+dbfield+" =?"+
				" where id =?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, value);
		ptmt.setInt(2, Integer.parseInt(userId));
		boolean result= ptmt.execute();
		return result;
		
	}
	public boolean deleteTInfo(String userId) throws Exception{
		Connection conn = Conn.getConnection();
		String sql="" +
				" delete from teacher " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, userId);	
		ptmt.execute();
		return true;
		
	}
	public boolean insertTInfo(HashMap<String,String> teacher) throws Exception{
		Connection conn = Conn.getConnection();
		String sql =""+
				"insert into teacher "+
				"values("+
				"?,?,?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, teacher.get("tId"));
		ptmt.setString(2, teacher.get("tName"));
		ptmt.setString(3, teacher.get("tSex"));
		ptmt.setString(4, teacher.get("tBirthday"));
		ptmt.setString(5, teacher.get("tTitle"));
		ptmt.setString(6, teacher.get("tDepartment"));
		ptmt.setString(7, teacher.get("tEducation"));
		ptmt.execute();
		return true;
		
	}
	/**
	 * 返回指定数量条教师信息记录
	 * @param quantity 若quantity 为零，则 返回全部
	 * @return HashMap 数组， 键值类型都为 String
	 * @throws Exception 
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?>[] selectTInfo(int quantity) throws Exception{
		HashMap<?,?>[] result= new HashMap<?,?>[quantity];
		Connection conn = Conn.getConnection();
		String sql="" +
				"select * from teacher ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		int flag=0;
		if(rs.last()&&quantity==0){
			
			result=new HashMap<?,?>[rs.getRow()] ;
		}
		rs.beforeFirst();
		while(rs.next()){
			HashMap<String,String> a = new HashMap<String,String>();
			if(flag==quantity&&quantity!=0)
				break;
			a.put("tId", rs.getString(hm.get("tId")));
			a.put("tName", rs.getString(hm.get("tName")));
			a.put("tSex", rs.getString(hm.get("tSex")));
			a.put("tBirthday", rs.getString(hm.get("tBirthday")));
			a.put("tTitle", rs.getString(hm.get("tTitle")));
			a.put("tDepartment", rs.getString(hm.get("tDepartment")));
			a.put("tEducation", rs.getString(hm.get("tEducation")));
			
			result[flag]=a;
			flag++;
		}
		return result;
		

		
	}
	/**
	 * 返回指定教师的信息记录
	 * @param userId
	 * @return HashMap 数组， 键值类型都为 String
	 * @throws Exception 
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<String,String> selectTInfo(String userId) throws Exception{
		HashMap<String,String> teacher = new HashMap<String,String>();
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from  teacher" +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, userId);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			teacher.put("tId", rs.getString(hm.get("tId")));
			teacher.put("tName", rs.getString(hm.get("tName")));
			teacher.put("tSex", rs.getString(hm.get("tSex")));
			teacher.put("tBirthday", rs.getString(hm.get("tBirthday")));
			teacher.put("tTitle", rs.getString(hm.get("tTitle")));
			teacher.put("tDepartment", rs.getString(hm.get("tDepartment")));
			teacher.put("tEducation", rs.getString(hm.get("tEducation")));
		}
		return teacher;
	}
}
