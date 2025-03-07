package com.github.hannotify.graveltrapp.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class RepositoryTest implements WithAssertions {
    protected static EntityManager em;
    private static EntityManagerFactory emf;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("gravel-trapp-h2");
        em = emf.createEntityManager();
    }

    @BeforeEach
    void beforeEach() {
        em.getTransaction().begin();
    }

    @AfterEach
    void afterEach() {
        em.getTransaction().rollback();
    }

    @AfterAll
    static void afterAll() {
        em.close();
        emf.close();
    }
}
