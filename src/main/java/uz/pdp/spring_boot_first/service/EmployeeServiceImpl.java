package uz.pdp.spring_boot_first.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_first.entity.BankCard;
import uz.pdp.spring_boot_first.entity.Company;
import uz.pdp.spring_boot_first.entity.Employee;
import uz.pdp.spring_boot_first.exception.RestException;
import uz.pdp.spring_boot_first.mapper.EmployeeMapper;
import uz.pdp.spring_boot_first.payload.CompanyDTO;
import uz.pdp.spring_boot_first.payload.EmployeeDTO;
import uz.pdp.spring_boot_first.payload.EmployeeSearchDTO;
import uz.pdp.spring_boot_first.repository.BankCardRepository;
import uz.pdp.spring_boot_first.repository.CompanyRepository;
import uz.pdp.spring_boot_first.repository.EmployeeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    private final CompanyRepository companyRepository;
    private final BankCardRepository bankCardRepository;

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


        List<Employee> employees = employeeRepository.findAll();


        return employees;
    }

    @Transactional(dontRollbackOn = {ArithmeticException.class}, rollbackOn = {Exception.class})
    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {

        Employee employee = employeeMapper.toEntity(employeeDTO);

        List<CompanyDTO> companies = employeeDTO.getWorkingCompanies();

        companies.forEach(companyDTO -> {

            Optional<Company> optionalCompany;

            if (Objects.nonNull(companyDTO.getId()))
                optionalCompany = companyRepository.findById(companyDTO.getId());
            else
                optionalCompany = Optional.empty();

            List<Company> workingCompanies = employee.getWorkingCompanies();

            if (optionalCompany.isPresent()) {

                Company company = optionalCompany.get();
                workingCompanies.add(company);

            } else {

                Company company = new Company(
                        companyDTO.getName(),
                        companyDTO.getAddress(),
                        companyDTO.getPhone(),
                        companyDTO.getEstablishedDate(),
                        companyDTO.getStir()
                );
                companyRepository.save(company);
                workingCompanies.add(company);

            }
        });

        employeeDTO.getCards().forEach(bankCardDTO -> {
            Optional<BankCard> optionalBankCard;

            if (Objects.nonNull(bankCardDTO.getId()))
                optionalBankCard = bankCardRepository.findById(bankCardDTO.getId());
            else
                optionalBankCard = Optional.empty();

            List<BankCard> cards = employee.getCards();

            if (optionalBankCard.isPresent()) {

                BankCard bankCard = optionalBankCard.get();
                cards.add(bankCard);

            } else {

                BankCard bankCard = new BankCard(
                        bankCardDTO.getCardNumber(),
                        bankCardDTO.getExpiryDate(),
                        bankCardDTO.getHolderName(),
                        0L,
                        0L
                );

                bankCardRepository.save(bankCard);

                cards.add(bankCard);

            }
        });

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
