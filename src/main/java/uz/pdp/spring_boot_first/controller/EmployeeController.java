package uz.pdp.spring_boot_first.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_boot_first.entity.Employee;
import uz.pdp.spring_boot_first.payload.EmployeeDTO;
import uz.pdp.spring_boot_first.payload.EmployeeSearchDTO;
import uz.pdp.spring_boot_first.service.EmployeeService;

import java.util.List;
import java.util.UUID;

/**
 Created by: Mehrojbek
 DateTime: 29/01/25 19:41
 **/
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/search")
    public List<Employee> search(EmployeeSearchDTO searchDTO) {
        return employeeService.search(searchDTO);
    }

    @GetMapping
    public List<Employee> get() {
        return employeeService.get();
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.create(employeeDTO);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable UUID id,
                           @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable UUID id) {
        return employeeService.delete(id);
    }

}
