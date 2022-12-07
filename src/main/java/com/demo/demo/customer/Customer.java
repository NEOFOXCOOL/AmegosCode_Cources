package com.demo.demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@ToString
@Entity
public class Customer {
    //Used for rename of property
    @JsonProperty("customer_id")
    private final Long id;
    @NotBlank
    @JsonProperty("customer_name")
    private final String name;
    //Used for hiding data in json result
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;
    @Email
    private final String email;

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
