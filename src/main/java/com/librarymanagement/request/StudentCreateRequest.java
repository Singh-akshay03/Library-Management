package com.librarymanagement.request;

import com.librarymanagement.models.AccountStatus;
import com.librarymanagement.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String contact;
    private String address;
    private String email;

    public Student to(){
        return Student
                .builder()
                .address(this.address)
                .contact(this.contact)
                .email(this.email)
                .name(this.name)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
    }
}
