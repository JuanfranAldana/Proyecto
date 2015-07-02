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
import java.util.Date;
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
    private CategoriaSeguimientos categoriaSeleccionada = new CategoriaSeguimientos();
    
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
    private TiposFacilitadores tipoSeleccionado = new TiposFacilitadores();
    
    @EJB
    private FuentesFinanciamientoFacade fuentesFinanciamientoFacade;
    private FuentesFinanciamiento nuevaFuente = new FuentesFinanciamiento();
    private FuentesFinanciamiento fuenteSeleccionada = new FuentesFinanciamiento();
    
    @EJB
    private PaisesFacade paisesFacade;
    private Paises nuevoPais = new Paises();
    private Paises paisSeleccionado = new Paises();
    
    @EJB
    private ContinentesFacade continentesFacade;
    
    @EJB
    private RolesFacade rolesFacade;
    private Roles nuevoRol = new Roles();
    private Roles rolSeleccionado = new Roles();
    
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
    
    private int continente, direccion, pais, rol, unidad, categoria, tipo, institucion;
    private int inst;
    
    //Variables para concatenar duración de SubCategoría de Seguimientos
    private String unidadTamanio="", unidadTiempo="";
    
    
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
    
    //Método que devuelve lista de Representantes por Id de Instituciones
    public List<Representantes> todasRepresentantesByInst(){
        return getRepresentantesFacade().buscarRep(institucion);}
    
    
/////**********************************************************************/////
    
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
    
/////**********************************************************************/////
    
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

/////**********************************************************************/////  
    
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

    //Métodos Get y Set para categoriaSeleccionada
    public CategoriaSeguimientos getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
    public void setCategoriaSeleccionada(CategoriaSeguimientos categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    //Métodos Get y Set para paisSeleccionado
    public Paises getPaisSeleccionado() {
        return paisSeleccionado;
    }
    public void setPaisSeleccionado(Paises paisSeleccionado) {
        this.paisSeleccionado = paisSeleccionado;
    }

    //Métodos Get y Set para fuenteSeleccionado
    public FuentesFinanciamiento getFuenteSeleccionada() {
        return fuenteSeleccionada;
    }
    public void setFuenteSeleccionada(FuentesFinanciamiento fuenteSeleccionada) {
        this.fuenteSeleccionada = fuenteSeleccionada;
    }

    //Métodos Get y Set para tipoSeleccionado
    public TiposFacilitadores getTipoSeleccionado() {
        return tipoSeleccionado;
    }
    public void setTipoSeleccionado(TiposFacilitadores tipoSeleccionado) {
        this.tipoSeleccionado = tipoSeleccionado;
    }

    //Métodos Get y Set para rolSeleccionado
    public Roles getRolSeleccionado() {
        return rolSeleccionado;
    }
    public void setRolSeleccionado(Roles rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }
    
    
/////**********************************************************************/////
    
    //Métodos Get y Set para Id Direcciones Nacionales
    public int getDireccion() {
        return direccion;
    }
    public void setdireccion(int direccion) {
        this.direccion = direccion;
    }

    //Métodos Get y Set para Id Paises
    public int getPais() {
        return pais;
    }
    public void setPais(int pais) {
        this.pais = pais;
    }

    //Métodos Get y Set para Id Roles
    public int getRol() {
        return rol;
    }
    public void setRol(int rol) {
        this.rol = rol;
    }

    //Métodos Get y Set para Id Unidadades Técnica
    public int getUnidad() {
        return unidad;
    }
    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    //Métodos Get y Set para Id Categoria
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    //Métodos Get y Set para Id Continente
    public int getContinente() {
        return continente;
    }
    public void setContinente(int continente) {
        this.continente = continente;
    }

    //Métodos Get y Set para Id Tipofacilitador
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    //Métodos Get y Set para Id Instituciones
    public int getInstitucion() {
        return institucion;
    }
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

    
    public int getInst() {
        return inst;
    }
    public void setInst(int inst) {
        this.inst = inst;
    }
    
/////**********************************************************************/////    

    public String getUnidadTamanio() {
        return unidadTamanio;
    }
    public void setUnidadTamanio(String unidadTamanio) {
        this.unidadTamanio = unidadTamanio;
    }

    public String getUnidadTiempo() {
        return unidadTiempo;
    }
    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
    }

    
    
    
