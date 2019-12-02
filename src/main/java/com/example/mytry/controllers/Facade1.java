package com.example.mytry.controllers;

import com.example.mytry.implementation.ManageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Facade1 {

    private static final Logger log = LoggerFactory.getLogger(Facade1.class);

    @Autowired
    private ManageItem manageItem;

    @GetMapping(path = "/insertItem")
    public void insertItem() {
        log.debug("appel de la méthode." );
        manageItem.insertItem();
    }

    @GetMapping(path = "/remove/{item}/{image}")
    public void removeImageInItem(@PathVariable("item") int itemId,
                                  @PathVariable("image") String image) {
        manageItem.removeImageInItem(itemId, image);
    }

    @GetMapping(path = "/getitem/{item}")
    public void removeImageInItem(@PathVariable("item") int itemId) {
        manageItem.getImages(itemId);
    }


}
