package com.xiaomi.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaomi.springmvc.dao.EmployeeDAO;
import com.xiaomi.springmvc.model.EmployeeVO;

/**
 * @Service ��עҵ����������Ҳ��@Component�ľ���ʵ��
 * ���ǵ���webӦ�õĵڶ��㣬������ҵ���߼��ĵط������ĵ���
 * ��;��������㣨�־ò㣩���н���
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
