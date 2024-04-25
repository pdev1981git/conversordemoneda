package com.aluracursos.conversor.conection;

import com.aluracursos.conversor.model.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnecttoApi {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public Moneda consultaConvercion(String deEstaMoneda, String aEstaMoneda, double importeAConvertir){

        String urlDireccion = "https://v6.exchangerate-api.com/v6/c6cefd6028507090b15d4412/pair";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlDireccion+"/"+deEstaMoneda+"/"+aEstaMoneda+"/"+importeAConvertir)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Moneda monedaConvertida = gson.fromJson(json, Moneda.class);

            return monedaConvertida;

        } catch (IOException | InterruptedException e){
            throw new RuntimeException("No se pudo obtener el resultado");
        }

    }

}
