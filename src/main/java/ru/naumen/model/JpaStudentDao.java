package ru.naumen.model;

import org.springframework.stereotype.Repository;
import ru.naumen.entities.Course;
import ru.naumen.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaStudentDao implements StudentDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Student> findAll() {
		return em.createQuery("from " + Student.class.getName(), Student.class).getResultList();
	}

	@Override
	public List<Student> listCourseStudents(Course course) {
		return em.createQuery("from " + Student.class.getName() +  " where course = :course", Student.class).setParameter("courseId", course).getResultList();
	}

	@Override
	@Transactional
	public void create(Student student) {
		em.persist(student);
	}

	@Override
	public Optional<Student> find(int id) {
		return Optional.ofNullable(em.find(Student.class, id));
	}

	@Override
	@Transactional
	public void delete(Student student) {
		em.remove(student);
	}
}
