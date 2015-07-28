package controladores;

import dao.ActividadesFacade;
import dao.AprobadosFacade;
import dao.CategoriaSeguimientosFacade;
import dao.DireccionesNacionalesFacade;
import dao.FacilitadoresTecnicosFacade;
import dao.HistoricosFacade;
import dao.InstitucionesFacade;
import dao.MesesFacade;
import dao.MetasFacade;
import dao.ProyectosFacade;
import dao.RepresentantesFacade;
import dao.SeguimientosFacade;
import dao.SubCatseguimientosFacade;
import entidades.Actividades;
import entidades.Aprobados;
import entidades.CategoriaSeguimientos;
import entidades.DireccionesNacionales;
import entidades.Estados;
import entidades.FacilitadoresTecnicos;
import entidades.Historicos;
import entidades.Instituciones;
import entidades.Meses;
import entidades.Metas;
import entidades.Proyectos;
import entidades.Representantes;
import entidades.Seguimientos;
import entidades.SubCatseguimientos;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean
@SessionScoped
public class ProyectosControlador implements Serializable {
    
    @EJB
    private ActividadesFacade actividadesFacade;
    private Actividades actividadSeleccionada = new Actividades();
    private Actividades nuevaActividad = new Actividades();
    
    @EJB
    private AprobadosFacade aprobadosFacade;
    
    @EJB
    private CategoriaSeguimientosFacade categoriaSeguimientosFacade;
    
    @EJB
    private DireccionesNacionalesFacade direccionesNacionalesFacade;
    
    @EJB
    private FacilitadoresTecnicosFacade facilitadoresTecnicosFacade;
    
    @EJB
    private HistoricosFacade historicosFacade;
    private Historicos historicoSeleccionado = new Historicos();
    private Historicos nuevoHistorico = new Historicos();
    
    @EJB
    private InstitucionesFacade institucionesFacade;
    private Instituciones institucionSeleccionada = new Instituciones();  
    private int instSeleccionada;
    
    @EJB
    private MesesFacade mesesFacade;
    
    @EJB
    private MetasFacade metasFacade;
    private Metas metaSeleccionada = new Metas();
    private Metas nuevaMeta = new Metas();
    
    @EJB
    private ProyectosFacade proyectosFacade;
    private Proyectos proyectoSeleccionado = new Proyectos();
    private Proyectos nuevoProyecto = new Proyectos();
    
    @EJB
    private RepresentantesFacade representantesFacade;
    
    @EJB
    private SeguimientosFacade seguimientosFacade;
    private Seguimientos seguimientoSeleccionado = new Seguimientos();  
    
    @EJB
    private SubCatseguimientosFacade subCatseguimientosFacade;
    
    //
    private int direccion;
    private int meta;
    private int proyecto;
    private int inst;
    private int proyec;
    private int categoria;
    
    //Variable para fecha predefinida del sistema
    private Date fechaFinalizacion = new Date();
    
    //Creates a new instance of proyectosControlador
    public ProyectosControlador() {
    }
    
    /////**********************************************************************/////
    
    
    //Método que devuelve lista de Actividades por Metas
    public List<Actividades> todosActividadesporMeta(){
        return getActividadesFacade().buscarMeta(meta); }
    
    //Método que devuelve lista de Aprobados
    public List<Aprobados> todosAprobados(){
        return getAprobadosFacade().findAll();}
    
    //Método que devuelve lista de Categorias de Seguimientos
    public List<CategoriaSeguimientos> todosCategoriaSeguimientos(){
        return getCategoriaSeguimientosFacade().findAll();}
    
    //Método que devuelve lista de Direcciones Nacionales
    public List<DireccionesNacionales> todosDireccionesNacionales(){
        return getDireccionesNacionalesFacade().findAll();}
    
    //Método que devuelve lista de Facilitadores Administrativos
    public List<FacilitadoresTecnicos> todosFacilitadoresAdministrativos(){
        return getFacilitadoresTecnicosFacade().findByTipoAdministrativo();}
    
    //Método que devuelve lista de Facilitadores Culturales
    public List<FacilitadoresTecnicos> todosFacilitadoresCulturales(){
        return getFacilitadoresTecnicosFacade().findByTipoCultural();}
    
    //Método que devuelve lista de Facilitadores Técnicos
    public List<FacilitadoresTecnicos> todosFacilitadoresTecnicos(){
        return getFacilitadoresTecnicosFacade().findByTipoTecnico();}
    
    //Método que devuelve lista de Historicos de Proyectos
    public List<Historicos> todosHistoricos(){
        return getHistoricosFacade().findAll();}
    
