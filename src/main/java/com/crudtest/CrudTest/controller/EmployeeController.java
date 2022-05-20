package com.crudtest.CrudTest.controller;

import com.crudtest.CrudTest.model.dto.DefaultResponse;
import com.crudtest.CrudTest.model.dto.EmployeeDto;
import com.crudtest.CrudTest.model.entity.Employee;
import com.crudtest.CrudTest.model.entity.Position;
import com.crudtest.CrudTest.service.EmployeeService;
import com.crudtest.CrudTest.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    PositionService positionService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/view")
    public List<Employee> listemployee() throws Exception {
        List<Employee> list = employeeService.listEmployee();
        return list;
    }

    @GetMapping("/getbynip/{idNumber}")
    public DefaultResponse<EmployeeDto> getByIdNumber(@PathVariable int idNumber) {
        DefaultResponse<EmployeeDto> response = new DefaultResponse<>();
        Employee employee = employeeService.getByIdNumber(idNumber);
        if (employee != null) {
            response.setMessage("Data Ditemukan");
            response.setData(convertEntityToDto(employee));
        } else {
            response.setMessage("Data Tidak Ditemukan");
        }
        return response;
    }

    @PostMapping("/insertemp")
    public ResponseEntity<Employee> insertEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmp = employeeService.insertEmployee(employee);
        return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
    }

    @PostMapping("/insert")
    public DefaultResponse<EmployeeDto> insertEmployee (@RequestBody EmployeeDto employeeDto) {
        DefaultResponse<EmployeeDto> response = new DefaultResponse<>();
        Employee employee = employeeService.getByIdNumber(employeeDto.getIdNumber());
        if (employee != null) {
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            employeeService.insertEmployee(employee);
            response.setMessage("Berhasil Simpan Data");
            response.setData(employeeDto);
        }

        return response;
    }

//    private Employee convertDtoToEntity(EmployeeDto dto) {
//        Employee employee = new Employee();
//        employee.setName(dto.getName());
//        employee.setBirthDate(dto.getBirthDate());
//        if(positionService.findById(dto.getPositionId()).isPresent()){
//            Position position =  positionService.findById(dto.getPositionId()).get();
//            employee.setPositionId(position);
//        }
////        employee.setPositionId(dto.getPositionId());
//        employee.setIdNumber(dto.getIdNumber());
//        employee.setGender(dto.getGender());
//        employee.setIsDelete(dto.getIsDelete());
//
//        return employee;
//    }

    private EmployeeDto convertEntityToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setBirthDate(employee.getBirthDate());
        dto.setPositionId(employee.getPositionId().getIdP());
        dto.setIdNumber(employee.getIdNumber());
        dto.setGender(employee.getGender());
        dto.setIsDelete(employee.getIsDelete());

        return dto;
    }

}
