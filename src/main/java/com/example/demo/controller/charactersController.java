package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Character;
import com.example.demo.entity.User;
import com.example.demo.repository.CharacterRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;





@RestController
@RequestMapping("/characters")
public class charactersController {

    private final  CharacterRepository characterRepository;
    private final UserRepository userRepository;


        @Value("${myApp.BearerHeader}")
        private  String BearerPrefix;

    public charactersController(CharacterRepository characterRepository, UserRepository userRepository) {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
    }


    @PutMapping("/addCharacter")
    public void addCharacter(@RequestHeader("Authorization") String BearerHeader) throws StreamReadException, DatabindException, IOException {     
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        User user=userRepository.findById(userUUID).get();
        Character character = new Character();
        character.setUser(user);
        characterRepository.save(character);
    }

        @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        Optional<Character> characterOptional = characterRepository.findById(id);

        if (characterOptional.isPresent()) {
            Character character = characterOptional.get();
        
            return ResponseEntity.ok(character);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Character> deleteCharacter(@PathVariable Long id) {
        Optional<Character> characterOptional = characterRepository.findById(id);

        if (characterOptional.isPresent()) {
            Character character = characterOptional.get();
            characterRepository.delete(character);
            return ResponseEntity.ok(character);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("user/{id}")
    public List<Character> getCharacterByUserId(@PathVariable Long id,@RequestHeader("Authorization") String BearerHeader) {
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        User user=userRepository.findById(userUUID).get();
        return characterRepository.findByUser(user);
    }
    
}