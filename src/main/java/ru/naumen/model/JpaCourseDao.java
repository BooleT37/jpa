package ru.naumen.model;

import org.springframework.stereotype.Repository;
import ru.naumen.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaCourseDao implements CourseDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Course> findAll() {
		return em.createQuery("from " + Course.class.getName(), Course.class).getResultList();
	}

	@Override
	@Transactional
	public void create(Course course) {
		em.persist(course);
	}
}
