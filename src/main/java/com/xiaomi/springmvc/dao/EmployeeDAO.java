package com.xiaomi.springmvc.dao;

import java.util.List;

import com.xiaomi.springmvc.model.EmployeeVO;
 
/**
 * 这个类位于三层架构中的第三层。负责与底层的数据库存储进行交互。
 * */
public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
}
