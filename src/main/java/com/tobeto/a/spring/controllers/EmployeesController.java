package com.tobeto.a.spring.controllers;

import com.tobeto.a.spring.services.abstracts.EmployeeService;
import com.tobeto.a.spring.services.dtos.car.responses.GetListCarStatus;
import com.tobeto.a.spring.services.dtos.employee.requests.AddEmployeeRequest;
import com.tobeto.a.spring.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.tobeto.a.spring.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.tobeto.a.spring.services.dtos.employee.responses.GetListEmployeeAge;
import com.tobeto.a.spring.services.dtos.employee.responses.GetListEmployeeNameAndSurname;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeService employeeService;
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void add(@RequestBody AddEmployeeRequest request){
        employeeService.add(request);
    }

    @PutMapping("{id}")
    public void update (@RequestBody UpdateEmployeeRequest request){
        employeeService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete (@RequestBody DeleteEmployeeRequest request){
        employeeService.delete(request);
    }

    @GetMapping("dto/employees/name")
    public List<GetListEmployeeNameAndSurname> getByNameDto(@RequestParam String name, @RequestParam String surname){
        return  employeeService.getByNameDto(name,surname);
    }

    @GetMapping("dto/employees/age")
    public List<GetListEmployeeAge> getByAgeDto(@RequestParam int age){
        return  employeeService.getByAgeDto(age);
    }
}