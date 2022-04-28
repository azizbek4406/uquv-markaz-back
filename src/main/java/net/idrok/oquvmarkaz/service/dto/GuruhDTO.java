package net.idrok.oquvmarkaz.service.dto;

import java.time.LocalDate;

import net.idrok.oquvmarkaz.entity.Guruh;
import net.idrok.oquvmarkaz.entity.Oqituvchi;

public class GuruhDTO{
    private Long id;
    private String nom;
    private String darsVaqti;

    private LocalDate sana;

   
    private Oqituvchi oqituvchi;

    private String info;
    private Long oquvchiSon;


    public GuruhDTO(Guruh g){
        this.nom = g.getNom();
        this.darsVaqti = g.getDarsVaqti();
        this.id = g.getId();
        this.info = g.getInfo();
        this.oqituvchi = g.getOqituvchi();
        this.sana = g.getSana();
    
        
    }

    public Long getOquvchiSon() {
        return oquvchiSon;
    }

    public void setOquvchiSon(Long oquvchiSon) {
        this.oquvchiSon = oquvchiSon;
    }

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