    //Método que devuelve lista de Instituciones
    public List<Instituciones> todosInstituciones(){
        return getInstitucionesFacade().findAll();}
    
    //Método que devuelve lista de Meses
    public List<Meses> todosMeses(){
        return getMesesFacade().findAll();}
    
    //Método que devuelve lista de Metas
    public List<Metas> todosMetas(){
        return getMetasFacade().findAll();}
    
    //Método que devuelve lista de Metas por Proyecto
    public List<Metas> todasMetasByProyecto(){
        return getMetasFacade().findMetaByProyecto(proyec);}
    
    //Método que devuelve lista de Proyectos
    public List<Proyectos> todosProyectos(){
        return getProyectosFacade().findAll();}
    
    //Método que devuelve lista de Proyectos Aprobados
    public List<Proyectos> todosProyectosAprobados(){
        return getProyectosFacade().findByEstadoAprobado();}
    
    //Método que devuelve lista de Proyectos Ingresados
    public List<Proyectos> todosProyectosIngresados(){
        return getProyectosFacade().findByEstadoIngresado();}
    
    //Método que devuelve lista de Proyectos Institucion
    public List<Proyectos> todosProyectosByInstitucion(){
        return getProyectosFacade().findByInstitucionId(inst);}
    
    //Método que devuelve lista de Representantes
    public List<Representantes> todosRepresentantes(){
        return getRepresentantesFacade().findAll();}
    
    //Método que devuelve lista de Seguimientos
    public List<Seguimientos> todosSeguimientos(){
        return getSeguimientosFacade().findAll();}
    
    //Método que devuelve lista de Seguimientos por Proyecto
    public List<Seguimientos> todosSeguimientosByProyect(){
        return getSeguimientosFacade().buscarSeg(proyecto);}
    
    //Método que devuelve lista de SubSeguimientos por Categoria
    public List<SubCatseguimientos> todosSubSeguimientosByCategoria(){
        return getSubCatseguimientosFacade().findSubSeguimientosByCategoria(categoria);}
    
    //Método que devuelve lista de Representantes por Institución
    /*public List<Representantes> representantesFiltrados(){
        return getRepresentantesFacade().buscarRep(repre);
    }*/

    
/////**********************************************************************/////
    
    
    //Método Get para obtener datos de entidad Actividades
    public ActividadesFacade getActividadesFacade() {
        return actividadesFacade;}
    
    //Método Get para obtener datos de entidad Aprobados
    public AprobadosFacade getAprobadosFacade() {
        return aprobadosFacade;}
    
    //Método Get para obtener datos de entidad Categoria de Seguimientos
    public CategoriaSeguimientosFacade getCategoriaSeguimientosFacade() {
        return categoriaSeguimientosFacade;}

    //Método Get para obtener datos de entidad Direcciones Nacionales
    public DireccionesNacionalesFacade getDireccionesNacionalesFacade() {
        return direccionesNacionalesFacade;}

    //Método Get para obtener datos de entidad Facilitadores
    public FacilitadoresTecnicosFacade getFacilitadoresTecnicosFacade() {
        return facilitadoresTecnicosFacade;}

    //Método Get para obtener datos de entidad Historicos
    public HistoricosFacade getHistoricosFacade() {
        return historicosFacade;}

    //Método Get para obtener datos de entidad Instituciones
    public InstitucionesFacade getInstitucionesFacade() {
        return institucionesFacade;}
    
    //Método Get para obtener datos de entidad Meses
    public MesesFacade getMesesFacade() {
        return mesesFacade;}

    //Método Get para obtener datos de entidad Metas
    public MetasFacade getMetasFacade() {
        return metasFacade;}
    
    //Método Get para obtener datos de entidad Proyectos
    public ProyectosFacade getProyectosFacade() {
        return proyectosFacade;}
    
    //Método Get para obtener datos de entidad Representantes
    public RepresentantesFacade getRepresentantesFacade() {
        return representantesFacade;}
    
    //Método Get para obtener datos de entidad Seguimientos
    public SeguimientosFacade getSeguimientosFacade() {
        return seguimientosFacade;}
    
    //Método Get para obtener datos de entidad Sub Categoria de Seguimientos
    public SubCatseguimientosFacade getSubCatseguimientosFacade() {
        return subCatseguimientosFacade;}
    
    
/////**********************************************************************/////
    
    
    //Métodos Get y Set para nuevaActividad
    public Actividades getNuevaActividad() {
        return nuevaActividad;
    }
    public void setNuevaActividad(Actividades nuevaActividad) {
        this.nuevaActividad = nuevaActividad;
    }
    
