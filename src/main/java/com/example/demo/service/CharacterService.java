package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Character;
import com.example.demo.repository.CharacterRepository;

@Service
public class CharacterService {

        @Autowired
    private CharacterRepository characterRepository;


    public List<Character> getAll() {
        List<Character> characters = this.characterRepository.findAll();
        return characters;
    }

    public Character getById(Long id) {
        Character character = this.characterRepository.findById(id).get();
        return character;
    }
    
    public Character createCharacter(Character character) {
        return this.characterRepository.save(character);
    }

    public Character UpdateCharacter(Character character){
        Character characterToUpdate = this.characterRepository.findById(character.getId()).get();
        characterToUpdate.setAge(character.getAge());
        characterToUpdate.setAddiction(character.getAddiction());
        characterToUpdate.setAdditionalJob(character.getAdditionalJob());
        characterToUpdate.setAdditionalLanguage(character.getAdditionalLanguage());
        characterToUpdate.setAnecdoticSecret(character.getAnecdoticSecret());
        characterToUpdate.setArmor(character.getArmor());
        characterToUpdate.setBiography(character.getBiography());
        characterToUpdate.setBornCity(character.getBornCity());
        characterToUpdate.setCharisma(character.getCharisma());
        characterToUpdate.setConstitution(character.getConstitution());
        characterToUpdate.setDexterity(character.getDexterity());
        characterToUpdate.setDivinity(character.getDivinity());
        characterToUpdate.setHeight(character.getHeight());
        characterToUpdate.setIntelligence(character.getIntelligence());
        characterToUpdate.setLiveCity(character.getLiveCity());
        characterToUpdate.setName(character.getName());
        characterToUpdate.setPerception(character.getPerception());
        characterToUpdate.setPrimordialSecret(character.getPrimordialSecret());
        characterToUpdate.setRace(character.getRace());
        characterToUpdate.setSpeed(character.getSpeed());
        characterToUpdate.setSpecialization(character.getSpecialization());
        characterToUpdate.setStrength(character.getStrength());
        characterToUpdate.setTitles(character.getTitles());
        characterToUpdate.setWisdom(character.getWisdom());
        return this.characterRepository.save(characterToUpdate);
    
    }

    public boolean deleteCharacter(Long id,String UserUUID){
        if(this.characterRepository.findById(id).get().getUser().getId().equals(UserUUID)){
        this.characterRepository.deleteById(id);
        return true;
        }
        else{
            return false;
        }
        
    }
    public List<Character> getCharacterByUserId(String userUUID){
        List<Character> characters = this.characterRepository.findByUserId(userUUID);
        return characters;
    }
}