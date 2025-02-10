package uz.pdp.spring_boot_first.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import uz.pdp.spring_boot_first.entity.Student;
import uz.pdp.spring_boot_first.entity.StudentDTO;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

    List<StudentDTO> toDTO(List<Student> students);

    StudentDTO toDTO(Student student);

}