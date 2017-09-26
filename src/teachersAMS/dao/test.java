package teachersAMS.dao;

import java.util.Dictionary;
import java.util.HashMap;

import dao.Countrydao;

public class test {
	public static void main(String[] args) throws Exception {
		AARecorddao aa = new AARecorddao();
		
//		System.out.println(aa.selectAARecordField("userId", "1"));
//		System.out.println(aa.selectAARecordField("userName", "1"));
//		System.out.println(aa.selectAARecordField("country", "1"));
//		System.out.println(aa.selectAARecordField("reasonType", "1"));
//		System.out.println(aa.selectAARecordField("beginTime", "1"));
//		System.out.println(aa.selectAARecordField("endTime", "1"));
//		System.out.println(aa.selectAARecordField("applyTime", "1"));
//		System.out.println(aa.selectAARecordField("fundSource", "1"));
//		System.out.println(aa.selectAARecordField("reasonDetails", "1"));
//		System.out.println(aa.selectAARecordField("abroadState", "1"));
//		System.out.println(aa.selectAARecordField("auditState", "1"));
		 
		int quantity =3;
		HashMap<?,?>[] mapa = new HashMap<?,?>[3];
		
//		mapa=aa.selectAARecord("待审核");
//		mapa = aa.selectAARecordCompelete(0);
//		mapa = aa.selectAARecord(100, "2017110003");
//		System.out.println(mapa[mapa.length-1].get("userId"));
//		System.out.println(mapa[0].get("userName"));
//		System.out.println(mapa[0].get("country"));
//		System.out.println(mapa[0].get("reasonType"));
//		System.out.println(mapa[0].get("beginTime"));
//		System.out.println(mapa[0].get("endTime"));
//		System.out.println(mapa[0].get("applyTime"));
//		System.out.println(mapa[0].get("fundSource"));
//		System.out.println(mapa[0].get("reasonDetails"));
//		System.out.println(mapa[0].get("abroadState"));
//		System.out.println(mapa[0].get("auditState"));
		
//		System.out.println(hm.get("userId"));
//		System.out.println(hm.get("userName"));
//		System.out.println(hm.get("country"));
//		System.out.println(hm.get("reasonType"));
//		System.out.println(hm.get("beginTime"));
//		System.out.println(hm.get("endTime"));
//		System.out.println(hm.get("fundSource"));
//		System.out.println(hm.get("reasonDetails"));
//		System.out.println(hm.get("abroadState"));
//		System.out.println(hm.get("auditState"));
//		aa.updateAARecordField("userName", "1", "演讲");
		HashMap<String,String> hm = new HashMap<String,String>();
//		hm.put("userId", "2017110003");
//		hm.put("userName", "高文宇");
//		hm.put("country", "美国，英国，法国");
//		hm.put("reasonType", "演讲");
//		hm.put("beginTime", "2017-01-02");
//		hm.put("endTime", "2017-01-15");
//		hm.put("fundSource", "公费");
//		hm.put("reasonDetails", "就是演讲啊");
//		hm.put("abroadState", "未出国");
//		hm.put("auditState", "待审核");
//		hm.put("applyTime", "2017-01-02");
//		aa.insertAARecord(hm);
		
//		UserAccountdao u = new UserAccountdao();
		
//		System.out.println(u.selectUserAccountField("role","2017110003" ));
//		u.updateUserAccountField("role","2017110003", "审核");
//		u.deleteUserAccount("2017110004");
//		HashMap<String,String> hm = new HashMap<String,String>();
//		hm.put("userId", "2017110004");
//		hm.put("userName", "菜菜");
//		hm.put("userPwd", "2017110004");
//		hm.put("role", "查询");
//		u.insertUserAccount(hm);
		
//		mapa=u.selectUserAccount(quantity);
//		System.out.println(mapa[1].get("userId"));
//		System.out.println(hm.get("userName"));
//		System.out.println(hm.get("userPwd"));
//		System.out.println(hm.get("role"));
		
//		hm=u.selectUserAccount("2017110003");
//		System.out.println(hm.get("userId"));
//		System.out.println(hm.get("userName"));
//		System.out.println(hm.get("userPwd"));
//		System.out.println(hm.get("role"));
		TeacherInfodao t = new TeacherInfodao();
//		mapa = aa.selectAARecord("待审核");
//		System.out.println(aa.selectAARecordField("country", "40"));
		
//		for(int i=0;i<mapa.length;i++){
//			System.out.println(mapa[i].get("country"));
//		}
//		String country="法国，波兰，瑞典，意大利";
//		System.out.println(aa.updateAARecordField("country", "18", country));
//		System.out.println(t.selectTInfoField("tId", "2017110003"));
//		System.out.println(t.selectTInfoField("tName", "2017110003"));
//		System.out.println(t.selectTInfoField("tSex", "2017110003"));
//		System.out.println(t.selectTInfoField("tBirthday", "2017110003"));
//		System.out.println(t.selectTInfoField("tTitle", "2017110003"));
//		System.out.println(t.selectTInfoField("tDepartment", "2017110003"));
//		System.out.println(t.selectTInfoField("tEducation", "2017110003"));
		
//		t.updateTInfoField("tSex", "2017110003", "女");
//		t.deleteTInfo("2017110004");
		
//		hm.put("tId", "2017110004");
//		hm.put("tName", "菜菜");
//		hm.put("tSex", "女");
//		hm.put("tBirthday", "1997-02-15");
//		hm.put("tTitle", "教师");
//		hm.put("tDepartment", "信息学院");
//		hm.put("tEducation", "博士");
//		t.insertTInfo(hm);
		HashMap<?,?>[] res= new HashMap<?,?>[100];
		res = t.selectTInfo(0);
		
//		System.out.println(res[47].get("tId"));
//		System.out.println(res[0].get("tName"));
//		System.out.println(res[0].get("tSex"));
//		System.out.println(res[0].get("tBirthday"));
//		System.out.println(res[0].get("tTitle"));
//		System.out.println(res[0].get("tDepartment"));
//		System.out.println(res[0].get("tEducation"));
//		hm=t.selectTInfo("2017110003");
//		System.out.println(hm.get("tId"));
//		System.out.println(hm.get("tName"));
//		System.out.println(hm.get("tSex"));
//		System.out.println(hm.get("tTitle"));
	}

}
