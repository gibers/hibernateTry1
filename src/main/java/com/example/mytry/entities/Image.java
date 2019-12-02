package com.example.mytry.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ImagePK.class)
public class Image {
    private int itemId;
    private String filename;
    private int imagesOrder;

    @Id
    @Column(name = "itemooid")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Id
    @Column(name = "images_order")
    public int getImagesOrder() {
        return imagesOrder;
    }

    public void setImagesOrder(int imagesOrder) {
        this.imagesOrder = imagesOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return itemId == image.itemId &&
                imagesOrder == image.imagesOrder &&
                Objects.equals(filename, image.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, filename, imagesOrder);
    }
}
