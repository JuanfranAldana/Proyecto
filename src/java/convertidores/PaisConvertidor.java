package convertidores;

import dao.PaisesFacade;
import entidades.Paises;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "paisConvertidor")
@ManagedBean
@ViewScoped
public class PaisConvertidor implements Converter{
    
    @EJB
    private PaisesFacade paisesFacade;

    public PaisConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Paises pais = getPaisesFacade().find(id);
                return pais;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Paises)) {
            return null;
        }
        return String.valueOf(((Paises) value).getPaisId());
    }

    public PaisesFacade getPaisesFacade() {
        return paisesFacade;
    }
    
}
