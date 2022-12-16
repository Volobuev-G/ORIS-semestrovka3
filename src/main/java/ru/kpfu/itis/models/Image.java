package ru.kpfu.itis.models;

import java.util.Objects;

public class Image {
    private Long id;
    private String image;

    public Image(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public Image(String image) {
        this.id = null;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image1 = (Image) o;
        return id.equals(image1.id) && Objects.equals(image, image1.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
