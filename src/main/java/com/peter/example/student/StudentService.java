package com.peter.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO studentDTO) {
        var student = studentMapper.toStudent(studentDTO);
        var savedStudent = studentRepository.save(student);

        return studentMapper.toDTO(savedStudent);
    }

    public List<StudentResponseDTO> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO findStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO)
                .orElse(null);
    }

    public List<StudentResponseDTO> findStudentsByName(String name) {
        return studentRepository.findAllByFirstNameContaining(name);
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

}
