package uz.pdp.spring_boot_first.service;

import uz.pdp.spring_boot_first.entity.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> read();

}
