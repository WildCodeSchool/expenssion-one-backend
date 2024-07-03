package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AnecdoticSecret;
import com.example.demo.entity.Language;
import com.example.demo.entity.PrimordialSecret;
import com.example.demo.entity.Race;
import com.example.demo.repository.AnecdoticSecretRepository;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.repository.PrimordialSecretRepository;
import com.example.demo.repository.RaceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DbService {

    private final AnecdoticSecretRepository anecdoticSecretRepository;
    private final PrimordialSecretRepository primordialSecretRepository;
    private final RaceRepository raceRepository;
    private final LanguageRepository languageRepository;

    public DbService(AnecdoticSecretRepository anecdoticSecretRepository,
            PrimordialSecretRepository primordialSecretRepository, RaceRepository raceRepository,
            LanguageRepository languageRepository) {
        this.anecdoticSecretRepository = anecdoticSecretRepository;
        this.primordialSecretRepository = primordialSecretRepository;
        this.raceRepository = raceRepository;
        this.languageRepository = languageRepository;
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
            anecdoticSecretRepository.saveAll(secretsList);
            InputStream inputStream3 = getClass().getResourceAsStream("/data/race.json");
            Race[] racesArray = mapper.readValue(inputStream3, Race[].class);
            List<Race> racesList = Arrays.asList(racesArray);
            raceRepository.saveAll(racesList);
            InputStream inputStream4 = getClass().getResourceAsStream("/data/language.json");
            Language[] languagesArray = mapper.readValue(inputStream4, Language[].class);
            List<Language> languagesList = Arrays.asList(languagesArray);
            languageRepository.saveAll(languagesList);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
