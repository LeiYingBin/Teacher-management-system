package teachersAMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import DatabaseDrive.Conn;
import dao.Countrydao;

public class AARecorddao {
	public static SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
	HashMap<String,String> hm= new HashMap<String,String>();
	public AARecorddao(){
		hm.put("serialNum", "number");
		hm.put("userId", "id");
		hm.put("userName", "name");
		hm.put("country", "country");
		hm.put("applyTime", "applytime");
		hm.put("reasonType", "reason");
		hm.put("beginTime", "beginTime");
		hm.put("endTime", "backtime");
		hm.put("fundSource", "fs");
		hm.put("reasonDetails", "ac");
		hm.put("abroadState", "sa");
		hm.put("auditState", "audits");
	}
	
	//国家编号转化为国家名称
	public String CodePraseCountry(String codecountry){
		codecountry = codecountry.replace(',', '，');
		String intcoun[]= codecountry.split("，");
		String country = Countrydao.coun[Integer.parseInt(intcoun[0])-1];
		for(int i=1;i<5;i++){
			if(Integer.parseInt(intcoun[i])==0){
				break;
			}
			else{
				country+="，"+Countrydao.coun[Integer.parseInt(intcoun[i])-1];
			}
		}
		return country;
		
	}
	
	//国家名称转化为国家编号
		public int[] CountryPraseCode(String country){
			country = country.replace(',', '，');
			String coun[]= country.split("，");
			int  intcoun[] = {0,0,0,0,0} ; 
			for(int i=0;i<coun.length;i++){
				if(coun[i].equals(null)){
					intcoun[i]=0;
				}
				else{
					int j=0;
					for(;j<Countrydao.coun.length;j++){
						if(coun[i].equals(Countrydao.coun[j])){
							break;
						}
						
					}
					intcoun[i]=j+1;
				}
			}
			return intcoun;
			
		}
	
	public String selectAARecordField(String field, String serialNum)  throws Exception{
		String a = null;
		Connection conn = Conn.getConnection();
		String sql="" +
				" SELECT * FROM ai WHERE number = ?";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, Integer.parseInt(serialNum));
			ResultSet rs= ptmt.executeQuery();
			while(rs.next()){
				if(hm.get(field)=="country"){
					String coun= "";
					String con="country_";
					for(int i=1;i<=5;i++){
						coun=coun+rs.getInt(con+i)+"，";
					}
					a = CodePraseCountry(coun);
					
				}else
				 a =rs.getString(hm.get(field));
				 
			}
		
