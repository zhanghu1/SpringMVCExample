package com.xiaomi.springmvc.model;

import java.util.List;

//import javax.sql.DataSource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author 		zhanghu1
 * @date   		2015年8月12日
 * @fileName	StudentDaoImpl.java
 * @packageName	com.xiaomi.springmvc.model
 * @projectName SpringMVCExample
 * @Company		Xiaomi
 */

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {

	/**
	 * 网络上原来的文件里是这样写的，但是这样存在着严重的耦合，
	 * 所以，修改为继承自JdbcDaoSupport（Spring In Action中是SimpleJdbcDaoSupport，
	 * 但是这个类已经deprecated了），可以利用它的静态方法getJdbcTemplate方法获取一个
	 * JdbcTemplate
	 * JdbcDaoSupport这个类中有一个参数dataSource，用来填充数据源，我们在配置文件jdbcTest.xml
	 * 文件中进行注入，这样就可以解除原来的耦合了
	 * */
//	private DataSource datasource;  
//    private JdbcTemplate jdbcTemplateObject;  
      
      
//    public void setdatasource(DataSource ds) {  
//        this.datasource = ds;  
//        this.jdbcTemplateObject = new JdbcTemplate(datasource);       
//    }  
  
    public void addstudent(StudentInfo student) {  
        String sql = "INSERT INTO student(ID,name,age,FM)VALUES(?,?,?,?)";  
          
        getJdbcTemplate().update(sql, 
        		student.getID(), 
        		student.getName(), 
        		student.getAge(), 
        		student.getFM());  
        return; 
    }  
  
    public void delstudentbyID(String ID) {  
        String sql = "DELETE FROM student WHERE ID=?";  
        getJdbcTemplate().update(sql,ID);  
        return ;  
    }  
  
    public void delstudentbyname(String name) {  
        String sql = "DELETE FROM student WHERE name=?";  
        getJdbcTemplate().update(sql,name);  
        return ;          
    }  
  
    public void delallstudent() {  
        String sql = "DELETE FROM student";  
        getJdbcTemplate().update(sql);  
        return ;      
    }  
  
    public void updstudent(StudentInfo student) {  
        String sql = "UPDATE student set name=?,age=?,FM=? WHERE ID=?";  
        getJdbcTemplate().update(sql,student.getName(),  
                student.getAge(),student.getFM(),student.getID());  
        return ;  
    }  
  
    public List<StudentInfo> allstudent() {  
        List<StudentInfo> students = null;  
        String sql = "SELECT * FROM student";  
        students = getJdbcTemplate().query(sql, new StudentMapper());  
        return students;  
    }  
  
    public List<StudentInfo> querystudentbyID(String ID) {  
        List<StudentInfo> students = null;  
        String sql = "SELECT * FROM student WHERE ID=?";  
        students = getJdbcTemplate().query(sql, new Object[]{ID}, new StudentMapper());  
        return students;  
    }  
  
    public List<StudentInfo> querystudentbyname(String name) {  
        List<StudentInfo> students = null;  
        String sql = "SELECT * FROM student WHERE name=?";  
        students = getJdbcTemplate().query(sql, new Object[]{name}, new StudentMapper());  
        return students;  
    }  
  
    public List<StudentInfo> querystudentbyage(int age) {  
        List<StudentInfo> students = null;  
        String sql = "SELECT * FROM student WHERE age=?";  
        students = getJdbcTemplate().query(sql, new Object[]{age}, new StudentMapper());  
        return students;  
    }  
      
    public void displayall(){  
        List<StudentInfo> students = allstudent();  
        for(StudentInfo s : students){  
            s.display();  
        }  
    }  

}

