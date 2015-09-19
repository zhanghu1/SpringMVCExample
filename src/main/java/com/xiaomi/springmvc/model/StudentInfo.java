package com.xiaomi.springmvc.model;

/**
 * @author 		zhanghu1
 * @date   		2015Äê8ÔÂ12ÈÕ
 * @fileName	StudentInfo.java
 * @packageName	com.xiaomi.springmvc.model
 * @projectName SpringMVCExample
 * @Company		Xiaomi
 */

public class StudentInfo {
	
	private String ID;  
    private String name;  
    private int age;  
    private String FM;  
    
    public StudentInfo() {
    	
    }
    
    public StudentInfo(String ID, String name, int age, String FM) {
    	this.ID = ID;
    	this.name = name;
    	this.age = age;
    	this.FM = FM;
    }
    
    public void display(){  
        System.out.println(ID + " " + name + " " + age + " " + FM);  
    }

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFM() {
		return FM;
	}

	public void setFM(String fM) {
		FM = fM;
	}  
}

