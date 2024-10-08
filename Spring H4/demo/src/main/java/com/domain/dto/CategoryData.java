package com.domain.dto;

import jakarta.validation.constraints.NotEmpty;

public class CategoryData {

    @NotEmpty(message = "nama harus diisi!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
