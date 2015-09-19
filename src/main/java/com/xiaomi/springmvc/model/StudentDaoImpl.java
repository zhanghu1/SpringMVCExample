package com.xiaomi.springmvc.model;

import java.util.List;

//import javax.sql.DataSource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author 		zhanghu1
 * @date   		2015��8��12��
 * @fileName	StudentDaoImpl.java
 * @packageName	com.xiaomi.springmvc.model
 * @projectName SpringMVCExample
 * @Company		Xiaomi
 */

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {

	/**
	 * ������ԭ�����ļ���������д�ģ������������������ص���ϣ�
	 * ���ԣ��޸�Ϊ�̳���JdbcDaoSupport��Spring In Action����SimpleJdbcDaoSupport��
	 * ����������Ѿ�deprecated�ˣ��������������ľ�̬����getJdbcTemplate������ȡһ��
	 * JdbcTemplate
	 * JdbcDaoSupport���������һ������dataSource�������������Դ�������������ļ�jdbcTest.xml
	 * �ļ��н���ע�룬�����Ϳ��Խ��ԭ���������
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

