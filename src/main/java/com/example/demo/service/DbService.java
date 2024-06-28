package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AnecdoticSecret;
import com.example.demo.entity.PrimordialSecret;
import com.example.demo.repository.AnecdoticSecretRepository;
import com.example.demo.repository.PrimordialSecretRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DbService {

    private final AnecdoticSecretRepository anecdoticSecretRepository;
    private final PrimordialSecretRepository primordialSecretRepository;

    public DbService(AnecdoticSecretRepository anecdoticSecretRepository, PrimordialSecretRepository primordialSecretRepository) {
        this.anecdoticSecretRepository = anecdoticSecretRepository;
        this.primordialSecretRepository = primordialSecretRepository;
    }

    public void insertDB() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/data/anecdoticSecrets.json");
            AnecdoticSecret[] secretsArray = mapper.readValue(inputStream, AnecdoticSecret[].class);
            List<AnecdoticSecret> secretsList = Arrays.asList(secretsArray);
            anecdoticSecretRepository.saveAll(secretsList);
            InputStream inputStream2 = getClass().getResourceAsStream("/data/primordialSecrets.json");
            PrimordialSecret[] primordialSecretsArray = mapper.readValue(inputStream2, PrimordialSecret[].class);
            List<PrimordialSecret> primordialSecretsList = Arrays.asList(primordialSecretsArray);
            primordialSecretRepository.saveAll(primordialSecretsList);
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
