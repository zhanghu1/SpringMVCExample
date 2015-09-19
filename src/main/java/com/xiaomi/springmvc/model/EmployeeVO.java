package com.xiaomi.springmvc.model;

import java.io.Serializable;

/**
 * �������ΪMVCģʽ��ģ�͡�
 * �����ݣ�Model
 * ģ�͸����װӦ�ó�����������ͼ��չʾ��
 * ����ֻ��Ҫ��װ���ݣ�����Ҫҵ���߼�����������
 * ģ��ͨ����POJO������ɣ�����ҵ����б������ڳ־ò��б��־û���
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
