package convertidores;

import dao.RepresentantesFacade;
import entidades.Representantes;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean
@ViewScoped
public class RepresentanteConvertidor implements Converter{
    
    @EJB
    private RepresentantesFacade representantesFacade;

    public RepresentanteConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Representantes repre = getRepresentantesFacade().find(id);
                return repre;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Representantes)) {
            return null;
        }
        return String.valueOf(((Representantes) value).getRepId());
    }

    public RepresentantesFacade getRepresentantesFacade() {
        return representantesFacade;
    }
    
}
