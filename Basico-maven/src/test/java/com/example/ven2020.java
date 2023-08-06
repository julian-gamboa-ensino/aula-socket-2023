package com.example;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.example.App;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ven2020 {
	
    private static Thread thread;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Instanciando o Servidor na 8080 ");
        thread = new Thread(() -> {
        	try {
				App.main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        });
        thread.start();		
	}

    //@Disabled
	@Test
    public void testStatusCodeForVen2020() throws IOException {
        // Cria um cliente HTTP
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

        	
        	
        	// Cria uma solicitação HTTP GET para ven2020.com.br
            HttpGet httpGet = new HttpGet("http://localhost:8080");

            // Executa a solicitação e obtém a resposta
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // Verifica o código de status da resposta
                int statusCode = response.getStatusLine().getStatusCode();
                
            	
            	assertEquals(200, statusCode);
            	


                // Lê o conteúdo da resposta (opcional)
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Conteúdo da resposta:");
                System.out.println(responseBody);
            }      catch (IOException e) {
                // Tratamento de exceção em caso de erro de E/S
            	System.out.println("Tratamento de exceção em caso de erro de E/S   "+e);
                //System.err.println("Erro de E/S ao executar a solicitação HTTP: " + httpClient.execute(httpGet).getStatusLine().getStatusCode());
            } catch (Exception e) {
                // Tratamento de exceção genérica
                //System.err.println("Erro de E/S ao executar a solicitação HTTP: " + httpClient.execute(httpGet).getStatusLine().getStatusCode());
            }      
        }
    }
}



