package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Kingdom;
import com.example.demo.repository.KingdomRepository;

@Service
public class KingdomService {

    @Autowired
    private KingdomRepository kingdomRepository;

    public List<Kingdom> getAll()
    {
        return this.kingdomRepository.findAll();
    }

    public Kingdom getById(Long id)
    {
        return this.kingdomRepository.findById(id).get();
    }

    public Kingdom createKingdom(Kingdom kingdom)
    {
        return this.kingdomRepository.save(kingdom);
    }

    public Kingdom UpdateKingdom(@PathVariable Long id, @RequestBody Kingdom kingdom){
        Kingdom kingdomToUpdate = this.kingdomRepository.findById(id).get();
        kingdomToUpdate.setBelieveContents(kingdom.getBelieveContents());
        kingdomToUpdate.setDescription(kingdom.getDescription());
        kingdomToUpdate.setDivinities(kingdom.getDivinities());
        kingdomToUpdate.setName(kingdom.getName());
        kingdomToUpdate.setRegions(kingdom.getRegions());
        kingdomToUpdate.setUrlMap(kingdom.getUrlMap());
        return this.kingdomRepository.save(kingdomToUpdate);
    }

    public boolean DeleteKingdom(@PathVariable Long id){
        this.kingdomRepository.deleteById(id);
        return true;
    }

}
