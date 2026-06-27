package org.example.service;

import org.example.Group;
import org.example.TransactionHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final SessionFactory sessionFactory;

    private final TransactionHelper transactionHelper;

    public GroupService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Group saveGroup(String name, Long graduationYear) {
        return transactionHelper.executeInTransaction(session -> {
            Group group = new Group(name, graduationYear);
            session.persist(group);
            return group;
        });
    }

    public List<Group> findAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT g from Group g", Group.class)
                    .list();
        }
    }
}
