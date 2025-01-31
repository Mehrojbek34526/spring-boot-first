package uz.pdp.spring_boot_first.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_first.entity.Employee;
import uz.pdp.spring_boot_first.exception.RestException;
import uz.pdp.spring_boot_first.mapper.EmployeeMapper;
import uz.pdp.spring_boot_first.payload.EmployeeDTO;
import uz.pdp.spring_boot_first.payload.EmployeeSearchDTO;
import uz.pdp.spring_boot_first.repository.EmployeeRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 Created by: Mehrojbek
 DateTime: 29/01/25 19:48
 **/

@Primary
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<Employee> search(EmployeeSearchDTO searchDTO) {

        if (Objects.nonNull(searchDTO.getFirstName())) {
            return employeeRepository.findAllByFirstName(searchDTO.getFirstName());
        }

        if (Objects.nonNull(searchDTO.getLastName())) {
            return employeeRepository.findAllByLastName(searchDTO.getLastName());
        }

        if (Objects.nonNull(searchDTO.getEmail())) {
            return employeeRepository.findAllByEmail(searchDTO.getEmail());
        }

        if (Objects.nonNull(searchDTO.getPhone())) {
            return employeeRepository.findAllByPhone(searchDTO.getPhone());
        }

        if (Objects.nonNull(searchDTO.getBirthDate())) {
            return employeeRepository.getMyEmployees(searchDTO.getBirthDate());
        }

        return List.of();
    }

    @Override
    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {

        Employee employee = employeeMapper.toEntity(employeeDTO);

        employeeRepository.save(employee);

        return employeeMapper.toDTO(employee);
    }

    @Override
    public EmployeeDTO update(UUID id, EmployeeDTO employeeDTO) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> RestException.notFound("Employee not found", id));

        employeeMapper.updateEntity(employeeDTO, employee);

        employeeRepository.save(employee);

        return employeeMapper.toDTO(employee);
    }

    @Override
    public Employee delete(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Employee not found", id));

        employeeRepository.delete(employee);

        employee.setDeleted(true);

        return employee;
    }
}
