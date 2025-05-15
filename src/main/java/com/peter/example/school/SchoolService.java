package com.peter.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTO create(SchoolDTO schoolDTO) {
        var school = schoolMapper.toSchool(schoolDTO);
        schoolRepository.save(school);
        return schoolDTO;
    }

    public List<SchoolDTO> getSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }

    public void deleteSchool(Integer id) {
        schoolRepository.deleteById(id);
    }
}
