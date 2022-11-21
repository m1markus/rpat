package ch.m1m.rpat;

import ch.m1m.rpat.persistence.ConfigRow;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ConfigService {

    @Inject
    EntityManager em;

    @Transactional
    public void insert(ConfigRow row) {
        em.persist(row);
    }

    @Transactional
    public void update(ConfigRow row) {
        em.merge(row);
    }

    @Transactional
    public void delete(ConfigRow row) {
        em.remove(em.merge(row));
    }

    @Transactional
    public List<ConfigRow> selectAll() {
        TypedQuery<ConfigRow> query = em.createQuery("SELECT c FROM ConfigRow c", ConfigRow.class);
        List<ConfigRow> rows = query.getResultList();
        return rows;
    }
}
