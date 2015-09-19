package com.xiaomi.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaomi.springmvc.model.EmployeeVO;

/**
 * @Repository 这个代表是持久层的标记
 * 用于标注数据访问组件，即在这里是对数据进行操作的，例如读写数据库的操作
 * 典型的web应用可以分为三层，即持久层，业务层，控制层（Controller）
 * */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
 
    public List<EmployeeVO> getAllEmployees()
    {
        List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
 
        EmployeeVO vo1 = new EmployeeVO();
        vo1.setId(1);
        vo1.setFirstName("Lokesh");
        vo1.setLastName("Gupta");
        employees.add(vo1);
 
        EmployeeVO vo2 = new EmployeeVO();
        vo2.setId(2);
        vo2.setFirstName("Raj");
        vo2.setLastName("Kishore");
        employees.add(vo2);
 
        return employees;
    }
}
