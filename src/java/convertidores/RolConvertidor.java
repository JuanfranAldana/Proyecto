package convertidores;

import dao.RolesFacade;
import entidades.Roles;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "rolConvertidor")
@ManagedBean
@ViewScoped
public class RolConvertidor implements Converter{
    
    @EJB
    private RolesFacade rolesFacade;

    public RolConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Roles rol = getRolesFacade().find(id);
                return rol;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Roles)) {
            return null;
        }
        return String.valueOf(((Roles) value).getRolId());
    }
    
    public RolesFacade getRolesFacade() {
        return rolesFacade;
    }
}
