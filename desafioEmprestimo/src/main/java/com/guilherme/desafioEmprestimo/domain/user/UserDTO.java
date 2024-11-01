package com.guilherme.desafioEmprestimo.domain.user;

import com.guilherme.desafioEmprestimo.domain.Location.LocationDTO;

import java.math.BigDecimal;

public record UserDTO(String firtsName, String lastName, Integer age, String document, BigDecimal income, LocationDTO location) {
}
