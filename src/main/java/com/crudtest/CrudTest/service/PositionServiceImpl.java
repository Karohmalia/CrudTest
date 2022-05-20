package com.crudtest.CrudTest.service;

import com.crudtest.CrudTest.dao.PositionDao;
import com.crudtest.CrudTest.model.dto.DefaultResponse;
import com.crudtest.CrudTest.model.dto.EmployeeDto;
import com.crudtest.CrudTest.model.entity.Employee;
import com.crudtest.CrudTest.model.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionDao positionDao;

    @Override
    public Position getById(int idP) {
        return positionDao.getById(idP);
    }

    @Override
    public List<Position> listPosition() throws Exception{
        return positionDao.listPosition();
    }

}
