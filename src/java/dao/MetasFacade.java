/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Metas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FAMILIA ALDANA
 */
@Stateless
public class MetasFacade extends AbstractFacade<Metas> {
    @PersistenceContext(unitName = "proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MetasFacade() {
        super(Metas.class);
    }
    
    public List<Metas> findMetaByProyecto(int proyec) {
        return getEntityManager().createNamedQuery("Metas.findMetaByProyecto").setParameter("proyec", proyec).getResultList();
    }
    
}
