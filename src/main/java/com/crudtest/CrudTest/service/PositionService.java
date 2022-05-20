package com.crudtest.CrudTest.service;

import com.crudtest.CrudTest.model.entity.Employee;
import com.crudtest.CrudTest.model.entity.Position;

import java.util.List;

public interface PositionService {
    Position getById(int idP);
    public List<Position> listPosition() throws Exception;
}
