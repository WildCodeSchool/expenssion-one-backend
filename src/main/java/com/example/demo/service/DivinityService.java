package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Divinity;
import com.example.demo.repository.DivinityRepository;

@Service
public class DivinityService {

    @Autowired
    private DivinityRepository divinityRepository;

    public List<Divinity> getAll()
    {
        return this.divinityRepository.findAll();
    }

    public Divinity getById(Long id)
    {
        return this.divinityRepository.findById(id).get();
    }

    public Divinity createDivinity(Divinity city)
    {
        return this.divinityRepository.save(city);
    }

    public Divinity UpdateDivinity(@PathVariable Long id, @RequestBody Divinity divinity){
        Divinity divinityToUpdate = this.divinityRepository.findById(id).get();
        divinityToUpdate.setEffects(divinity.getEffects());
        divinityToUpdate.setGender(divinity.getGender());
        divinityToUpdate.setKingdom(divinity.getKingdom());
        divinityToUpdate.setName(divinity.getName());
        divinityToUpdate.setStatistics(divinity.getStatistics());
        divinityToUpdate.setType(divinity.getType());
        return this.divinityRepository.save(divinityToUpdate);
    }

    public boolean DeleteDivinity(@PathVariable Long id){
        this.divinityRepository.deleteById(id);
        return true;
    }

}
