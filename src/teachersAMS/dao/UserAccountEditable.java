package teachersAMS.dao;

import java.util.HashMap;

public interface UserAccountEditable {
	public String selectUserAccountField(String field, String userId);
	public boolean updateUserAccountField(String field, String userId);
	public boolean deleteUserAccount(String userId);
	public boolean insertUserAccount(String userId);
	/**
	 * 返回指定数量条用户信息记录
	 * @param quantity 若quantity 为零，则 返回全部
	 * @return HashMap 数组， 键值类型都为 String
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<String,String>[] selectUserAccount(int quantity);
	/**
	 * 返回指定用户的信息记录
	 * @param userId
	 * @return HashMap 数组， 键值类型都为 String
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<String,String> selectUserAccount(String userId);
}
