package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DatabaseDrive.Conn;
import entity.AbroadApplyRecord;
import dao.Countrydao;

public class AbroadApplyRecorddao {
	
	public static boolean ApplyAudits(int number,String auditstate) throws Exception{
		Connection conn = Conn.getConnection();
		String sql="" +
				" update  ai "+
				"set audits=?"+
				"where number=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, auditstate);
		ptmt.setInt(2, number);
		ptmt.execute();
		return true;
		}
	
	//查询个人出国信息
	public static SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
	public static List<AbroadApplyRecord> getMyApply(String id) throws Exception{
		List<AbroadApplyRecord> applys = new ArrayList<AbroadApplyRecord>();
		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from ai "+
				"where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			AbroadApplyRecord apply = new AbroadApplyRecord();
			apply.setSerialNum(rs.getInt("number"));
			apply.setUserId(rs.getString("id"));
			apply.setUserName(rs.getString("name"));
			apply.setApplyTime(rs.getString("applytime"));
			String country = Countrydao.coun[rs.getInt("country_1")-1];
			String a ="country_";
			for(int i=2;i<=5;i++){
				if(rs.getInt(a+i)!=0){
					country=country+"，"+Countrydao.coun[rs.getInt(a+i)-1];
				}
				else{
					break;
				}
			}
			apply.setCountry(country);
			
			apply.setReasontype(rs.getString("reason"));			
			apply.setBeginTime(sdf.format(rs.getDate("begintime")));
			apply.setEndTime(sdf.format(rs.getDate("backtime")));
			apply.setFundSource(rs.getString("fs"));
			apply.setReasonDetails(rs.getString("ac"));
			apply.setAbroadState(rs.getString("sa"));
			apply.setAuditState(rs.getString("audits"));
			applys.add(apply);
			}
			return applys;
		}
		
		//查询全部出国信息
		public static List<AbroadApplyRecord> getAllApply() throws Exception{
			List<AbroadApplyRecord> applys = new ArrayList<AbroadApplyRecord>();

			Connection conn = Conn.getConnection();
			String sql="" +
					" select * from ai ";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				AbroadApplyRecord apply = new AbroadApplyRecord();
				apply.setSerialNum(rs.getInt("number"));
				apply.setUserId(rs.getString("id"));
				apply.setUserName(rs.getString("name"));
				apply.setApplyTime(rs.getString("applytime"));
				String country = Countrydao.coun[rs.getInt("country_1")-1];
				String a ="country_";
				for(int i=2;i<=5;i++){
					if(rs.getInt(a+i)!=0){
						country=country+"，"+Countrydao.coun[rs.getInt(a+i)-1];
					}
					else{
						break;
					}
				}
				apply.setCountry(country);
				apply.setReasontype(rs.getString("reason"));
				apply.setBeginTime(sdf.format(rs.getDate("begintime")));
				apply.setEndTime(sdf.format(rs.getDate("backtime")));
				apply.setFundSource(rs.getString("fs"));
				apply.setReasonDetails(rs.getString("ac"));
				apply.setAbroadState(rs.getString("sa"));

				apply.setAuditState(rs.getString("audits"));
				applys.add(apply);
			}
			return applys;
		}
		
		//删除出国申请
		public static boolean delete(int number) throws Exception{
			Connection conn = Conn.getConnection();
			String sql="" +
					" delete from ai " +
					" where number=? ";
			PreparedStatement ptmt=conn.prepareStatement(sql);	
			ptmt.setInt(1, number);
			ptmt.executeUpdate();
			return true;
		}
		
		public static boolean addApply(AbroadApplyRecord apply) throws Exception{
			Connection conn = Conn.getConnection();
			String sql = " ";
			if(apply.getSerialNum()==0)
				 sql =""+
					"insert into ai(id,name ,reason,country_1,country_2,country_3,country_4,country_5, begintime,backtime,fs,sa,ac,audits,applytime) "+
					"values("+
					"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			else
				 sql =""+
					"insert into ai(id,name ,reason,country_1,country_2,country_3,country_4,country_5, begintime,backtime,fs,sa,ac,audits,applytime,number) "+
					"values("+
					"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, apply.getUserId());
			ptmt.setString(2, apply.getUserName());
			ptmt.setString(3, apply.getReasontype());
			String country[]=apply.getCountry().split("，");
			
			String a ="country_";
			for(int i=0;i<5;i++){
				if(i>=country.length){
					ptmt.setInt(i+4, 0 );
				}
				else{
					int j=0;
					for(;j<Countrydao.coun.length;j++){
						if(country[i].equals(Countrydao.coun[j])){
							break;
						}
						
					}
					ptmt.setInt(i+4, j+1);
				}
			}
			java.util.Date date= sdf.parse(apply.getBeginTime());
			ptmt.setDate(9, new java.sql.Date(date.getTime()));
			ptmt.setDate(10, new java.sql.Date(sdf.parse(apply.getEndTime()).getTime()));
			ptmt.setString(11, apply.getFundSource());
			ptmt.setString(12, apply.getAbroadState());
			ptmt.setString(13, apply.getReasonDetails());
			ptmt.setString(14, apply.getAuditState());
			ptmt.setString(15, apply.getApplyTime());
			if(apply.getSerialNum()!=0)
				ptmt.setInt(16, apply.getSerialNum());
			ptmt.execute();
			return true;
			
		}
		
		
		//修改出国申请
		public static boolean motify(AbroadApplyRecord apply) throws Exception{
			delete(apply.getSerialNum());
			addApply(apply);
			return true;
		}
		
		//待审核信息
		public static List<AbroadApplyRecord> getAudits() throws Exception{
			List<AbroadApplyRecord> applys = new ArrayList<AbroadApplyRecord>();
			Connection conn = Conn.getConnection();
			String sql="" +
					" select * from ai "+
					"where audits = '待审核' ";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				AbroadApplyRecord apply = new AbroadApplyRecord();
				apply.setSerialNum(rs.getInt("number"));
				apply.setUserId(rs.getString("id"));
				apply.setUserName(rs.getString("name"));
				apply.setApplyTime(rs.getString("applytime"));
				String country = Countrydao.coun[rs.getInt("country_1")-1];
				String a ="country_";
				for(int i=2;i<=5;i++){
					if(rs.getInt(a+i)!=0){
						country=country+","+Countrydao.coun[rs.getInt(a+i)-1];
					}
					else{
						break;
					}
				}
				apply.setCountry(country);
				
				apply.setReasontype(rs.getString("reason"));			
				apply.setBeginTime(sdf.format(rs.getDate("begintime")));
				apply.setEndTime(sdf.format(rs.getDate("backtime")));
				apply.setFundSource(rs.getString("fs"));
				apply.setReasonDetails(rs.getString("ac"));
				apply.setAbroadState(rs.getString("sa"));
				apply.setAuditState(rs.getString("audits"));
				applys.add(apply);
				}
				return applys;
			}
}
