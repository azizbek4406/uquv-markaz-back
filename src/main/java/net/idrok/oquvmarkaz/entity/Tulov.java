package net.idrok.oquvmarkaz.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Tulov {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String TulovKuni;

    @NotNull
    @Column(nullable = false)
    private String oy;

    private String yil;

    @ManyToOne
    private Oquvchi oquvchi;

    @Column(nullable = false)
    private String Summa;

    private Boolean tulovTasdiq;

    public Tulov() {
    }

    public Tulov(Long id, String tulovKuni, String oy, String yil, Oquvchi oquvchi, String summa, Boolean tulovTasdiq) {
        this.id = id;
        TulovKuni = tulovKuni;
        this.oy = oy;
        this.yil = yil;
        this.oquvchi = oquvchi;
        Summa = summa;
        this.tulovTasdiq = tulovTasdiq;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTulovKuni() {
        return TulovKuni;
    }

    public void setTulovKuni(String tulovKuni) {
        TulovKuni = tulovKuni;
    }

    public String getOy() {
        return oy;
    }

    public void setOy(String oy) {
        this.oy = oy;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public Oquvchi getOquvchi() {
        return oquvchi;
    }

    public void setOquvchi(Oquvchi oquvchi) {
        this.oquvchi = oquvchi;
    }

    public String getSumma() {
        return Summa;
    }

    public void setSumma(String summa) {
        Summa = summa;
    }

    public Boolean getTulovTasdiq() {
        return tulovTasdiq;
    }

    public void setTulovTasdiq(Boolean tulovTasdiq) {
        this.tulovTasdiq = tulovTasdiq;
    }
}

