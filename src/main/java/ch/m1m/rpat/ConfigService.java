package ch.m1m.rpat;

import ch.m1m.rpat.persistence.ConfigRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ConfigService {

    private static Logger LOG = LoggerFactory.getLogger(ConfigService.class);

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

    @Transactional
    public List<ConfigRow> getAllForApplication(String application, LocalDateTime tsDataFor) {
        LOG.info("Called service with: ..., tsDataFor={}", tsDataFor);
        TypedQuery<ConfigRow> query = em.createQuery("SELECT c FROM ConfigRow c WHERE application = ?1 AND validFrom <= ?2 AND validUntil >= ?2", ConfigRow.class);
        query.setParameter(1, application);
        query.setParameter(2, tsDataFor);
        List<ConfigRow> rows = query.getResultList();
        return rows;
    }
}
