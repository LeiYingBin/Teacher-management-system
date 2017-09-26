package teachersAMS.dao;

import java.util.HashMap;

public interface AARecordEidtable {
	
	public String selectAARecordField(String field, String serialNum);
	/**
	 * 返回最近的 quantity 数据
	 * @param quantity
	 * @return HashMap 数组， 键值类型都为 String
	 * @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?>[] selectAARecordCompelete(int quantity);
	/**
	 * 返回指定 userId 最近的 quantity 数据
	 * @param quantity 若 quantity 为0，则返回全部数据
	 * @param userId 指定的 userId
	 * @return HashMap 数组， 键值类型都为 String
	 *  @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?>[] selectAARecord(int quantity, String userId);
	/**
	 * 返回指定审核状态的记录
	 * @param auditState 表明状态是 pass、deprecated、toAudit 暂时只实现 toAudit(待审核)的状态查询
	 * @return HashMap 数组， 键值类型都为 String
	 *  @exception java.lang.ClassCastException 当键值类型都为 String 这一条件不成立 
	 */
	public HashMap<?,?>[] selectAARecord(String auditState);
	public boolean updateAARecordField(String field, String serialNum);
	public boolean deleteAARecordField(String serialNum);
	public boolean insertAARecord(HashMap<String,String> aARecord);
	
	
	
}
