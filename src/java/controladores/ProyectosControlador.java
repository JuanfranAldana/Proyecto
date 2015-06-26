package controladores;

import dao.AprobadosFacade;
import dao.InstitucionesFacade;
import dao.MetasFacade;
import dao.ProyectosFacade;
import dao.RepresentantesFacade;
import dao.SeguimientosFacade;
import dao.ActividadesFacade;
import entidades.Actividades;
import entidades.Aprobados;
import entidades.Instituciones;
import entidades.Metas;
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
    private ActividadesFacade actividadesFacade;
    
    @EJB
    private ProyectosFacade proyectosFacade;
    private Proyectos proyectoSeleccionado = new Proyectos();
    private Proyectos nuevoProyecto = new Proyectos();
    
    @EJB
    private InstitucionesFacade institucionesFacade;
    private Instituciones institucionSeleccionada = new Instituciones();  
    private int instSeleccionada;
    
    @EJB
    private RepresentantesFacade representantesFacade;
    
    @EJB
    private SeguimientosFacade seguimientosFacade;
    private Seguimientos seguimientoSeleccionado = new Seguimientos();  
    
    @EJB
    private AprobadosFacade aprobadosFacade;
    
    @EJB
    private MetasFacade metasFacade;
    private Metas metaSeleccionada = new Metas();
    
    private int meta;
    
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
    
    //Método que devuelve lista de Aprobados
    public List<Aprobados> todosAprobados(){
        return getAprobadosFacade().findAll();}
    
    //Método que devuelve lista de Aprobados
    public List<Metas> todosMetas(){
        return getMetasFacade().findAll();}
    
    //Método que devuelve lista de Aprobados
    public List<Actividades> todosActividadesporMeta(){
        return getActividadesFacade().buscarMeta(meta); }
    
    //Método que devuelve lista de Representantes filtrados por Id de Institución
    /*public List<Representantes> representantesFiltrados(){
        return getRepresentantesFacade().buscarRep(repre);
    }*/

/////**********************************************************************/////
    
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
    //Método Get para obtener datos de entidad Aprobados
    public AprobadosFacade getAprobadosFacade() {
        return aprobadosFacade;
    }
    //Método Get para obtener datos de entidad Metas
    public MetasFacade getMetasFacade() {
        return metasFacade;
    }
    //Método Get para obtener datos de entidad Actividades
    public ActividadesFacade getActividadesFacade() {
        return actividadesFacade;
    }
    
/////**********************************************************************/////
    
    //Métodos Get y Set para nuevoProyecto
    public Proyectos getNuevoProyecto() {
        return nuevoProyecto;
    }
    public void setNuevoProyecto(Proyectos nuevoProyecto) {
        this.nuevoProyecto = nuevoProyecto;
    }
    
/////**********************************************************************/////

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

    //Métodos Get y Set para metaSeleccionada
    public Metas getMetaSeleccionada() {
        return metaSeleccionada;
    }
    public void setMetaSeleccionada(Metas metaSeleccionada) {
        this.metaSeleccionada = metaSeleccionada;
    }

    //Métodos Get y Set para seguimientoSeleccionado
    public Seguimientos getSeguimientoSeleccionado() {
        return seguimientoSeleccionado;
    }
    public void setSeguimientoSeleccionado(Seguimientos seguimientoSeleccionado) {
        this.seguimientoSeleccionado = seguimientoSeleccionado;
    }

/////**********************************************************************/////
    
    //Métodos Get y Set para variable repreSeleccionado (Para lista dependiente)
    public int getInstSeleccionada() {
        return instSeleccionada;
    }
    public void setInstSeleccionada(int instSeleccionada) {
        this.instSeleccionada = instSeleccionada;
    }

    //Métodos Get y Set para variable meta (Para lista de actividades por meta)
    public int getMeta() {
        return meta;
    }
    public void setMeta(int meta) {
        this.meta = meta;
    }
    
/////**********************************************************************/////
    
    //Método para guardar a la entidad Proyectos
    public void guardarProyecto() {
        getProyectosFacade().create(nuevoProyecto);
        nuevoProyecto = new Proyectos();
    }
    
    //Método para actualizar el estado de proyectos
    public void actializaEstado(){
        getProyectosFacade().edit(proyectoSeleccionado);
    }
}
