package controladores;

import dao.CategoriaSeguimientosFacade;
import dao.ContinentesFacade;
import dao.DireccionesNacionalesFacade;
import dao.FacilitadoresTecnicosFacade;
import dao.FuentesFinanciamientoFacade;
import dao.InstitucionesFacade;
import dao.PaisesFacade;
import dao.RepresentantesFacade;
import dao.RolesFacade;
import dao.SubCatseguimientosFacade;
import dao.TiposFacilitadoresFacade;
import dao.UnidadesTecnicasFacade;
import dao.UsuariosFacade;
import entidades.CategoriaSeguimientos;
import entidades.Continentes;
import entidades.DireccionesNacionales;
import entidades.SubCatseguimientos;
import entidades.FacilitadoresTecnicos;
import entidades.FuentesFinanciamiento;
import entidades.Instituciones;
import entidades.Paises;
import entidades.Representantes;
import entidades.Roles;
import entidades.TiposFacilitadores;
import entidades.UnidadesTecnicas;
import entidades.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CatalogosControlador implements Serializable{
    
    @EJB
    private CategoriaSeguimientosFacade categoriaSeguimientosFacade;
    private CategoriaSeguimientos nuevaCategoria = new CategoriaSeguimientos();
    
    @EJB
    private DireccionesNacionalesFacade direccionesNacionalesFacade;
    private DireccionesNacionales nuevaDireccion = new DireccionesNacionales();
    private DireccionesNacionales direccionSeleccionada = new DireccionesNacionales();
    
    @EJB
    private FacilitadoresTecnicosFacade facilitadoresTecnicosFacade;
    private FacilitadoresTecnicos nuevoFacilitador = new FacilitadoresTecnicos();
    private FacilitadoresTecnicos facilitadorSeleccionada = new FacilitadoresTecnicos();
    
    @EJB
    private InstitucionesFacade institucionesFacade;
    private Instituciones nuevaInstitucion = new Instituciones();
    private Instituciones institucionSeleccionada = new Instituciones();
    
    @EJB
    private UnidadesTecnicasFacade unidadesTecnicasFacade;
    private UnidadesTecnicas nuevaUnidad = new UnidadesTecnicas();
    private UnidadesTecnicas unidadSeleccionada = new UnidadesTecnicas();
    
    @EJB
    private TiposFacilitadoresFacade tiposFacilitadoresFacade;
    private TiposFacilitadores nuevoTipo = new TiposFacilitadores();
    
    @EJB
    private FuentesFinanciamientoFacade fuentesFinanciamientoFacade;
    private FuentesFinanciamiento nuevaFuente = new FuentesFinanciamiento();
    
    @EJB
    private PaisesFacade paisesFacade;
    private Paises nuevoPais = new Paises();
    
    @EJB
    private ContinentesFacade continentesFacade;
    
    @EJB
    private RolesFacade rolesFacade;
    private Roles nuevoRol = new Roles();
    
    @EJB
    private UsuariosFacade usuariosFacade;
    private Usuarios nuevoUsuario = new Usuarios();
    private Usuarios usuarioSeleccionado = new Usuarios();
    
    @EJB
    private SubCatseguimientosFacade subCatseguimientosFacade;
    private SubCatseguimientos nuevaSubseguimientos = new SubCatseguimientos();
    private SubCatseguimientos subseguimientosSeleccionada = new SubCatseguimientos();
    
    @EJB
    private RepresentantesFacade representantesFacade;
    private Representantes nuevoRepresentante = new Representantes();
    private Representantes representanteSeleccionado = new Representantes();
    
    //Creates a new instance of catalogosControlador
    public CatalogosControlador() {
    }

    //Método que devuelve lista de Categorias de Seguimientos
    public List<CategoriaSeguimientos> todasCategoriaSeguimientos(){
        return getCategoriaSeguimientosFacade().findAll();}
    
    //Método que devuelve lista de Direcciones Nacionales 
    public List<DireccionesNacionales> todasDireccionesNacionales(){
        return getDireccionesNacionalesFacade().findAll();}
    
    //Método que devuelve lista de Facilitadores Técnicos
    public List<FacilitadoresTecnicos> todasFacilitadoresTecnicos(){
        return getFacilitadoresTecnicosFacade().findAll();}
    
    //Método que devuelve lista de Instituciones
    public List<Instituciones> todasInstituciones(){
        return getInstitucionesFacade().findAll();}
    
    //Método que devuelve lista de Unidades Técnicas
    public List<UnidadesTecnicas> todasUnidadesTecnicas(){
        return getUnidadesTecnicasFacade().findAll();}
    
    //Método que devuelve lista de Tipos de Facilitadores
    public List<TiposFacilitadores> todasTiposFacilitadores(){
        return getTiposFacilitadoresFacade().findAll();}
    
    //Método que devuelve lista de Fuentes de Financiamiento
    public List<FuentesFinanciamiento> todasFuentesFinanciamiento(){
        return getFuentesFinanciamientoFacade().findAll();}
    
    //Método que devuelve lista de Paises
    public List<Paises> todasPaises(){
        return getPaisesFacade().findAll();}

    //Método que devuelve lista de Continentes
    public List<Continentes> todasContinentes(){
        return getContinentesFacade().findAll();}
    
    //Método que devuelve lista de Roles
    public List<Roles> todasRoles(){
        return getRolesFacade().findAll();}
    
    //Método que devuelve lista de Usuarios
    public List<Usuarios> todasUsuarios(){
        return getUsuariosFacade().findAll();}
    
    //Método que devuelve lista de Sub Categoría de Seguimientos
    public List<SubCatseguimientos> todasSubCatseguimientos(){
        return getSubCatseguimientosFacade().findAll();}
    
    //Método que devuelve lista de Representantes
    public List<Representantes> todasRepresentantes(){
        return getRepresentantesFacade().findAll();}
    
    
    
    //Método Get para obtener datos de entidad CategoriaSeguimientos
    public CategoriaSeguimientosFacade getCategoriaSeguimientosFacade() {
        return categoriaSeguimientosFacade;
    }

    //Método Get para obtener datos de entidad DireccionesNacionales
    public DireccionesNacionalesFacade getDireccionesNacionalesFacade() {
        return direccionesNacionalesFacade;
    }

    //Método Get para obtener datos de entidad FacilitadoresTecnicos
    public FacilitadoresTecnicosFacade getFacilitadoresTecnicosFacade() {
        return facilitadoresTecnicosFacade;
    }
    
    //Método Get para obtener datos de entidad Instituciones
    public InstitucionesFacade getInstitucionesFacade() {
        return institucionesFacade;
    }
    
    //Método Get para obtener datos de entidad UnidadesTecnicas
    public UnidadesTecnicasFacade getUnidadesTecnicasFacade() {
        return unidadesTecnicasFacade;
    }
    
    //Método Get para obtener datos de entidad TiposFacilitadores
    public TiposFacilitadoresFacade getTiposFacilitadoresFacade() {
        return tiposFacilitadoresFacade;
    }
    
    //Método Get para obtener datos de entidad FuentesFinanciamiento
    public FuentesFinanciamientoFacade getFuentesFinanciamientoFacade() {
        return fuentesFinanciamientoFacade;
    }
    
    //Método Get para obtener datos de entidad Paises
    public PaisesFacade getPaisesFacade() {
        return paisesFacade;
    }
    
    //Método Get para obtener datos de entidad Continentes
    public ContinentesFacade getContinentesFacade() {
        return continentesFacade;
    }
    
    //Método Get para obtener datos de entidad Roles
    public RolesFacade getRolesFacade() {
        return rolesFacade;
    }
    
    //Método Get para obtener datos de entidad Usuarios
    public UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    //Método Get para obtener datos de entidad SubCatseguimientos
    public SubCatseguimientosFacade getSubCatseguimientosFacade() {
        return subCatseguimientosFacade;
    }

    //Método Get para obtener datos de entidad Representantes
    public RepresentantesFacade getRepresentantesFacade() {
        return representantesFacade;
    }
    
        
    
    //Métodos Get y Set para nuevaCategoria
    public CategoriaSeguimientos getNuevaCategoria() {
        return nuevaCategoria;
    }
    public void setNuevaCategoria(CategoriaSeguimientos nuevaCategoria) {
        this.nuevaCategoria = nuevaCategoria;
    }

    //Métodos Get y Set para nuevaDireccion
    public DireccionesNacionales getNuevaDireccion() {
        return nuevaDireccion;
    }
    public void setNuevaDireccion(DireccionesNacionales nuevaDireccion) {
        this.nuevaDireccion = nuevaDireccion;
    }
    
    //Métodos Get y Set para nuevoFacilitador
    public FacilitadoresTecnicos getNuevoFacilitador() {
        return nuevoFacilitador;
    }
    public void setNuevoFacilitador(FacilitadoresTecnicos nuevoFacilitador) {
        this.nuevoFacilitador = nuevoFacilitador;
    }

    //Métodos Get y Set para nuevaFuente
    public FuentesFinanciamiento getNuevaFuente() {
        return nuevaFuente;
    }
    public void setNuevaFuente(FuentesFinanciamiento nuevaFuente) {
        this.nuevaFuente = nuevaFuente;
    }

    //Métodos Get y Set para nuevoPais
    public Paises getNuevoPais() {
        return nuevoPais;
    }
    public void setNuevoPais(Paises nuevoPais) {
        this.nuevoPais = nuevoPais;
    }

    //Métodos Get y Set para nuevoTipoFacilitador
    public TiposFacilitadores getNuevoTipo() {
        return nuevoTipo;
    }
    public void setNuevoTipo(TiposFacilitadores nuevoTipo) {
        this.nuevoTipo = nuevoTipo;
    }
    
    //Métodos Get y Set para nuevaUnidadTecnica
    public UnidadesTecnicas getNuevaUnidad() {
        return nuevaUnidad;
    }
    public void setNuevaUnidad(UnidadesTecnicas nuevaUnidad) {
        this.nuevaUnidad = nuevaUnidad;
    }

    //Métodos Get y Set para nuevoRol
    public Roles getNuevoRol() {
        return nuevoRol;
    }
    public void setNuevoRol(Roles nuevoRol) {
        this.nuevoRol = nuevoRol;
    }

    //Métodos Get y Set para nuevoUsuario
    public Usuarios getNuevoUsuario() {
        return nuevoUsuario;
    }
    public void setNuevoUsuario(Usuarios nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    //Métodos Get y Set para nuevaInstitucion
    public Instituciones getNuevaInstitucion() {
        return nuevaInstitucion;
    }
    public void setNuevaInstitucion(Instituciones nuevaInstitucion) {
        this.nuevaInstitucion = nuevaInstitucion;
    }

    //Métodos Get y Set para nuevaSubsegumientos
    public SubCatseguimientos getNuevaSubseguimientos() {
        return nuevaSubseguimientos;
    }
    public void setNuevaSubseguimientos(SubCatseguimientos nuevaSubseguimientos) {
        this.nuevaSubseguimientos = nuevaSubseguimientos;
    }

    //Métodos Get y Set para nuevoRepresentante
    public Representantes getNuevoRepresentante() {
        return nuevoRepresentante;
    }
    public void setNuevoRepresentante(Representantes nuevoRepresentante) {
        this.nuevoRepresentante = nuevoRepresentante;
    }

    
    
    //Métodos Get y Set para direccionSeleccionada
    public DireccionesNacionales getDireccionSeleccionada() {
        return direccionSeleccionada;
    }
    public void setDireccionSeleccionada(DireccionesNacionales direccionSeleccionada) {
        this.direccionSeleccionada = direccionSeleccionada;
    }

     //Métodos Get y Set para faciltadorSeleccionada
    public FacilitadoresTecnicos getFacilitadorSeleccionada() {
        return facilitadorSeleccionada;
    }
    public void setFacilitadorSeleccionada(FacilitadoresTecnicos facilitadorSeleccionada) {
        this.facilitadorSeleccionada = facilitadorSeleccionada;
    }

     //Métodos Get y Set para institucionSeleccionada
    public Instituciones getInstitucionSeleccionada() {
        return institucionSeleccionada;
    }
    public void setInstitucionSeleccionada(Instituciones institucionSeleccionada) {
        this.institucionSeleccionada = institucionSeleccionada;
    }

    //Métodos Get y Set para unidadSeleccionada
    public UnidadesTecnicas getUnidadSeleccionada() {
        return unidadSeleccionada;
    }
    public void setUnidadSeleccionada(UnidadesTecnicas unidadSeleccionada) {
        this.unidadSeleccionada = unidadSeleccionada;
    }

    //Métodos Get y Set para usuarioSeleccionado
    public Usuarios getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }
    public void setUsuarioSeleccionado(Usuarios usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    //Métodos Get y Set para subseguimientosSeleccionada
    public SubCatseguimientos getSubseguimientosSeleccionada() {
        return subseguimientosSeleccionada;
    }
    public void setSubseguimientosSeleccionada(SubCatseguimientos SubseguimientosSeleccionada) {
        this.subseguimientosSeleccionada = SubseguimientosSeleccionada;
    }

    //Métodos Get y Set para representanteSeleccionado
    public Representantes getRepresentanteSeleccionado() {
        return representanteSeleccionado;
    }
    public void setRepresentanteSeleccionado(Representantes representanteSeleccionado) {
        this.representanteSeleccionado = representanteSeleccionado;
    }
    
    
    
    //Método para guardar a la entidad CategoriaSeguimientos
    public void guardarCategoria() {
        getCategoriaSeguimientosFacade().create(nuevaCategoria);
        nuevaCategoria = new CategoriaSeguimientos();
    }

    //Método para guardar a la entidad DireccionesNacionales
    public void guardarDireccion() {
        getDireccionesNacionalesFacade().create(nuevaDireccion);
        nuevaDireccion = new DireccionesNacionales();
    }
    
    //Método para guardar a la entidad Facilitadores
    public void guardarFacilitador() {
        getFacilitadoresTecnicosFacade().create(nuevoFacilitador);
        nuevoFacilitador = new FacilitadoresTecnicos();
    }
    
    //Método para guardar a la entidad FuentesFinanciamientos
    public void guardarFuente() {
        getFuentesFinanciamientoFacade().create(nuevaFuente);
        nuevaFuente = new FuentesFinanciamiento();
    }
    
    //Método para guardar a la entidad Paises
    public void guardarPais() {
        getPaisesFacade().create(nuevoPais);
        nuevoPais = new Paises();
    }
    
    //Método para guardar a la entidad TiposFacilitadores
    public void guardarTipo() {
        getTiposFacilitadoresFacade().create(nuevoTipo);
        nuevoTipo = new TiposFacilitadores();
    }
    
    //Método para guardar a la entidad UnidadesTécnicas
    public void guardarUnidad() {
        
        getUnidadesTecnicasFacade().create(nuevaUnidad);
        nuevaUnidad = new UnidadesTecnicas();
    }
    
    //Método para guardar a la entidad Roles
    public void guardarRol() {
        getRolesFacade().create(nuevoRol);
        nuevoRol = new Roles();
    }
    
    //Método para guardar a la entidad Usuarios
    public void guardarUsuario() {
        getUsuariosFacade().create(nuevoUsuario);
        nuevoUsuario = new Usuarios();
    }
    
    //Método para guardar a la entidad Usuarios
    public void guardarInstitucion() {
        getInstitucionesFacade().create(nuevaInstitucion);
        nuevaInstitucion = new Instituciones();
    }
    
    //Método para guardar a la entidad SubCatSeguimientos 
    public void guardarSubSeguimientos() {
        getSubCatseguimientosFacade().create(nuevaSubseguimientos);
        nuevaSubseguimientos = new SubCatseguimientos();
    }
    
    //Método para guardar a la entidad Representantes 
    public void guardarRepresentantes() {
        getRepresentantesFacade().create(nuevoRepresentante);
        nuevoRepresentante = new Representantes();
    }
    
}
