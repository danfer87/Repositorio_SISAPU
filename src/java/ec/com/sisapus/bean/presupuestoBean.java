package ec.com.sisapus.bean;

import ec.com.sisapus.daoimpl.ApusDaoImpl;
import ec.com.sisapus.daoimpl.presupuestoDaoImpl;
import ec.com.sisapus.daoimpl.proyectoDaoImpl;
import ec.com.sisapus.daoimpl.rubroDaoImplInterface;
import ec.com.sisapus.modelo.Analisispreciounitario;
import ec.com.sisapus.modelo.CabeceraPresupuesto;
import ec.com.sisapus.modelo.DetallePresupuesto;
import ec.com.sisapus.modelo.Proyecto;
import ec.com.sisapus.modelo.Rubro;
import ec.com.sisapus.util.HibernateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Edison
 */
public class presupuestoBean implements Serializable {
    Session session;
    Transaction transaction;
    
    //Variables de la Cabecera del Presupuesto
    private CabeceraPresupuesto cabpresupuesto;
    private Double precioTotApuRubro;
    private Double porcentajeiva;
    private Double precioTiva;
    private Double subtotalPres;
    private Double costoPresupuesto;
    private List<CabeceraPresupuesto> listaCabPresupuestos;
    //Variables de la Detalle del Presupuesto
    private DetallePresupuesto detpresupuesto;
    private Double nombreDetPres;
    private Double cantidadDetPres;
    private Double precioUnitDetPres;
    private Double precioTotDetPres;
    private List<DetallePresupuesto> listaDetPresupuestos;
    //Variables de Proyecto
    private Proyecto proyecto;
    private List<Proyecto> listaProyecto;
    private Integer codigoproyecto;
    private String propietarioproyecto;
    private String contratistaproyecto;
    private String obraproyecto;
    private String ubicacionproyecto;
    private Date fechaproyecto;
    private Double costoproyecto;
    //Variables del APU
    private Analisispreciounitario apu;
    private List<Analisispreciounitario> listaApus;
    //Variables de Rubro
    private Rubro rubro;
    
    
    public presupuestoBean() {
        
        this.listaApus = new ArrayList<>();
        this.listaCabPresupuestos = new ArrayList<>();
        this.cabpresupuesto = new CabeceraPresupuesto();
        this.listaDetPresupuestos = new ArrayList<>();
        this.detpresupuesto = new DetallePresupuesto();
        this.proyecto = new Proyecto();
        this.apu = new Analisispreciounitario();
        this.rubro = new Rubro();
        this.codigoproyecto = 0;
        this.propietarioproyecto = "";
        this.contratistaproyecto = "";
        this.obraproyecto = "";
        this.ubicacionproyecto = "";
        this.fechaproyecto = null;
        this.costoproyecto = 0.0;
    }
    
    ///// Getters and Setters
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
//////
    public Double getCostoPresupuesto() {
        return costoPresupuesto;
    }

    public void setCostoPresupuesto(Double costoPresupuesto) {
        this.costoPresupuesto = costoPresupuesto;
    }
    
      
    //Getters y Setters de Proyecto
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getCodigoproyecto() {
        return codigoproyecto;
    }

    public void setCodigoproyecto(Integer codigoproyecto) {
        this.codigoproyecto = codigoproyecto;
    }

    public String getPropietarioproyecto() {
        return propietarioproyecto;
    }

    public void setPropietarioproyecto(String propietarioproyecto) {
        this.propietarioproyecto = propietarioproyecto;
    }

    public String getContratistaproyecto() {
        return contratistaproyecto;
    }

    public void setContratistaproyecto(String contratistaproyecto) {
        this.contratistaproyecto = contratistaproyecto;
    }

    public String getObraproyecto() {
        return obraproyecto;
    }

    public void setObraproyecto(String obraproyecto) {
        this.obraproyecto = obraproyecto;
    }

    public String getUbicacionproyecto() {
        return ubicacionproyecto;
    }

    public void setUbicacionproyecto(String ubicacionproyecto) {
        this.ubicacionproyecto = ubicacionproyecto;
    }

    public Date getFechaproyecto() {
        return fechaproyecto;
    }

    public void setFechaproyecto(Date fechaproyecto) {
        this.fechaproyecto = fechaproyecto;
    }

    public Double getCostoproyecto() {
        return costoproyecto;
    }

    public void setCostoproyecto(Double costoproyecto) {
        this.costoproyecto = costoproyecto;
    }
    
    
    ///// Getter y Setter APU
    public Analisispreciounitario getApu() {
        return apu;
    }

