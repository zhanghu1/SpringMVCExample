package com.xiaomi.springmvc.service;

import java.util.List;

import com.xiaomi.springmvc.model.EmployeeVO;

/**
 * ����ദ������ܹ��еĵڶ��㡣������DAO�㽻����
 * */
public interface EmployeeManager
{
    public List<EmployeeVO> getAllEmployees();
}
