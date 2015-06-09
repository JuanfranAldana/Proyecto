package convertidores;

import dao.SubCatseguimientosFacade;
import entidades.SubCatseguimientos;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "catsegConvertidor")
@ManagedBean
@ViewScoped
public class CatSegConvertidor implements Converter{
    
    @EJB
    private SubCatseguimientosFacade subCatseguimientosFacade;

    public CatSegConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                SubCatseguimientos subseg = getSubCatseguimientosFacade().find(id);
                return subseg;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof SubCatseguimientos)) {
            return null;
        }
        return String.valueOf(((SubCatseguimientos) value).getSubcatId());
    }
    
    public SubCatseguimientosFacade getSubCatseguimientosFacade() {
        return subCatseguimientosFacade;
    }
    
}
