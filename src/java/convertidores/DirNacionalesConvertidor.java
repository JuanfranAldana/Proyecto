package convertidores;

import dao.DireccionesNacionalesFacade;
import entidades.DireccionesNacionales;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "dirnacionalConvertidor")
@ManagedBean
@ViewScoped
public class DirNacionalesConvertidor implements Converter{
    
    @EJB
    private DireccionesNacionalesFacade direccionesNacionalesFacade;
    
    public DirNacionalesConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                DireccionesNacionales direc = getDireccionesNacionalesFacade().find(id);
                System.out.println(direc);
                return direc;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof DireccionesNacionales)) {
            return null;
        }
        return String.valueOf(((DireccionesNacionales) value).getDnacId());
    }
    
    public DireccionesNacionalesFacade getDireccionesNacionalesFacade() {
        return direccionesNacionalesFacade;
    }
    
}
