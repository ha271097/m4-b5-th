package service;

import model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerServiceORM {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> findAll() {
        String query = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> customerTypedQuery = entityManager.createQuery(query, Customer.class);
        return customerTypedQuery.getResultList();
    }

}
