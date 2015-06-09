package controladores;

import dao.InstitucionesFacade;
import dao.ProyectosFacade;
import dao.RepresentantesFacade;
import dao.SeguimientosFacade;
import entidades.Instituciones;
import entidades.Proyectos;
import entidades.Representantes;
import entidades.Seguimientos;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ProyectosControlador implements Serializable {
    
    @EJB
    private ProyectosFacade proyectosFacade;
    private Proyectos proyectoSeleccionado = new Proyectos();
    private Proyectos nuevoProyecto = new Proyectos();
    
    @EJB
    private InstitucionesFacade institucionesFacade;
    private Instituciones institucionSeleccionada = new Instituciones();  
    
    @EJB
    private RepresentantesFacade representantesFacade;
    
    @EJB
    private SeguimientosFacade seguimientosFacade;
    
    //Creates a new instance of proyectosControlador
    public ProyectosControlador() {
    }
    
    //Método que devuelve lista de Proyectos Ingresados
    public List<Proyectos> todosProyectosIngresados(){
        return getProyectosFacade().findByEstado();}
    
    //Método que devuelve lista de Proyectos
    public List<Proyectos> todosProyectos(){
        return getProyectosFacade().findAll();}
    
    //Método que devuelve lista de Instituciones
    public List<Instituciones> todosInstituciones(){
        return getInstitucionesFacade().findAll();}
    
    //Método que devuelve lista de Representantes
    public List<Representantes> todosRepresentantes(){
        return getRepresentantesFacade().findAll();}
    
    //Método que devuelve lista de Seguimientos
    public List<Seguimientos> todosSeguimientos(){
        return getSeguimientosFacade().findAll();}
    
    
    
    //Método Get para obtener datos de entidad Proyectos
    public ProyectosFacade getProyectosFacade() {
        return proyectosFacade;
    }
    
    //Método Get para obtener datos de entidad Instituciones
    public InstitucionesFacade getInstitucionesFacade() {
        return institucionesFacade;
    }
    
    //Método Get para obtener datos de entidad Representantes
    public RepresentantesFacade getRepresentantesFacade() {
        return representantesFacade;
    }
    
    //Método Get para obtener datos de entidad Seguimientos
    public SeguimientosFacade getSeguimientosFacade() {
        return seguimientosFacade;
    }
    
    
    
    //Métodos Get y Set para nuevoProyecto
    public Proyectos getNuevoProyecto() {
        return nuevoProyecto;
    }
    public void setNuevoProyecto(Proyectos nuevoProyecto) {
        this.nuevoProyecto = nuevoProyecto;
    }
    


    //Métodos Get y Set para proyectoSeleccionado
    public Proyectos getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }
    public void setProyectoSeleccionado(Proyectos proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }

    //Métodos Get y Set para institucionSeleccionada
    public Instituciones getInstitucionSeleccionada() {
        return institucionSeleccionada;
    }
    public void setInstitucionSeleccionada(Instituciones institucionSeleccionada) {
        this.institucionSeleccionada = institucionSeleccionada;
    }

    
    
    //Método para guardar a la entidad Proyectos
    public void guardarProyecto() {
        getProyectosFacade().create(nuevoProyecto);
        nuevoProyecto = new Proyectos();
    }
    
}
