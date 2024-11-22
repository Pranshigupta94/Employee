package co.pragra.learning.employedemo.service;

import co.pragra.learning.employedemo.DTO.EmployeeDTO;
import co.pragra.learning.employedemo.entity.EmployeeEntity;
import co.pragra.learning.employedemo.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmployeeName(employeeDTO.getEmployeeName());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setPhoneNumber(employeeDTO.getPhoneNumber());

        // Save the entity to the database using the repository
        EmployeeEntity savedEntity = employeeRepo.save(employeeEntity);
        if (savedEntity != null && savedEntity.getId() > 0) {
            employeeDTO.setId(savedEntity.getId());
            return employeeDTO;
        }
        // Convert the saved entity back to a DTO and return it
        return null; //new EmployeeDTO(savedEntity.getId(), savedEntity.getEmployeeName(), savedEntity.getEmail(), savedEntity.getPhoneNumber());

    }


 /*   // Get all employees
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> new EmployeeDTO(employee.getId(), employee.getEmployeeName(), employee.getEmail(), employee.getPhoneNumber()))
                .collect(Collectors.toList());
    }
*/

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> {
                    EmployeeDTO dto = new EmployeeDTO();
                    dto.setId(employee.getId());
                    dto.setEmployeeName(employee.getEmployeeName());
                    dto.setEmail(employee.getEmail());
                    dto.setPhoneNumber(employee.getPhoneNumber());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    // Delete employee
    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }

   /* public List<EmployeeEntity> getAllEmployees() {
        return this.employeeRepo.findAll();
    }*/

    // Get employee by id
    public EmployeeDTO getEmployee(long id) {
       /* EmployeeEntity employee = employeeRepo.findById(id).orElse(null);
        return new EmployeeDTO(employee.getId(),
                employee.getEmployeeName(),
                employee.getEmail(),
                employee.getPhoneNumber());*/

        Optional<EmployeeEntity> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(optionalEmployee.get().getId());
            employeeDTO.setEmployeeName(optionalEmployee.get().getEmployeeName());
            employeeDTO.setEmail(optionalEmployee.get().getEmail());
            employeeDTO.setPhoneNumber(optionalEmployee.get().getPhoneNumber());

            return employeeDTO;
        }
        return null;

    }

    public EmployeeDTO updateEmployee(long id, EmployeeDTO employeeDTO) {
        // Find the employee by ID
        EmployeeEntity employeeEntity = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));  // Employee not found

        // Update the employee details
        employeeEntity.setEmployeeName(employeeDTO.getEmployeeName());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setPhoneNumber(employeeDTO.getPhoneNumber());

        // Save the updated employee back to the database
        EmployeeEntity updatedEmployee = employeeRepo.save(employeeEntity);

        // Map the updated entity to a DTO
        EmployeeDTO updatedDTO = new EmployeeDTO();
        updatedDTO.setId(updatedEmployee.getId());
        updatedDTO.setEmployeeName(updatedEmployee.getEmployeeName());
        updatedDTO.setEmail(updatedEmployee.getEmail());
        updatedDTO.setPhoneNumber(updatedEmployee.getPhoneNumber());

        // Return the updated DTO
        return updatedDTO;
    }


}