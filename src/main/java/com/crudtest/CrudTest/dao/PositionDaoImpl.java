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
public class PositionDaoImpl implements PositionDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Position getById(int idP) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "from Position where id = :idValue";
        Query query = session.createQuery(hql);
        query.setInteger("idValue", idP);
        if (query.list().size() > 0) {
            return (Position) query.list().get(0);
        } else {
            return null;
        }
    }
    @Override
    public List<Position> listPosition() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "from Position";
        Query query = session.createQuery(hql);
        return query.list();
    }
}