    public void setApu(Analisispreciounitario apu) {
        this.apu = apu;
    }

    public List<Analisispreciounitario> getListaApus() {
        return listaApus;
    }

    public void setListaApus(List<Analisispreciounitario> listaApus) {
        this.listaApus = listaApus;
    }
    
    ///Getter y Setter de Presupuesto
    public CabeceraPresupuesto getCabpresupuesto() {
        return cabpresupuesto;
    }

    public void setCabpresupuesto(CabeceraPresupuesto cabpresupuesto) {
        this.cabpresupuesto = cabpresupuesto;
    }

    public List<CabeceraPresupuesto> getListaCabPresupuestos() {
        return listaCabPresupuestos;
    }

    public void setListaCabPresupuestos(List<CabeceraPresupuesto> listaCabPresupuestos) {
        this.listaCabPresupuestos = listaCabPresupuestos;
    }

    public DetallePresupuesto getDetpresupuesto() {
        return detpresupuesto;
    }

    public void setDetpresupuesto(DetallePresupuesto detpresupuesto) {
        this.detpresupuesto = detpresupuesto;
    }

    public Double getNombreDetPres() {
        return nombreDetPres;
    }

    public void setNombreDetPres(Double nombreDetPres) {
        this.nombreDetPres = nombreDetPres;
    }

    public Double getCantidadDetPres() {
        return cantidadDetPres;
    }

    public void setCantidadDetPres(Double cantidadDetPres) {
        this.cantidadDetPres = cantidadDetPres;
    }

    public Double getPrecioUnitDetPres() {
        return precioUnitDetPres;
    }

    public void setPrecioUnitDetPres(Double precioUnitDetPres) {
        this.precioUnitDetPres = precioUnitDetPres;
    }

    public Double getPrecioTotDetPres() {
        return precioTotDetPres;
    }

    public void setPrecioTotDetPres(Double precioTotDetPres) {
        this.precioTotDetPres = precioTotDetPres;
    }

    public List<DetallePresupuesto> getListaDetPresupuestos() {
        return listaDetPresupuestos;
    }

