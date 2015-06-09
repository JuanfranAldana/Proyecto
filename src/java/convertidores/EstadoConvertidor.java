package convertidores;

import dao.EstadosFacade;
import entidades.Estados;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "estadoConvertidor")
@ManagedBean
@ViewScoped
public class EstadoConvertidor implements Converter{
    
    @EJB
    private EstadosFacade estadosFacade;

    public EstadoConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Estados estado = getEstadosFacade().find(id);
                return estado;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Estados)) {
            return null;
        }
        return String.valueOf(((Estados) value).getEstadoId());
    }

    public EstadosFacade getEstadosFacade() {
        return estadosFacade;
    }
    
}
