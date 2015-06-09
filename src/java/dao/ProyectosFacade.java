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
    
    public List<Proyectos> findByEstado() {
        return getEntityManager().createQuery("SELECT o FROM Proyectos o WHERE o.estadoId.estadoNombre LIKE '%Ingresado%'").getResultList();
    }
    
}
