package com.crudtest.CrudTest.dao;

import com.crudtest.CrudTest.model.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getByIdNumber(int idNumber);
    public Employee insertEmployee (Employee employee);
    public void updateEmployee (Employee employee) throws Exception;
    public void deleteEmployee (Employee employee) throws Exception;
    public List<Employee> listEmployee() throws Exception;
}
