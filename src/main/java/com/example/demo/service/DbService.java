package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AnecdoticSecret;
import com.example.demo.repository.AnecdoticSecretRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DbService {

    private final AnecdoticSecretRepository anecdoticSecretRepository;
    public DbService(AnecdoticSecretRepository anecdoticSecretRepository) {
        this.anecdoticSecretRepository = anecdoticSecretRepository;
    }

    public void insertDB() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/data/anecdoticSecrets.json");
            AnecdoticSecret[] secretsArray = mapper.readValue(inputStream, AnecdoticSecret[].class);
            List<AnecdoticSecret> secretsList = Arrays.asList(secretsArray);
            anecdoticSecretRepository.saveAll(secretsList);
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
