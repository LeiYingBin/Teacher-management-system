package entity;

public class UserAccount {
	private String userId;
	private String userPwd;
	private String userName;
	private String role;
	
	public UserAccount(){}
	
	public UserAccount(String id,String pwd,String name,String role){
		this.userId=id;
		this.userPwd=pwd;
		this.userName=name;
		this.role=role;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		
		return this.userId+" "+this.userName+" "+this.userPwd+" "+this.role;
	}
	
}
