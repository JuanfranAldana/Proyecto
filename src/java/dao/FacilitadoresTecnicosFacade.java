/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.FacilitadoresTecnicos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FAMILIA ALDANA
 */
@Stateless
public class FacilitadoresTecnicosFacade extends AbstractFacade<FacilitadoresTecnicos> {
    @PersistenceContext(unitName = "proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacilitadoresTecnicosFacade() {
        super(FacilitadoresTecnicos.class);
    }
    
    public List<FacilitadoresTecnicos> findByTipoAdministrativo(){
        return getEntityManager().createNamedQuery("FacilitadoresTecnicos.findByTipoAdministrativo").getResultList();
    }
    
    public List<FacilitadoresTecnicos> findByTipoTecnico(){
        return getEntityManager().createNamedQuery("FacilitadoresTecnicos.findByTipoTecnico").getResultList();
    }
    
    public List<FacilitadoresTecnicos> findByTipoCultural(){
        return getEntityManager().createNamedQuery("FacilitadoresTecnicos.findByTipoCultural").getResultList();
    }
    
}