    //Métodos Get y Set para nuevoHistorico
    public Historicos getNuevoHistorico() {
        return nuevoHistorico;
    }
    public void setNuevoHistorico(Historicos nuevoHistorico) {
        this.nuevoHistorico = nuevoHistorico;
    }

    //Métodos Get y Set para nuevaMeta
    public Metas getNuevaMeta() {
        return nuevaMeta;
    }
    public void setNuevaMeta(Metas nuevaMeta) {
        this.nuevaMeta = nuevaMeta;
    }

    //Métodos Get y Set para nuevoProyecto
    public Proyectos getNuevoProyecto() {
        return nuevoProyecto;
    }
    public void setNuevoProyecto(Proyectos nuevoProyecto) {
        this.nuevoProyecto = nuevoProyecto;
    }
    
    
/////**********************************************************************/////

    
    //Métodos Get y Set para actividadSeleccionada
    public Actividades getActividadSeleccionada() {
        return actividadSeleccionada;
    }
    public void setActividadSeleccionada(Actividades actividadSeleccionada) {
        this.actividadSeleccionada = actividadSeleccionada;
    }

    //Métodos Get y Set para historicoSeleccionado
    public Historicos getHistoricoSeleccionado() {
        return historicoSeleccionado;
    }
    public void setHistoricoSeleccionado(Historicos historicoSeleccionado) {
        this.historicoSeleccionado = historicoSeleccionado;
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

    //Métodos Get y Set para proyectoSeleccionado
    public Proyectos getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }
    public void setProyectoSeleccionado(Proyectos proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }

    //Métodos Get y Set para seguimientoSeleccionado
    public Seguimientos getSeguimientoSeleccionado() {
        return seguimientoSeleccionado;
    }
    public void setSeguimientoSeleccionado(Seguimientos seguimientoSeleccionado) {
        this.seguimientoSeleccionado = seguimientoSeleccionado;
    }

    
/////**********************************************************************/////
    
    
    //Métodos Get y Set para variable repreSeleccionado (Para lista dependiente No lo ocupo por el momento)
    public int getInstSeleccionada() {
        return instSeleccionada;
    }
    public void setInstSeleccionada(int instSeleccionada) {
        this.instSeleccionada = instSeleccionada;
    }

    //Métodos Get y Set para parametro actividades por meta (ver_metas)
    public int getMeta() {
        return meta;
    }
    public void setMeta(int meta) {
        this.meta = meta;
    }

    //Metodos Get y Set para parametro proyectos por institucion (mto_actividades)
    public int getInst() {
        return inst;
    }
    public void setInst(int inst) {
        this.inst = inst;
    }

    //Metodos Get y Set para parametro metas por proyecto (mto_actividades)
    public int getProyec() {
        return proyec;
    }
    public void setProyec(int proyec) {
        this.proyec = proyec;
    }

    //Metodos Get y Set para variable de fecha predefinida por el sistema
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    
/////**********************************************************************/////

    //NSDOE//

    //Métodos Get y Set para variable direccion
    public int getDireccion() {
        return direccion;
    }
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    //Métodos Get y Set para variable proyecto
    public int getProyecto() {
        return proyecto;
    }
    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    //Métodos Get y Set para variable categoria
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    
/////**********************************************************************/////
    
    //Método para guardar a la entidad Proyectos (Aun no funciona)
    public void guardarProyecto() {
        getProyectosFacade().create(nuevoProyecto);
        nuevoProyecto = new Proyectos();
    }
    
    //Método para actualizar el estado de proyectos
    private int estadofin=5;
    public void actualizaEstado(){
        proyectoSeleccionado.setEstadoId(new Estados(estadofin));
        getProyectosFacade().edit(proyectoSeleccionado);
    }
    
    //Método para guardar a la entidad Metas
    public void guardarMeta() {
        //nuevaMeta.setProyeId(new Proyectos(proyectoSeleccionado));
        nuevaMeta.setProyeId(proyectoSeleccionado);
        getMetasFacade().create(nuevaMeta);
        nuevaMeta = new Metas();
    }
    
    //Método para guardar a la entidad Historicos
    public void guardarHistorico(){
        nuevoHistorico.setDnacId(new DireccionesNacionales(direccion));
        getHistoricosFacade().create(nuevoHistorico);
        nuevoHistorico = new Historicos();
    }
    
    
/////**********************************************************************/////
    
    
    //Método para actualizar Metas
    public void actualizarMeta(){
        getMetasFacade().edit(metaSeleccionada);
    }
    
    
    //Método para recetear los seleccionables 
    public void cancelar() {
        direccion=0;
        inst=0;
    }
    
    
}
