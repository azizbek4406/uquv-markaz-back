package net.idrok.oquvmarkaz.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Oquvchi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String ism;

    @Column(length = 100,nullable = false)
    private String familiya;

    @Column(nullable = false)
    private Long telNomer;

    @Column(nullable = false)
    private LocalDate kelganKuni;

    @Column(nullable = false)
    private Long kelishilganSumma;

    @Column(nullable = false)
    private String jins;

    private Boolean tulov;

    @ManyToOne
    private Guruh guruh;

    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    

    public LocalDate getKelganKuni() {
        return kelganKuni;
    }

    public void setKelganKuni(LocalDate kelganKuni) {
        this.kelganKuni = kelganKuni;
    }

    public String getJins() {
        return jins;
    }

    public void setJins(String jins) {
        this.jins = jins;
    }

    public Long getTelNomer() {
        return telNomer;
    }

    public void setTelNomer(Long telNomer) {
        this.telNomer = telNomer;
    }

    public Long getKelishilganSumma() {
        return kelishilganSumma;
    }

    public void setKelishilganSumma(Long kelishilganSumma) {
        this.kelishilganSumma = kelishilganSumma;
    }

    public Boolean getTulov() {
        return tulov;
    }

    public void setTulov(Boolean tulov) {
        if(this.tulov == null){
            this.tulov = false;
        }
    }

    public Guruh getGuruh() {
        return guruh;
    }

    public void setGuruh(Guruh guruh) {
        this.guruh = guruh;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

   

    
   
    
    
}
