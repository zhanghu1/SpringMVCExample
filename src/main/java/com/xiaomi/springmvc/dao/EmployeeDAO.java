package com.xiaomi.springmvc.dao;

import java.util.List;

import com.xiaomi.springmvc.model.EmployeeVO;
 
/**
 * �����λ������ܹ��еĵ����㡣������ײ�����ݿ�洢���н�����
 * */
public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
}
