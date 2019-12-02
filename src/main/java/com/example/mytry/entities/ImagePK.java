package com.example.mytry.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ImagePK implements Serializable {
    private int itemId;
    private int imagesOrder;

    @Column(name = "itemooid")
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "images_order")
    @Id
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
        ImagePK imagePK = (ImagePK) o;
        return itemId == imagePK.itemId &&
                imagesOrder == imagePK.imagesOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, imagesOrder);
    }
}
