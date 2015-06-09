package convertidores;

import dao.ContinentesFacade;
import entidades.Continentes;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "continenteConvertidor")
@ManagedBean
@ViewScoped
public class ContinenteConvertidor implements Converter{
    
    @EJB
    private ContinentesFacade continentesFacade;
    
    public ContinenteConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Continentes conti = getContinentesFacade().find(id);
                return conti;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Continentes)) {
            return null;
        }
        return String.valueOf(((Continentes) value).getContiId());
    }
    
    public ContinentesFacade getContinentesFacade() {
        return continentesFacade;
    }
    
}
