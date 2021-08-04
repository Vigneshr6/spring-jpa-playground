package com.vignesh.jpa_pg.repository;

import com.vignesh.jpa_pg.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerRepositoryExtImpl implements CustomerRepositoryExt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getFirst10() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = cb.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.where(cb.lessThan(root.get("customerId"),11));
        TypedQuery<Customer> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
