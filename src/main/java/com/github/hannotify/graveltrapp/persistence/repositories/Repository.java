package com.github.hannotify.graveltrapp.persistence.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.SequencedCollection;

@Transactional
public abstract class Repository<E, ID> {
    @PersistenceContext(unitName = "gravel-trapp")
    private EntityManager em;
    private final Class<E> entityClass;

    public Repository() {
        this.entityClass = entityClass();
    }

    // for testing use
    Repository<E, ID> withEm(EntityManager em) {
        this.em = em;
        return this;
    }

    protected abstract Class<E> entityClass();

    public SequencedCollection<E> findAll() {
        return em.createQuery("SELECT e FROM %s e".formatted(entityClass.getSimpleName()), entityClass).getResultList();
    }

    public Optional<E> findById(ID id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }

    public void create(E entity) {
        em.persist(entity);
    }

    public E update(E entity) {
        return em.merge(entity);
    }

    public void deleteById(ID id) {
        var entity = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid %sId: %s".formatted(entityClass, id)));
        delete(entity);
    }

    public void delete(E entity) {
        em.remove(entity);
    }

    public void deleteAll() {
        var query = em.createQuery("DELETE FROM %s e".formatted(entityClass.getSimpleName()));
        query.executeUpdate();
    }
}
