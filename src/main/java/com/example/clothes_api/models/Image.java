package com.example.clothes_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "images")
public class Image {

    @Id
    private UUID id;
    @Lob
    private Byte bytes;
    private String name;
    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Image() {
        this.id = UUID.randomUUID();
    }

    public String getId() {
        return id.toString();
    }
    public String getName() {
        return name;
    }
    public Byte getBytes() {
        return bytes;
    }
    public void setBytes(Byte newBytes) {
        this.bytes = newBytes;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Clothes getClothes() {
        return clothes;
    }
    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }    
}
