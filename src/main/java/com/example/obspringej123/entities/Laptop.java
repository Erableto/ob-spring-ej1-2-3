package com.example.obspringej123.entities;

import javax.persistence.*;

@Entity
@Table(name = "ordenadores")
public class Laptop {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacter;

    private String model;

    private String ram;

    private String storage;

    private Double price;

    private int releaseYear;

    // Constructores
    public Laptop() {
    }

    public Laptop(Long id, String manufacter, String model, String ram, String storage, Double price, int releaseYear) {
        this.id = id;
        this.manufacter = manufacter;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
        this.releaseYear = releaseYear;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
