package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DatabaseDrive.Conn;
import entity.Teacher;
import entity.UserAccount;

public class Teacherdao {
	public static SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
	public static Teacher getOneTeacher(String id) throws Exception{
		Teacher teacher = new Teacher();
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from  teacher" +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			teacher.settId(rs.getString("id"));
			teacher.settName(rs.getString("name"));
			teacher.settSex(rs.getString("sex"));
			teacher.settBirthday(sdf.format(rs.getDate("birthday")));
			teacher.settTitle(rs.getString("title"));
			teacher.settCollege(rs.getString("college"));
			teacher.settEducation(rs.getString("education"));
		}
		return teacher;
		
		
	}
	
	public static List<Teacher> getAllTeacher() throws Exception{
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from  teacher";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			Teacher teacher = new Teacher();
			teacher.settId(rs.getString("id"));
			teacher.settName(rs.getString("name"));
			teacher.settSex(rs.getString("sex"));
			teacher.settBirthday(sdf.format(rs.getDate("birthday")));
			teacher.settTitle(rs.getString("title"));
			teacher.settCollege(rs.getString("college"));
			teacher.settEducation(rs.getString("education"));
			teachers.add(teacher);
		}
		return teachers;
	}
	
	public static boolean delete(String id) throws Exception{
		Connection conn = Conn.getConnection();
		String sql="" +
				" delete from teacher " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, id);	
		ptmt.execute();
		return true;
	}
	
	public static boolean addTeacher(Teacher teacher) throws Exception{
		Connection conn = Conn.getConnection();
		String sql =""+
				"insert into teacher "+
				"values("+
				"?,?,?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, teacher.gettId());
		ptmt.setString(2, teacher.gettName());
		ptmt.setString(3, teacher.gettSex());
		java.util.Date date =sdf.parse(teacher.gettBirthday());
		ptmt.setDate(4, new java.sql.Date(date.getTime()));
		ptmt.setString(5, teacher.gettTitle());
		ptmt.setString(6, teacher.gettCollege());
		ptmt.setString(7, teacher.gettEducation());
		ptmt.execute();
		return true;
	}
	
	
	//ÐÞ¸Ä
	public static boolean motify(Teacher teacher) throws Exception{
		delete(teacher.gettId());
		addTeacher(teacher);
		
		return true;
	}
}
