package entity;

import java.util.Date;

public class Teacher {
	private String tId;
	private String tName;
	private String tSex;
	private String tBirthday;
	private String tTitle;//Ö°³Æ
	private String tCollege;//
	private String tEducation;
	
	public  Teacher( String id,String name,String sex,String birthday,String title,//Ö°³Æ
			String college,String education){
		this.tId=id;
		this.tName=name;
		this.tSex=sex;
		this.tBirthday=birthday;
		this.tTitle=title;
		this.tCollege=college;
		this.tEducation=education;
		
	}
	public Teacher(){
		
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettSex() {
		return tSex;
	}
	public void settSex(String tSex) {
		this.tSex = tSex;
	}
	public String gettBirthday() {
		return tBirthday;
	}
	public void settBirthday(String tBirthday) {
		this.tBirthday = tBirthday;
	}
	public String gettTitle() {
		return tTitle;
	}
	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}
	public String gettCollege() {
		return tCollege;
	}
	public void settCollege(String tCollege) {
		this.tCollege = tCollege;
	}
	public String gettEducation() {
		return tEducation;
	}
	public void settEducation(String tEducation) {
		this.tEducation = tEducation;
	}
	@Override
	public String toString() {
		
		return this.tId+" "+this.tName+" "+this.tSex+" "+this.tBirthday
				+" "+this.tTitle+" "+this.tCollege+" "+this.tEducation;
	}
	
	
	
}
