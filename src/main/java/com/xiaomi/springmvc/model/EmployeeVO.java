package com.xiaomi.springmvc.model;

import java.io.Serializable;

/**
 * 这个类作为MVC模式的模型。
 * 即数据，Model
 * 模型负责封装应用程序数据在视图层展示。
 * 但是只是要封装数据，不需要业务逻辑出现在这里
 * 模型通常由POJO对象组成，它在业务层中被处理，在持久层中被持久化。
 * */
public class EmployeeVO implements Serializable
{
    private static final long serialVersionUID = 1L;
 
    private Integer id;
    private String firstName;
    private String lastName;
 
    //Setters and Getters
 
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }
}
