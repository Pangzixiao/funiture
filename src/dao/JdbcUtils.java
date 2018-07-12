package dao; 
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;   
  
public class JdbcUtils  
{  
  
    // ��ʾ�������ݿ���û���  
    private final String USERNAME = "root";  
    // �������ݿ������  
    private final String PASSWORD = "";  
    // �������ݿ��������Ϣ  
    private final String DRIVER = "com.mysql.jdbc.Driver";  
    // ����������ݿ�ĵ�ַ  
    private final String URL = "jdbc:mysql://localhost:3306/funiture?characterEncoding=utf-8";  
    // �������ݿ������  
    private Connection connection;  
    // ����sql����ִ�ж���  
    private PreparedStatement pstmt;  
    // �����ѯ���صĽ������  
    private ResultSet resultSet;  
  
    public JdbcUtils()  
    {  
        try  
        {  
            Class.forName(DRIVER);  
            System.out.println("ע�������ɹ�!!");  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
        	System.out.println("���ݿ����ʧ��"); 
        }  
    }  
  
    // ���������ݿ������  
    public Connection getConnection()  
    {  
        try  
        {  
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  
            System.out.println("���ݿ����ӳɹ�");  
        }  
        catch (Exception e)  
        {  
            // TODO: handle exception  
        }  
        return connection;  
    }  
  
    /** 
     * ��ɶ����ݿ�ı�����ɾ�����޸ĵĲ��� 
     *  
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */ 
    //��ɶ����ݿ�ı�����ɾ�����޸ĵĲ��� 
    public boolean updateByPreparedStatement(String sql, List<Object> params)  
            throws SQLException  
    {  
        boolean flag = false;  
        int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������  
        pstmt = connection.prepareStatement(sql);  
        int index = 1;  
        // ���sql����е�ռλ��  
        if (params != null && !params.isEmpty())  
        {  
            for (int i = 0; i < params.size(); i++)  
            {  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        result = pstmt.executeUpdate();  
        flag = result > 0 ? true : false;  
        return flag;  
    }  
  

    /** 
     * ��ѯ���ص�����¼����������map�� 
     *  
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */  
    public Map<String, Object> findSimpleResult(String sql, List<Object> params)  
            throws SQLException  
    {  
        Map<String, Object> map = new HashMap<String, Object>();  
        int index = 1;  
        pstmt = connection.prepareStatement(sql);  
        if (params != null && !params.isEmpty())  
        {  
            for (int i = 0; i < params.size(); i++)  
            {  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        resultSet = pstmt.executeQuery();// ���ز�ѯ���  
        // ��ȡ�� ResultSet ������еı�š����ͺ����ԡ�  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int col_len = metaData.getColumnCount();// ��ȡ�еĳ���  
        while (resultSet.next())// ����е�����  
        {  
            for (int i = 0; i < col_len; i++)  
            {  
                String cols_name = metaData.getColumnName(i + 1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if (cols_value == null)// �е�ֵû��ʱ��������ֵΪ����  
                {  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
        }  
        return map;  
    }  
  
    /** 
     * ��ѯ���ض��м�¼����������List<Map<String, Object>>�� 
     *  
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */  
    public List<Map<String, Object>> findMoreResult(String sql,  
            List<Object> params) throws SQLException  
    {  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        int index = 1;  
        pstmt = connection.prepareStatement(sql);  
        if (params != null && !params.isEmpty())  
        {  
            for (int i = 0; i < params.size(); i++)  
            {  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        resultSet = pstmt.executeQuery();  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while (resultSet.next())  
        {  
            Map<String, Object> map = new HashMap<String, Object>();  
            for (int i = 0; i < cols_len; i++)  
            {  
                String cols_name = metaData.getColumnName(i + 1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if (cols_value == null)  
                {  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
            list.add(map);  
        }  
        return list;  
    }  
  
   
    /** 
     * �ͷ����õ����� 
     */  
    public void releaseConn()  
    {  
        if (resultSet != null)  
        {  
            try  
            {  
                resultSet.close();  
            }  
            catch (SQLException e)  
            {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        if (pstmt != null)  
        {  
            try  
            {  
                pstmt.close();  
            }  
            catch (SQLException e)  
            {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        if (connection != null)  
        {  
            try  
            {  
                connection.close();  
            }  
            catch (SQLException e)  
            {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
  
}  