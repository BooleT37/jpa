package ru.naumen.model;

import org.springframework.stereotype.Repository;
import ru.naumen.entities.Scholarship;
import ru.naumen.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Repository
public class JpaScholarshipDao implements ScholarshipDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public double findByStudentId(int studentId) {
		Student student = em.find(Student.class, studentId);
		Scholarship scholarship = em.createQuery("from " + Scholarship.class.getName() + " where student = :student", Scholarship.class)
				.setParameter("student", student)
				.getSingleResult();
		return scholarship.getAmount();
	}

	@Override
	@Transactional
	public void create(Scholarship scholarship) {
		em.persist(scholarship);
	}
}
