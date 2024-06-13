package com.oredata.bankingproject.dto.common;

import com.oredata.bankingproject.common.util.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {

    @Email
    private String email;

    @Password
    private String password;

    @NotBlank
    @Size(min = 2, message = "Username must be at least 2 characters long")
    private String username;
}
