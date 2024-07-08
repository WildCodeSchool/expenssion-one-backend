package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AnecdoticSecret;
import com.example.demo.entity.BeliefContent;
import com.example.demo.entity.City;
import com.example.demo.entity.Divinity;
import com.example.demo.entity.Job;
import com.example.demo.entity.Kingdom;
import com.example.demo.entity.Language;
import com.example.demo.entity.PrimordialSecret;
import com.example.demo.entity.Race;
import com.example.demo.entity.Region;
import com.example.demo.entity.Specialization;
import com.example.demo.entity.SpecializationContent;
import com.example.demo.entity.SpecializationSkill;
import com.example.demo.repository.AnecdoticSecretRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.KingdomRepository;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.repository.PrimordialSecretRepository;
import com.example.demo.repository.RaceRepository;
import com.example.demo.repository.SpecializationRepository;
import com.example.demo.repository.SpecializationSkillRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DbService {

    private final AnecdoticSecretRepository anecdoticSecretRepository;
    private final PrimordialSecretRepository primordialSecretRepository;
    private final RaceRepository raceRepository;
    private final LanguageRepository languageRepository;
    private final SpecializationRepository specializationRepository;
    private final JobRepository jobRepository;
    private final SpecializationSkillRepository specializationSkillRepository;
    private final KingdomRepository kingdomRepository;

    public DbService(AnecdoticSecretRepository anecdoticSecretRepository, JobRepository jobRepository, LanguageRepository languageRepository, PrimordialSecretRepository primordialSecretRepository,
     RaceRepository raceRepository, SpecializationRepository specializationRepository, SpecializationSkillRepository specializationSkillRepository
     , KingdomRepository kingdomRepository) {
        this.anecdoticSecretRepository = anecdoticSecretRepository;
        this.jobRepository = jobRepository;
        this.languageRepository = languageRepository;
        this.primordialSecretRepository = primordialSecretRepository;
        this.raceRepository = raceRepository;
        this.specializationRepository = specializationRepository;
        this.specializationSkillRepository = specializationSkillRepository;
        this.kingdomRepository = kingdomRepository;
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

            InputStream inputStream5 = getClass().getResourceAsStream("/data/jobs.json");
            Job[] jobArray = mapper.readValue(inputStream5, Job[].class);
            List<Job> jobList = Arrays.asList(jobArray);
            jobRepository.saveAll(jobList);

            InputStream inputStream6 = getClass().getResourceAsStream("/data/specializations.json");
            Specialization[] specializationArray = mapper.readValue(inputStream6, Specialization[].class);
            for (Specialization specialization : specializationArray) {
                Set<Job> jobs = new HashSet<>();
                for (Job job : specialization.getJobs()) {
                    Job existingJob = jobRepository.findByName(job.getName());
                    if (existingJob != null) {
                        jobs.add(existingJob);
                    } else {
                        Job newJob = new Job(job.getName());
                        jobs.add(jobRepository.save(newJob));
                    }
                }
                specialization.setJobs(jobs);
                for (SpecializationSkill skill : specialization.getSpecializationSkill()) {
                    skill.setSpecialization(specialization);
                }
                for (SpecializationContent content : specialization.getSpecializationContents()) {
                    content.setSpecialization(specialization);
                }
                specializationRepository.save(specialization);
            }



            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