/////**********************************************************************/////
    
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
        nuevaUnidad.setDnacId(new DireccionesNacionales(direccion));
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
        nuevoUsuario.setRolId(new Roles(rol));
        nuevoUsuario.setUtecId(new UnidadesTecnicas(unidad));
        nuevoUsuario.setUsuarioFechaCrea(new Date());
        getUsuariosFacade().create(nuevoUsuario);
        nuevoUsuario = new Usuarios();
    }
    
    //Método para guardar a la entidad Instituciones
    public void guardarInstitucion() {
        nuevaInstitucion.setPaisId(new Paises(pais));
        getInstitucionesFacade().create(nuevaInstitucion);
        nuevaInstitucion = new Instituciones();
    }
    
    //Método para guardar a la entidad SubCatSeguimientos 
    public void guardarSubSeguimientos() {
        nuevaSubseguimientos.setCatsegId(new CategoriaSeguimientos(categoria));
        nuevaSubseguimientos.setSubcatDuracion(unidadTamanio+unidadTiempo);
        getSubCatseguimientosFacade().create(nuevaSubseguimientos);
        nuevaSubseguimientos = new SubCatseguimientos();
    }
    
    //Método para guardar a la entidad Representantes 
    public void guardarRepresentantes() {
        getRepresentantesFacade().create(nuevoRepresentante);
        nuevoRepresentante = new Representantes();
    }
    
/////**********************************************************************/////
    
    //Método para actualizar en la entidad CategoriaSeguimientos 
    public void actualizarCategoria() {
        getCategoriaSeguimientosFacade().edit(categoriaSeleccionada);
    }
    
    //Método para actualizar en la entidad DireccionesNacionales 
    public void actualizarDireccion() {
        getDireccionesNacionalesFacade().edit(direccionSeleccionada);
    }
    
    //Método para actualizar en la entidad Facilitadores 
    public void actualizarFacilitador() {
        facilitadorSeleccionada.setTipofId(new TiposFacilitadores(tipo));
        facilitadorSeleccionada.setInstId(new Instituciones(institucion));
        facilitadorSeleccionada.setUtecId(new UnidadesTecnicas(unidad));
        getFacilitadoresTecnicosFacade().edit(facilitadorSeleccionada);
    }

    //Método para guardar a la entidad Facilitadores 
    public void actualizarFuente() {
        getFuentesFinanciamientoFacade().edit(fuenteSeleccionada);
    }
    
    //Método para guardar a la entidad Paises 
    public void actualizarPais() {
        paisSeleccionado.setContiId(new Continentes(continente));
        getPaisesFacade().edit(paisSeleccionado);
    }
    
    //Método para actualizar en la entidad Instituciones 
    public void actualizarInstitucion() {
        institucionSeleccionada.setPaisId(new Paises(pais));
        getInstitucionesFacade().edit(institucionSeleccionada);
    }
    
    //Método para actualizar en la entidad Unidades Técnicas 
    public void actualizarUnidad() {
        unidadSeleccionada.setDnacId(new DireccionesNacionales(direccion));
        getUnidadesTecnicasFacade().edit(unidadSeleccionada);
    }
    
    //Método para actualizar en la entidad SubCatseguimientos 
    public void actualizarSubCatsegimientos() {
        subseguimientosSeleccionada.setCatsegId(new CategoriaSeguimientos(categoria));
        getSubCatseguimientosFacade().edit(subseguimientosSeleccionada);
    }
    
    //Método para actualizar en la entidad TiposFacilitadores 
    public void actualizarTipo() {
        getTiposFacilitadoresFacade().edit(tipoSeleccionado);
    }
    
    //Método para actualizar en la entidad Representantes 
    public void actualizarRepresentante() {
        getRepresentantesFacade().edit(representanteSeleccionado);
    }
    
    //Método para actualizar en la entidad Roles 
    public void actualizarRol() {
        getRolesFacade().edit(rolSeleccionado);
    }
    
    //Método para actualizar en la entidad Usuarios 
    public void actualizarUsuario() {
        usuarioSeleccionado.setRolId(new Roles(rol));
        usuarioSeleccionado.setUtecId(new UnidadesTecnicas(unidad));
        usuarioSeleccionado.setUsuarioFechaCrea(new Date());
        getUsuariosFacade().edit(usuarioSeleccionado);
    }

}
