package com.crudtest.CrudTest.dao;

import com.crudtest.CrudTest.model.entity.Employee;
import com.crudtest.CrudTest.model.entity.Position;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee getByIdNumber(int idNumber) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "from Employee where idNumber = :idValue";
        Query query = session.createQuery(hql);
        query.setInteger("idValue", idNumber);
        if (query.list().size() > 0) {
            return (Employee) query.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.save(employee);

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        Session session = entityManager.unwrap(Session.class);

        session.update(employee);

    }

    @Override
    public void deleteEmployee(Employee employee) throws Exception {
        Session session = entityManager.unwrap(Session.class);

        session.delete(employee);

    }

    @Override
    public List<Employee> listEmployee() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "from Employee ";
        Query query = session.createQuery(hql);
        return query.list();
    }

}
