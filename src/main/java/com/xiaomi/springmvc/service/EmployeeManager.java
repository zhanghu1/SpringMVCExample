package com.xiaomi.springmvc.service;

import java.util.List;

import com.xiaomi.springmvc.model.EmployeeVO;

/**
 * 这个类处于三层架构中的第二层。负责与DAO层交互。
 * */
public interface EmployeeManager
{
    public List<EmployeeVO> getAllEmployees();
}