    public void setListaDetPresupuestos(List<DetallePresupuesto> listaDetPresupuestos) {
        this.listaDetPresupuestos = listaDetPresupuestos;
    }

    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }
   ///////////////////////

    public Double getPrecioTotApuRubro() {
        return precioTotApuRubro;
    }

    public void setPrecioTotApuRubro(Double precioTotApuRubro) {
        this.precioTotApuRubro = precioTotApuRubro;
    }
    
    public Double getPorcentajeiva() {
        return porcentajeiva;
    }

    public void setPorcentajeiva(Double porcentajeiva) {
        this.porcentajeiva = porcentajeiva;
    }

    public Double getPrecioTiva() {
        return precioTiva;
    }

    public void setPrecioTiva(Double precioTiva) {
        this.precioTiva = precioTiva;
    }
    
    public Double getSubtotalPres() {
        return subtotalPres;
    }

    public void setSubtotalPres(Double subtotalPres) {
        this.subtotalPres = subtotalPres;
    }
    
    //Getter Setter Rubro
    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
   
    ///Funcion para agregar un proyecto al presupuesto
    
    public void agregarProyectoPresup(Integer idproyecto) {
        
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            
            proyectoDaoImpl daoproyecto = new proyectoDaoImpl();
            
            this.transaction = this.session.beginTransaction();
            
            this.proyecto = daoproyecto.obtenerProyectoPorId(session, idproyecto);
            
            this.setCodigoproyecto(this.proyecto.getCodigoProy());
            this.setContratistaproyecto(this.proyecto.getContratProy());
            this.setPropietarioproyecto(this.proyecto.getPropiepProy());
            this.setObraproyecto(this.proyecto.getObraProy());
            this.setUbicacionproyecto(this.proyecto.getUbicProy());
            this.setFechaproyecto(this.proyecto.getFechaProy());

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Proyecto Seleccionado"));

            RequestContext.getCurrentInstance().update("frmPresupuesto:cabeceraPresupuesto");
            RequestContext.getCurrentInstance().update("frmPresupuesto:mensajeGeneralPresupuesto");

        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
    
    ///Funcion para agregar los apus al presupuesto
    public void agregarApus(Integer idApu) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            ApusDaoImpl daoapu = new ApusDaoImpl();

            this.transaction = this.session.beginTransaction();
            this.apu = daoapu.obtenerApuPorId(session, idApu);
            
            this.listaDetPresupuestos.add(new DetallePresupuesto(null,null,apu.getDescApu(),this.apu.getUnidadApu(),null,0,this.apu.getCostotApu(),new Double("0.00")));
            
            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Apu del rubro agregado"));

            RequestContext.getCurrentInstance().update("frmPresupuesto:tablaDetallePresupuesto");
            RequestContext.getCurrentInstance().update("frmPresupuesto:mensajeGeneralPresupuesto");


        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
    
    public void EliminarApuLista(String nombrePres) {
        try {
            int i = 0;

            for (DetallePresupuesto presup : this.listaDetPresupuestos) {
                if (presup.getNombreDetPres().equals(nombrePres)) {
                    this.listaDetPresupuestos.remove(i);
                    break;
                }
                i++;
            }
            Double subtotalPresup = new Double("0.00");
            Double ivaPres = new Double("0.00");
            Double valorTotalPres = new Double("0.00");
            
            for (DetallePresupuesto presup : this.listaDetPresupuestos) 
            {
                Double costototalapurubro = (new Double(presup.getCantidadDetPres())) * (new Double(presup.getPunitDetPres()));
                presup.setPtotDetPres(costototalapurubro);
                subtotalPresup = subtotalPresup + costototalapurubro;
            }
            this.setPrecioTotApuRubro(subtotalPresup);
            ivaPres = (subtotalPresup * (this.porcentajeiva/100));
            this.setPrecioTiva(ivaPres);
            valorTotalPres=subtotalPresup+ivaPres;
            this.setCostoPresupuesto(valorTotalPres);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Rubro retirado de la lista"));

            RequestContext.getCurrentInstance().update("frmPresupuesto:tablaDetallePresupuesto");
            RequestContext.getCurrentInstance().update("frmPresupuesto:panelFinalPres");
            RequestContext.getCurrentInstance().update("frmPresupuesto:panelPresupuestar");
            RequestContext.getCurrentInstance().update("frmPresupuesto:mensajeGeneralPresupuesto");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }
    
    public void calcularCostosPresupuesto() {
        
        try {
            
            Double subtotalPresup = new Double("0.00");
            Double ivaPres = new Double("0.00");
            Double valorTotalPres = new Double("0.00");
            
           for (DetallePresupuesto presup : this.listaDetPresupuestos) 
            {
                Double costototalapurubro = (new Double(presup.getCantidadDetPres())) * (new Double(presup.getPunitDetPres()));
                presup.setPtotDetPres(costototalapurubro);
                subtotalPresup = subtotalPresup + costototalapurubro;
            }
            
            ivaPres = (subtotalPresup * (this.porcentajeiva/100));
            valorTotalPres = subtotalPresup + ivaPres;
            ////
            this.cabpresupuesto.setSubtPres(subtotalPresup);
            this.cabpresupuesto.setIvaPres(ivaPres);
            this.cabpresupuesto.setGastotPres(valorTotalPres);
            
            ///
            this.setPrecioTotApuRubro(subtotalPresup);
            this.setPrecioTiva(ivaPres);
            this.setCostoPresupuesto(valorTotalPres);
            
            RequestContext.getCurrentInstance().update("frmPresupuesto:tablaDetallePresupuesto");
            RequestContext.getCurrentInstance().update("frmPresupuesto:panelFinalPres");
            RequestContext.getCurrentInstance().update("frmPresupuesto:panelPresupuestar");
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }
    
    public void guardarPresupuesto() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            
            //this.presupuesto.setDescripPres(getObraproyecto());
            this.cabpresupuesto.setDescripPres(getObraproyecto());
            this.cabpresupuesto.setProyecto(proyecto);
            
            ApusDaoImpl apusdao = new ApusDaoImpl();
            presupuestoDaoImpl presDao = new presupuestoDaoImpl();
            
            this.transaction = this.session.beginTransaction();
            presDao.insertaCabeceraPres(session, this.cabpresupuesto);
            this.cabpresupuesto = presDao.obtenerUltimoRegistroCabPres(session);
            this.apu = apusdao.getUltimoRegistroApu(session);

            for (DetallePresupuesto item : this.listaDetPresupuestos) {
                this.apu=apusdao.obtenerApuPorId(session, this.apu.getCodigoApu());
                item.setAnalisispreciounitario(this.apu);
                item.setCabeceraPresupuesto(cabpresupuesto);
                presDao.insertaDetallePres(session, item);
                
            }
            this.transaction.commit();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Presupuesto guardado correctamente"));
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
}
