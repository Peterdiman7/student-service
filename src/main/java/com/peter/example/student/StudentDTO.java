package com.peter.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        String email,
        Integer schoolId
) {
}
