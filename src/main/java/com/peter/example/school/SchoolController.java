package com.peter.example.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolRepository schoolRepository, SchoolMapper schoolMapper, SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.create(schoolDTO);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> getSchools() {
        return schoolService.getSchools();
    }

    @DeleteMapping("/schools/{school-id}")
    public void deleteSchool(@PathVariable("school-id") Integer id) {
        schoolService.deleteSchool(id);
    }

}
