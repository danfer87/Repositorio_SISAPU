package ec.com.sisapus.modelo;
// Generated 11/01/2015 05:37:11 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Categoriatransporte generated by hbm2java
 */
public class Categoriatransporte  implements java.io.Serializable {


     private Integer codCatTrans;
     private String nombCatTrans;
     private Set transportes = new HashSet(0);

    public Categoriatransporte() {
        this.codCatTrans = 0;
    }

    public Categoriatransporte(String nombCatTrans, Set transportes) {
       this.nombCatTrans = nombCatTrans;
       this.transportes = transportes;
    }
   
    public Integer getCodCatTrans() {
        return this.codCatTrans;
    }
    
    public void setCodCatTrans(Integer codCatTrans) {
        this.codCatTrans = codCatTrans;
    }
    public String getNombCatTrans() {
        return this.nombCatTrans;
    }
    
    public void setNombCatTrans(String nombCatTrans) {
        this.nombCatTrans = nombCatTrans;
    }
    public Set getTransportes() {
        return this.transportes;
    }
    
    public void setTransportes(Set transportes) {
        this.transportes = transportes;
    }




}


