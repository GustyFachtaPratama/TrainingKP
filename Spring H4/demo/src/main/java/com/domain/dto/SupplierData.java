package com.domain.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class SupplierData {
    @NotEmpty(message = "Nama harus diisi!")
    private String name;

    @NotEmpty(message = "alamat harus diisi!")
    private String address;

    @NotEmpty(message = "email harus diisi!")
    @Email(message = "Email is not valid")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String alamat) {
        this.address = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
