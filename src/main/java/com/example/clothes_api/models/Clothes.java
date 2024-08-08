package com.example.clothes_api.models;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "clothes")
public class Clothes {

    @Id 
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "clothes")
    private Set<Image> images;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Enumerated(EnumType.STRING)
    private Occasion occasion;
    @Enumerated(EnumType.STRING)
    private Season season;
    private Double price;
    private Long stock;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Clothes() {
        this.id = UUID.randomUUID();
    }

    public String getId() {
        return id.toString();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    public void addImages(Set<Image> imagesList) {
        this.images.addAll(imagesList);
    }

    public void removeImage(UUID uuid) {
        this.images.removeIf(image -> UUID.fromString(image.getId()).equals(uuid));
    }

    public void removeImages(Set<UUID> uuids) {
        this.images.removeIf(image -> uuids.contains(UUID.fromString(image.getId())));
    }

    public String getCategory() {
        return category.getName();
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Season getSeason() {
        return season;
    }
    public void setSeason(Season season) {
        this.season = season;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}
