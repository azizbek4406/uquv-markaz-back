package net.idrok.oquvmarkaz.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

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



    @ManyToOne
    private Guruh guruh;

    @ManyToOne
    private Fayl fayl;

    private String info;

    private Boolean tulovVaqtKeldi;

    public Oquvchi() {
    }

    public Oquvchi(Long id, String ism, String familiya, Long telNomer, LocalDate kelganKuni, Long kelishilganSumma, String jins, Guruh guruh, Fayl fayl, String info, Boolean tulovVaqtKeldi) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.telNomer = telNomer;
        this.kelganKuni = kelganKuni;
        this.kelishilganSumma = kelishilganSumma;
        this.jins = jins;
        this.guruh = guruh;
        this.fayl = fayl;
        this.info = info;
        this.tulovVaqtKeldi = tulovVaqtKeldi;
    }

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

    public Long getTelNomer() {
        return telNomer;
    }

    public void setTelNomer(Long telNomer) {
        this.telNomer = telNomer;
    }

    public LocalDate getKelganKuni() {
        return kelganKuni;
    }

    public void setKelganKuni(LocalDate kelganKuni) {
        this.kelganKuni = kelganKuni;
    }

    public Long getKelishilganSumma() {
        return kelishilganSumma;
    }

    public void setKelishilganSumma(Long kelishilganSumma) {
        this.kelishilganSumma = kelishilganSumma;
    }

    public String getJins() {
        return jins;
    }

    public void setJins(String jins) {
        this.jins = jins;
    }

    public Guruh getGuruh() {
        return guruh;
    }

    public void setGuruh(Guruh guruh) {
        this.guruh = guruh;
    }

    public Fayl getFayl() {
        return fayl;
    }

    public void setFayl(Fayl fayl) {
        this.fayl = fayl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getTulovVaqtKeldi() {
        return tulovVaqtKeldi;
    }

    public void setTulovVaqtKeldi(Boolean tulovVaqtKeldi) {
        this.tulovVaqtKeldi = tulovVaqtKeldi;
    }
}
