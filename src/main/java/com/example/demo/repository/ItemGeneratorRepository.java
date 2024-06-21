package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Item;

@Component
public class ItemGeneratorRepository implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if(this.itemRepository.count() == 0) {
            
            List<Item> items = new ArrayList<>();

            items.add(new Item("Salamèche", 100, "https://univers-pokemon.fr/wp-content/uploads/2023/12/dfggf-removebg-preview-1.png"));
            items.add(new Item("Rondoudoubt", 200, "https://risibank.fr/cache/medias/0/5/578/57812/full.png"));
            items.add(new Item("Pikachu", 300, "https://www.smashbros.com/assets_v2/img/fighter/pikachu/main8.png"));
            items.add(new Item("Ronflex", 400, "https://www.pokepedia.fr/images/thumb/2/2b/Ronflex-RFVF.png/800px-Ronflex-RFVF.png"));

            this.itemRepository.saveAll(items);
        }
    }

}
