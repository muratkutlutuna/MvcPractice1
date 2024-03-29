package com.tpe.repository;

import com.tpe.domain.Course;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Course course) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(course);
        tx.commit();
        session.close();
    }

    @Override
    public List<Course> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Course> courseList = session.createQuery("FROM Course", Course.class).getResultList();
        tx.commit();
        session.close();
        return courseList;
    }

    @Override
    public Optional<Course> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.get(Course.class, id);
        Optional<Course> optCourse = Optional.ofNullable(course); //If the course is null, this will return on empty optional (instead of null)
        tx.commit();
        session.close();
        return optCourse;

    }

    @Override
    public void delete(Long id) {
        Course course = sessionFactory.getCurrentSession().getReference(Course.class,id);
        sessionFactory.getCurrentSession().remove(course);
    }


}
