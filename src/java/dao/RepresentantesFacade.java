/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Representantes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FAMILIA ALDANA
 */
@Stateless
public class RepresentantesFacade extends AbstractFacade<Representantes> {
    @PersistenceContext(unitName = "proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepresentantesFacade() {
        super(Representantes.class);
    }
    
    public List<Representantes> findRepresentanteByInstitucion(int inst) {
        return getEntityManager().createNamedQuery("Representantes.findByInstitucion").setParameter("inst", inst).getResultList();
    }
    
    public List<Representantes> findContactoByInstitucion(int inst) {
        return getEntityManager().createNamedQuery("Representantes.findContactosByInstitucion").setParameter("inst", inst).getResultList();
    }
    
}
