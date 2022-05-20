package com.crudtest.CrudTest.service;

import com.crudtest.CrudTest.dao.EmployeeDao;
import com.crudtest.CrudTest.model.entity.Employee;
import com.crudtest.CrudTest.model.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getByIdNumber(int idNumber) {
        return employeeDao.getByIdNumber(idNumber);
    }

    @Override
    public Employee insertEmployee(Employee employee){
        return employeeDao.insertEmployee(employee);
    }

//    @Override
//    public void insertEmployee(Employee employee) throws Exception {
//        employeeDao.insertEmployee(employee);
//    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) throws Exception {
        employeeDao.deleteEmployee(employee);
    }

    @Override
    public List<Employee> listEmployee() throws Exception{
        return employeeDao.listEmployee();
    }

}
