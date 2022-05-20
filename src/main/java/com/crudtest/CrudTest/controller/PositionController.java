package com.crudtest.CrudTest.controller;

import com.crudtest.CrudTest.model.dto.DefaultResponse;
import com.crudtest.CrudTest.model.dto.EmployeeDto;
import com.crudtest.CrudTest.model.dto.PositionDto;
import com.crudtest.CrudTest.model.entity.Employee;
import com.crudtest.CrudTest.model.entity.Position;
import com.crudtest.CrudTest.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/view")
    public List<Position> listposition() throws Exception {
        List<Position> list = positionService.listPosition();
        return list;
    }

    @GetMapping("/getbyid/{idP}")
    public DefaultResponse<PositionDto> getById(@PathVariable int idP) {
        DefaultResponse<PositionDto> response = new DefaultResponse<>();
        Position position = positionService.getById(idP);
        if (position != null) {
            response.setMessage("Data Ditemukan");
            response.setData(convertEntityToDto(position));
        } else {
            response.setMessage("Data Tidak Ditemukan");
        }
        return response;
    }

    private PositionDto convertEntityToDto(Position position) {
        PositionDto dto = new PositionDto();
        dto.setCode(position.getCode());
        dto.setName(position.getName());
        dto.setIsDelete(position.getIsDelete());

        return dto;
    }


    public List<PositionDto> listData(){
        List<PositionDto> list = new ArrayList<>();
        PositionDto m = new PositionDto();
        m.setCode("SA");
        m.setName("System Analyst");
        m.setIsDelete(0);
        list.add(m);

        PositionDto n = new PositionDto();
        n.setCode("BPS");
        n.setName("BPS");
        n.setIsDelete(0);
        list.add(n);

        PositionDto o = new PositionDto();
        o.setCode("PRG");
        o.setName("Programmer");
        o.setIsDelete(0);
        list.add(o);

        PositionDto p = new PositionDto();
        p.setCode("TEST");
        p.setName("Tester");
        p.setIsDelete(0);
        list.add(p);

        PositionDto q = new PositionDto();
        q.setCode("HELP");
        q.setName("Helpdesk");
        q.setIsDelete(0);
        list.add(q);

        return list;
    }

}
