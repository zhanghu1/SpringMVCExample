package com.xiaomi.springmvc.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 		zhanghu1
 * @date   		2015Äê8ÔÂ12ÈÕ
 * @fileName	MainTest.java
 * @packageName	com.xiaomi.springmvc.model
 * @projectName SpringMVCExample
 * @Company		Xiaomi
 */

public class MainTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context =   
                new ClassPathXmlApplicationContext("jdbcTest.xml");  
        StudentDaoImpl studentDaoImp = (StudentDaoImpl)context.getBean("studentDaoImp");  
		
		String[] ID = { "2008", "2009", "2010", "1990", "2015","2018" };  
        String[] name = { "Wang", "Hui", "Yu", "Yuan", "Yuan", "Yang"};  
        int[] age = { 16, 18, 20, 20, 22, 21 };  
        String[] FM = {"F", "F", "M", "M", "M", "F"};         
        StudentInfo student = null;  
        List<StudentInfo> students = null;  
        
        System.out.println("---------delallstudent-------------");  
        studentDaoImp.delallstudent(); 
          
        System.out.println("---------addstudent-------------");  
        for(int i=0; i<ID.length; i++){  
            student = new StudentInfo(ID[i],name[i],age[i],FM[i]);  
            studentDaoImp.addstudent(student);            
        }  
        studentDaoImp.displayall();  
          
        System.out.println("---------updatestudent-------------");  
        student = new StudentInfo("1990","Yuan",18,"M");  
        studentDaoImp.updstudent(student);  
        studentDaoImp.displayall();  
          
        System.out.println("---------querystudentbyID-------------");  
        students = studentDaoImp.querystudentbyID("1990");  
        for(StudentInfo s : students){  
            s.display();  
        }  
          
        System.out.println("---------querystudentbyname-------------");  
        students = studentDaoImp.querystudentbyname("Yuan");  
        for(StudentInfo s : students){  
            s.display();  
        }  
          
        System.out.println("---------querystudentbyage-------------");  
        students = studentDaoImp.querystudentbyage(20);  
        for(StudentInfo s : students){  
            s.display();  
        }     
          
        System.out.println("---------delstudentbyage-------------");  
        studentDaoImp.delstudentbyID("2018");  
        studentDaoImp.displayall();  
          
        System.out.println("---------delstudentbyname-------------");  
        studentDaoImp.delstudentbyname("Hui");  
        studentDaoImp.displayall();       
          
        System.out.println("---------delallstudent-------------");  
        studentDaoImp.delallstudent();    
        
        ((AbstractApplicationContext) context).close();
	}
}

