package com.example.sample.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userLogin")
public class UserLogin {

    @Id
    private String id;

    @NotNull
    private String userId;

    @NotNull
    private String userName;

    @NotNull
    private String password;
}
