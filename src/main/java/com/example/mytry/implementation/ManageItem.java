package com.example.mytry.implementation;

import com.example.mytry.controllers.Facade1;
import com.example.mytry.entities.Item;
import com.example.mytry.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class ManageItem {

    private static final Logger log = LoggerFactory.getLogger(ManageItem.class);

    @Autowired
    private ItemRepository itemRepository;

//    @PersistenceContext
//    private EntityManager entityManager;

    public void insertItem() {
        Item item = new Item();
        item.setName("batman");

        item.getImages().add("images1");
        item.getImages().add("images2");
        item.getImages().add("images3");
        item.getImages().add("images4");

        itemRepository.save(item);
    }

    public void removeImageInItem(int itemId, String name) {
        log.debug(String.format("Pour item: %s , suppression de l'image: %s ", itemId, name));
        Optional<Item> byId = itemRepository.findById(itemId);
        byId.ifPresent(item -> {
            List<String> images = item.getImages();
            images.remove(name);
            itemRepository.save(item);
        });
    }

    public void getImages(int itemId) {
        Optional<Item> byId = itemRepository.findById(itemId);
        byId.ifPresent(item -> {
            List<String> images = item.getImages();
            log.debug(String.format("les images sont : %s ", images));
        });
    }

}
