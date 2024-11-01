package com.guilherme.desafioEmprestimo.service;

import com.google.gson.Gson;
import com.guilherme.desafioEmprestimo.domain.Location.LocationDTO;
import com.guilherme.desafioEmprestimo.domain.Location.LocationResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocationService {

    public LocationResponse searchLocation(LocationDTO locationDTO){
        URI url = URI.create("https://viacep.com.br/ws/" + locationDTO + "/json/");

        HttpRequest request = HttpRequest.newBuilder().uri(url).build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(String.valueOf(response.body()), LocationResponse.class);
        } catch(Exception exception){
            throw new RuntimeException("Erro na API");
        }
    }
}