		return a;
	}


	public HashMap<?,?>[] selectAARecordCompelete(int quantity) throws Exception {
		// TODO Auto-generated method stub
		HashMap<?,?>[] mapa = new HashMap<?,?>[quantity];
		Connection conn = Conn.getConnection();
		String sql="" +
				"select * from ai ";
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
			a.put("serialNum", rs.getString("number"));
			a.put("userId", rs.getString("id"));
			a.put("userName", rs.getString("name"));
			a.put("reasonType", rs.getString("reason"));
			a.put("applyTime", rs.getString("applytime"));
			String coun= "";
			String con="country_";
			for(int i=1;i<=5;i++){
				coun=coun+rs.getInt(con+i)+"，";
			}
			String country = CodePraseCountry(coun);
			a.put("country", country);
			
			a.put("beginTime", rs.getString("begintime"));
			a.put("endTime", rs.getString("backtime"));
			a.put("fundSource", rs.getString("fs"));
			a.put("reasonDetails", rs.getString("ac"));
			a.put("abroadState", rs.getString("sa"));
			a.put("auditState", rs.getString("audits"));
			mapa[flag]=a;
			flag++;
		}
		return mapa;
	}


	public HashMap<?,?>[] selectAARecord(int quantity, String userId) throws Exception {
		HashMap<?,?>[] mapa = new HashMap<?,?>[quantity];
		Connection conn = Conn.getConnection();
		String sql="" +
				"select * from ai "+
				"where id = ?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, Integer.parseInt(userId));
		ResultSet rs=ptmt.executeQuery();
		int flag=0;
		if((rs.last()&&quantity==0)||rs.getRow()<quantity){
			mapa=new HashMap<?,?>[rs.getRow()] ;
		}
		rs.beforeFirst();
		while(rs.next()){
			HashMap<String,String> a = new HashMap<String,String>();
			if(flag==quantity&quantity!=0)
				break;
			a.put("serialNum", rs.getString("number"));
			a.put("userId", rs.getString("id"));
			a.put("userName", rs.getString("name"));
			a.put("reasonType", rs.getString("reason"));
			a.put("applyTime", rs.getString("applytime"));
			String coun= "";
			String con="country_";
			for(int i=1;i<=5;i++){
				coun=coun+rs.getInt(con+i)+"，";
			}
			String country = CodePraseCountry(coun);
			
			a.put("country", country);
			a.put("beginTime", rs.getString("begintime"));
			a.put("endTime", rs.getString("backtime"));
			a.put("fundSource", rs.getString("fs"));
			a.put("reasonDetails", rs.getString("ac"));
			a.put("abroadState", rs.getString("sa"));
			a.put("auditState", rs.getString("audits"));
			mapa[flag]=a;
			flag++;
		}
		return mapa;
	}


	public HashMap<?,?>[] selectAARecord(String auditState) throws Exception{

		Connection conn = Conn.getConnection();
		String sql="" +
				" select * from ai "+
				"where audits = ? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, auditState);
		ResultSet rs=ptmt.executeQuery();
		HashMap<?,?>[] mapa = null ;
		if(rs.last()){
			mapa = new HashMap<?,?>[rs.getRow()];
		}
		rs.beforeFirst();
		int flag=0;
		while(rs.next()){
			HashMap<String,String> a = new HashMap<String,String>();
			a.put("serialNum", rs.getString("number"));
			a.put("userId", rs.getString("id"));
			a.put("userName", rs.getString("name"));
			a.put("reasonType", rs.getString("reason"));
			a.put("applyTime", rs.getString("applytime"));
			String coun= "";
			String con="country_";
			for(int i=1;i<=5;i++){
				coun=coun+rs.getInt(con+i)+"，";
			}
			String country = CodePraseCountry(coun);
			a.put("country", country);
			a.put("beginTime", rs.getString("begintime"));
			a.put("endTime", rs.getString("backtime"));
			a.put("fundSource", rs.getString("fs"));
			a.put("reasonDetails", rs.getString("ac"));
			a.put("abroadState", rs.getString("sa"));
			a.put("auditState", rs.getString("audits"));
			mapa[flag]=a;
			flag++;
		}
		return mapa;
		
	}
	public boolean updateAARecordField(String field, String serialNum,String value) throws Exception{
		Connection conn = Conn.getConnection();
		String a = hm.get(field);
		
		if(a.equals("country")){
			int val[]= CountryPraseCode(value);
				String sql = ""+
						"update ai "+
						"set country_1=?"+", country_2=?"+", country_3=?"+
						", country_4=?"+", country_5=? "+
						"where number = ?";
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setInt(1, val[0]);
				ptmt.setInt(2, val[1]);
				ptmt.setInt(3, val[2]);
				ptmt.setInt(4, val[3]);
				ptmt.setInt(5, val[4]);
				ptmt.setInt(6, Integer.parseInt(serialNum));
				boolean result= ptmt.execute();
				return true;
			
		}
		String sql="" +
				" update ai  "+
				" set "+a+"=? " +
				"WHERE number = ?";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, value);
			ptmt.setInt(2, Integer.parseInt(serialNum));
			boolean result= ptmt.execute();
		
		return result;
	}
	public boolean deleteAARecordField(String serialNum) throws Exception{
		Connection conn = Conn.getConnection();
		String sql="" +
				" delete from ai " +
				" where number=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);	
		ptmt.setInt(1, Integer.parseInt(serialNum));
		ptmt.execute();
		return true;
	}
	public boolean insertAARecord(HashMap<String,String> aARecord) throws Exception{
		Connection conn = Conn.getConnection();
		String sql =""+
				"insert into ai(id,name ,reason,country_1,country_2,country_3,country_4,country_5, begintime,backtime,fs,sa,ac,audits,applytime) "+
				"values("+
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, aARecord.get("userId"));
		ptmt.setString(2, aARecord.get("userName"));
		ptmt.setString(3, aARecord.get("reasonType"));
		int country[]=CountryPraseCode(aARecord.get("country"));

		for(int i=0;i<5;i++){
			
			ptmt.setInt(i+4, country[i]);
		}
		
		java.util.Date date= sdf.parse(aARecord.get("beginTime"));
		ptmt.setDate(9, new java.sql.Date(date.getTime()));
		ptmt.setDate(10, new java.sql.Date(sdf.parse(aARecord.get("endTime")).getTime()));
		ptmt.setString(11, aARecord.get("fundSource"));
		ptmt.setString(12, aARecord.get("abroadState"));
		ptmt.setString(13,  aARecord.get("reasonDetails"));
		ptmt.setString(14,  aARecord.get("auditState"));
		ptmt.setString(15,  aARecord.get("applyTime"));
		ptmt.execute();
		return true;
	}
	
	
}
