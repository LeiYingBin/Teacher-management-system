package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import dao.*;
import entity.*;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String id="2017110003";
		//userAccount类测试
		//查询
		UserAccount user = new UserAccount();
		user = UserAccountdao.getUser(id);
//		System.out.println(user);
		List<UserAccount> users = new ArrayList<UserAccount>();
//		users = UserAccountdao.getAllUser();
//		for(int i=0;i<users.size();i++){
//			user=users.get(i);
//			System.out.println(user);
//		}
		
		//删除
//		System.out.println(UserAccountdao.delete("2017110007"));
		
		//添加
//		UserAccount adduser = new UserAccount("2017110007","2017110007","Mike","查询");
//		UserAccountdao.addUser(adduser);
		
		//修改
//		try{
//		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
//		String stri = "1962-08-10";
//		java.util.Date date =sdf.parse(stri);
//		System.out.println(date);
//		java.sql.Date date1=new Date(date.getTime()); 
//		System.out.println(date1);
//		
//		String str = "2007-07-02";
//		
//			java.util.Date utildate = sdf.parse(str);
//			java.sql.Date sqldate= new java.sql.Date(utildate.getTime());
//			System.out.println(sqldate);
//		}catch(Exception e){
//		}
		
		
		//Teacher类测试
		//查询
		Teacher tea = new Teacher();
//		tea = Teacherdao.getOneTeacher(id);
//		System.out.println(tea);
//		List<Teacher> teachers = new ArrayList<Teacher>();
//		teachers = Teacherdao.getAllTeacher();
//		for(int i=0;i<teachers.size();i++){
//			Teacher tea1 = teachers.get(i);
//			System.out.println(tea1);
//		}
		
		//删除
//		System.out.println(Teacherdao.delete("2017110007"));
		//添加
//		Teacher teacher = new Teacher("2017110007","关志兵","男","1962-08-10","教授","金融学院","博士");
//		System.out.println(Teacherdao.addTeacher(teacher));
		//修改
		
		
		
		
		
		
		//Apply
		//查询
		List<AbroadApplyRecord> applys = new ArrayList<AbroadApplyRecord>();
//		applys =  AbroadApplyRecorddao.getMyApply(id);
////		applys =  AbroadApplyRecorddao.getAllApply();
//		for(int i=0;i<applys.size();i++){
//			AbroadApplyRecord apply = new AbroadApplyRecord();
//			apply=applys.get(i);
//			System.out.println(apply.toString());
//		}
		//添加
//		AbroadApplyRecord apply = new AbroadApplyRecord("2017110002","尹华","中国，阿富汗","学习","2017-2-2","2017-2-15",
//				"公费",null,"未出国","待审核");
//		AbroadApplyRecorddao.addApply(apply);
		
		
		//查看待审核的信息
//		applys =  AbroadApplyRecorddao.getAudits();
//		for(int i=0;i<applys.size();i++){
//		AbroadApplyRecord apply = new AbroadApplyRecord();
//		apply=applys.get(i);
//		System.out.println(apply.toString());
//	}
//		System.out.println(Countrydao.coun[134-1]);
		
		//审核信息
		int number= 15;
		String auditstate ="通过";
//		AbroadApplyRecorddao.ApplyAudits(number, auditstate);
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		HashMap<String,String> hm = new HashMap<String,String>();
		Countrydao cd = new Countrydao();
		hm = cd.SelectAllCountryreturn();
		System.out.println(hm.get("无"));
	}
	
	

}
