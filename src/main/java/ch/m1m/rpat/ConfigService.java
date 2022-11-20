package ch.m1m.rpat;

import ch.m1m.rpat.persistence.ConfigRow;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ConfigService {

    @Inject
    EntityManager em;

    public void insert(ConfigRow row) {
        em.persist(row);
    }

    public List<ConfigRow> getAll() {
        List<ConfigRow> rows = new ArrayList<>();
        return rows;
    }
}
