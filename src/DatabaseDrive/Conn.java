package DatabaseDrive;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	
	
	
	
	/*private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //���ݿ�����
	//�������ݿ��URL��ַ
	private static final String url="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=tms"; 
	private static final String username="sa";//���ݿ���û���
	private static final String password="sa";//���ݿ������ 
*/	
	private static final String driver = "com.mysql.jdbc.Driver"; //���ݿ�����
	//�������ݿ��URL��ַ
	private static final String url="jdbc:mysql://localhost:3306/tms?useUnicode=true&characterEncoding=UTF-8"; 
	private static final String username="root";//���ݿ���û���
	private static final String password="";//���ݿ������
	
	
    
	private static Connection conn=null;
	
	//��̬����鸺���������
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//����ģʽ�������ݿ����Ӷ���
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = Conn.getConnection();
		   if(conn!=null)
		   {
			   System.out.println("���ݿ�����������");
		   }
		   else
		   {
			   System.out.println("���ݿ������쳣��");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
}
