package com.labsKateAlex.bean;

import com.labsKateAlex.domain.Hobby;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class HobbyBean {
    @PersistenceContext(unitName = "Hobbies")
    private EntityManager em;

    public void add(Hobby hobby) {
        em.merge(hobby);
    }

    public Hobby get(Long id){
        return em.find(Hobby.class,id);
    }

    public void update(Hobby hobby) {
        add(hobby);
    }

    public void delete(Long id){
        em.remove(get(id));
    }
    public List<Hobby> getAll(){
        TypedQuery<Hobby> namedQuery = em.createNamedQuery("Hobby.getAll",Hobby.class);
        return namedQuery.getResultList();
    }

}
