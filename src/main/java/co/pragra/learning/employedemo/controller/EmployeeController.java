package co.pragra.learning.employedemo.controller;

import co.pragra.learning.employedemo.DTO.EmployeeDTO;
import co.pragra.learning.employedemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/api/employee")
    public EmployeeDTO addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) throws Exception {
        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping("/api/employee")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/api/employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/api/employee/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/api/employee/{id}")
    public EmployeeDTO updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

}
