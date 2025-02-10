package uz.pdp.spring_boot_first.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_first.entity.Student;
import uz.pdp.spring_boot_first.entity.StudentDTO;
import uz.pdp.spring_boot_first.mapper.StudentMapper;
import uz.pdp.spring_boot_first.repository.StudentRepository;

import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 10/02/25 19:34
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final EmployeeService employeeService;

    @Override
    public List<StudentDTO> read(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDTO(students);
    }



}
