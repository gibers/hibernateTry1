package com.example.mytry.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "link_seq")
    @SequenceGenerator(name="link_seq", sequenceName = "seq_item", allocationSize=1)
    private int id;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "image",
            joinColumns = @JoinColumn(name = "itemooid")
    )
//    @MapKeyColumn(name = "phrase")
    @OrderColumn
    @Column(name = "filename")
    private List<String> images = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return images;
    }
}
