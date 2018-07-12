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
  
    // 表示定义数据库的用户名  
    private final String USERNAME = "root";  
    // 定义数据库的密码  
    private final String PASSWORD = "";  
    // 定义数据库的驱动信息  
    private final String DRIVER = "com.mysql.jdbc.Driver";  
    // 定义访问数据库的地址  
    private final String URL = "jdbc:mysql://localhost:3306/funiture?characterEncoding=utf-8";  
    // 定义数据库的链接  
    private Connection connection;  
    // 定义sql语句的执行对象  
    private PreparedStatement pstmt;  
    // 定义查询返回的结果集合  
    private ResultSet resultSet;  
  
    public JdbcUtils()  
    {  
        try  
        {  
            Class.forName(DRIVER);  
            System.out.println("注册驱动成功!!");  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
        	System.out.println("数据库加载失败"); 
        }  
    }  
  
    // 定义获得数据库的链接  
    public Connection getConnection()  
    {  
        try  
        {  
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  
            System.out.println("数据库连接成功");  
        }  
        catch (Exception e)  
        {  
            // TODO: handle exception  
        }  
        return connection;  
    }  
  
    /** 
     * 完成对数据库的表的添加删除和修改的操作 
     *  
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */ 
    //完成对数据库的表的添加删除和修改的操作 
    public boolean updateByPreparedStatement(String sql, List<Object> params)  
            throws SQLException  
    {  
        boolean flag = false;  
        int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数  
        pstmt = connection.prepareStatement(sql);  
        int index = 1;  
        // 填充sql语句中的占位符  
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
     * 查询返回单条记录，并保存在map中 
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
        resultSet = pstmt.executeQuery();// 返回查询结果  
        // 获取此 ResultSet 对象的列的编号、类型和属性。  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int col_len = metaData.getColumnCount();// 获取列的长度  
        while (resultSet.next())// 获得列的名称  
        {  
            for (int i = 0; i < col_len; i++)  
            {  
                String cols_name = metaData.getColumnName(i + 1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if (cols_value == null)// 列的值没有时，设置列值为“”  
                {  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
        }  
        return map;  
    }  
  
    /** 
     * 查询返回多行记录，并保存在List<Map<String, Object>>中 
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
     * 释放所用的连接 
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