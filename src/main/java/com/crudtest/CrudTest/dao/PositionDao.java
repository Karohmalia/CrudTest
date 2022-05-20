package com.crudtest.CrudTest.dao;

import com.crudtest.CrudTest.model.entity.Position;

import java.util.List;

public interface PositionDao {
    Position getById(int idP);
    public List<Position> listPosition() throws Exception;
}
