package com.algaworks.JpaProjetc.jpa;

import com.algaworks.JpaProjetc.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ClienteJpa {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cliente> listar(){
        TypedQuery<Cliente> query = entityManager.createQuery("from Cliente", Cliente.class);
        return query.getResultList();
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        return entityManager.merge(cliente);
    }

    @Transactional
    public void remover(Long id){
        Cliente cliente = buscarId(id);
        entityManager.remove(cliente);
    }

    public Cliente buscarId(Long id){
        return entityManager.find(Cliente.class, id);
    }


}
