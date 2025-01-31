package uz.pdp.spring_boot_first.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import uz.pdp.spring_boot_first.entity.Employee;
import uz.pdp.spring_boot_first.payload.EmployeeDTO;
import uz.pdp.spring_boot_first.payload.EmployeeSearchDTO;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> search(EmployeeSearchDTO searchDTO);

    List<Employee> get();

    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(UUID id, EmployeeDTO employeeDTO);

    Employee delete(UUID id);

}
