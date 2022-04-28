package net.idrok.oquvmarkaz.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Guruh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false,unique = true)
    private String nom;

    @Column(length = 100,nullable = false)
    private String darsVaqti;

    private LocalDate sana;

    @ManyToOne
    private Oqituvchi oqituvchi;

    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDarsVaqti() {
        return darsVaqti;
    }

    public void setDarsVaqti(String darsVaqti) {
        this.darsVaqti = darsVaqti;
    }

   
    
    public LocalDate getSana() {
        return sana;
    }

    public void setSana(LocalDate sana) {
        this.sana = sana;
    }

    public Oqituvchi getOqituvchi() {
        return oqituvchi;
    }

    public void setOqituvchi(Oqituvchi oqituvchi) {
        this.oqituvchi = oqituvchi;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    
}
