package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Character;
import com.example.demo.service.CharacterService;





@RestController
@RequestMapping("/characters")
public class charactersController {

    


        @Value("${myApp.BearerHeader}")
        private  String BearerPrefix;

        @Autowired
        private CharacterService characterService;
        private UserService userService;

  


    @PostMapping("/addCharacter")
    public Character addCharacter(@RequestHeader("Authorization") String BearerHeader) {     
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        User user=userService.findById(userUUID).get();
        Character character = new Character();
        character.setUser(user);
        return characterService.createCharacter(character);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
       return characterService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCharacter(@PathVariable Long id,@RequestHeader("Authorization") String BearerHeader) {
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        return characterService.deleteCharacter(id,userUUID);
    }

    @GetMapping("/user")
    public List<Character> getCharacterByUserId(@RequestHeader("Authorization") String BearerHeader) {
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        return characterService.getCharacterByUserId(userUUID);
    }
    
}
