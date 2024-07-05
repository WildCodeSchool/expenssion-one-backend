package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Belief;
import com.example.demo.repository.BeliefRepository;

@Service
public class BeliefService {
    @Autowired
    private BeliefRepository beliefRepository;

    public List<Belief> getAll()
    {
        return this.beliefRepository.findAll();
    }

    public Belief getById(Long id)
    {
        return this.beliefRepository.findById(id).get();
    }

    public Belief createBelief(Belief belief)
    {
        return this.beliefRepository.save(belief);
    }

    public Belief UpdateBelief(@PathVariable Long id, @RequestBody Belief belief){
        Belief beliefToUpdate = this.beliefRepository.findById(id).get();
        beliefToUpdate.setKingdom(belief.getKingdom());
        return this.beliefRepository.save(beliefToUpdate);
    }

    public boolean DeleteBelief(@PathVariable Long id){
        this.beliefRepository.deleteById(id);
        return true;
    }
}
