package ec.com.sisapus.modelo;
// Generated 11/01/2015 05:37:11 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Manoobra generated by hbm2java
 */
public class Manoobra  implements java.io.Serializable {


     private Integer codigoManob;
     private Categoriamanoobra categoriamanoobra;
     private String nombreManob;
     private Double costojrhManob;
     private Set manoobraApus = new HashSet(0);

    public Manoobra() {
        this.codigoManob=0;
        this.categoriamanoobra = new Categoriamanoobra();
    }

    public Manoobra(Categoriamanoobra categoriamanoobra, String nombreManob, Double costojrhManob, Set manoobraApus) {
       this.categoriamanoobra = categoriamanoobra;
       this.nombreManob = nombreManob;
       this.costojrhManob = costojrhManob;
       this.manoobraApus = manoobraApus;
    }
   
    public Integer getCodigoManob() {
        return this.codigoManob;
    }
    
    public void setCodigoManob(Integer codigoManob) {
        this.codigoManob = codigoManob;
    }
    public Categoriamanoobra getCategoriamanoobra() {
        return this.categoriamanoobra;
    }
    
    public void setCategoriamanoobra(Categoriamanoobra categoriamanoobra) {
        this.categoriamanoobra = categoriamanoobra;
    }
    public String getNombreManob() {
        return this.nombreManob;
    }
    
    public void setNombreManob(String nombreManob) {
        this.nombreManob = nombreManob;
    }
    public Double getCostojrhManob() {
        return this.costojrhManob;
    }
    
    public void setCostojrhManob(Double costojrhManob) {
        this.costojrhManob = costojrhManob;
    }
    public Set getManoobraApus() {
        return this.manoobraApus;
    }
    
    public void setManoobraApus(Set manoobraApus) {
        this.manoobraApus = manoobraApus;
    }




}


