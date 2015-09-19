package com.xiaomi.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaomi.springmvc.dao.EmployeeDAO;
import com.xiaomi.springmvc.model.EmployeeVO;

/**
 * @Service 标注业务层组件，它也是@Component的具体实现
 * 这是典型web应用的第二层，即控制业务逻辑的地方，它的典型
 * 用途是与第三层（持久层）进行交互
 * */

@Service
public class EmployeeManagerImpl implements EmployeeManager {
 
    @Autowired
    EmployeeDAO dao;
 
    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }
}
