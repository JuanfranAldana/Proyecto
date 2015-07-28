/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Proyectos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FAMILIA ALDANA
 */
@Stateless
public class ProyectosFacade extends AbstractFacade<Proyectos> {
    @PersistenceContext(unitName = "proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }
    
    public List<Proyectos> findByEstadoAprobado(){
        return getEntityManager().createNamedQuery("Proyectos.findByEstadoAprobado").getResultList();
    }
    
    public List<Proyectos> findByEstadoIngresado(){
        return getEntityManager().createNamedQuery("Proyectos.findByEstadoIngresado").getResultList();
    }
    
    public List<Proyectos> findByInstitucionId(int inst) {
        return getEntityManager().createNamedQuery("Proyectos.findByInstitucionId").setParameter("inst", inst).getResultList();
    }
    
    
}
