package com.guilherme.desafioEmprestimo.domain.user;

import com.guilherme.desafioEmprestimo.domain.Location.LocationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firtsName;
    private String lastName;
    private Integer age;
    @Column(unique = true)
    private String document;
    private BigDecimal income;
    @Embedded
    private LocationDTO location;

    public User(UserDTO data) {
        this.firtsName = data.firtsName();
        this.lastName = data.lastName();
        this.age = data.age();
        this.document = data.document();
        this.income = data.income();
        this.location = data.location();
    }
}
