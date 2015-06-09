package convertidores;

import dao.InstitucionesFacade;
import entidades.Instituciones;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "intitucionConvertidor")
@ManagedBean
@ViewScoped
public class InstitucionConvertidor implements Converter{
    
    @EJB
    private InstitucionesFacade institucionesFacade;
    
    public InstitucionConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Instituciones tipo = getInstitucionesFacade().find(id);
                return tipo;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Instituciones)) {
            return null;
        }
        return String.valueOf(((Instituciones) value).getInstId());
    }
    
    public InstitucionesFacade getInstitucionesFacade() {
        return institucionesFacade;
    }
    
}
