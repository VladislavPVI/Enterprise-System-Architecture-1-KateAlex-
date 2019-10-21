package com.labsKateAlex.bean;

import com.labsKateAlex.domain.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ScheduleBean {
    @PersistenceContext(unitName = "Hobbies")
    private EntityManager em;

    public void add(Schedule schedule) {
        em.merge(schedule);
    }

    public Schedule get(Long id){
        return em.find(Schedule.class,id);
    }

    public void update(Schedule schedule) {
        add(schedule);
    }

    public void delete(Long id){
        em.remove(get(id));
    }
    public List<Schedule> getAll(){
        TypedQuery<Schedule> namedQuery = em.createNamedQuery("Schedule.getAll",Schedule.class);
        return namedQuery.getResultList();
    }

}
