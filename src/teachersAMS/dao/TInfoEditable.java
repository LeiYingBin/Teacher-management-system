package teachersAMS.dao;

import java.util.HashMap;

public interface TInfoEditable {
	public String selectTInfoField(String field, String userId);
	public boolean updateTInfoField(String field, String userId);
	public boolean deleteTInfo(String userId);
	public boolean insertTInfo(String userId);
	/**
	 * 返回指定数量条教师信息记录
	 * @param quantity 若quantity 为零，则 返回全部
	 * @return HashMap 数组， 键值类型都为 String
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?>[] selectTInfo(int quantity);
	/**
	 * 返回指定教师的信息记录
	 * @param userId
	 * @return HashMap 数组， 键值类型都为 String
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?> selectTInfo(String userId);
}
