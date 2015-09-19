package com.xiaomi.springmvc.model;

import java.util.List;

/**
 * @author 		zhanghu1
 * @date   		2015Äê8ÔÂ12ÈÕ
 * @fileName	StudentDao.java
 * @packageName	com.xiaomi.springmvc.model
 * @projectName SpringMVCExample
 * @Company		Xiaomi
 */

public interface StudentDao {
	/**  
     * This is the method to be used to initialize 
     * database resources ie. connection. 
     */   
    public void addstudent(StudentInfo student);  
      
    public void delstudentbyID(String ID);  
      
    public void delstudentbyname(String name);  
      
    public void delallstudent();  
      
    public void updstudent(StudentInfo student);  
      
    public List<StudentInfo> allstudent();  
      
    public List<StudentInfo> querystudentbyID(String ID);  
      
    public List<StudentInfo> querystudentbyname(String name);  
      
    public List<StudentInfo> querystudentbyage(int age);  
}

