package convertidores;

import dao.UnidadesTecnicasFacade;
import entidades.UnidadesTecnicas;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "uniTecConvertidor")
@ManagedBean
@ViewScoped
public class UniTecConvertidor implements Converter{
    
    @EJB
    private UnidadesTecnicasFacade unidadesTecnicasFacade;

    public UniTecConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                UnidadesTecnicas tipo = getUnidadesTecnicasFacade().find(id);
                return tipo;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de tipo válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof UnidadesTecnicas)) {
            return null;
        }
        return String.valueOf(((UnidadesTecnicas) value).getUtecId());
    }
    
    public UnidadesTecnicasFacade getUnidadesTecnicasFacade() {
        return unidadesTecnicasFacade;
    }
}
