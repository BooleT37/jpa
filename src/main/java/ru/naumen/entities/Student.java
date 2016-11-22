package ru.naumen.entities;


import javax.persistence.*;


/**
 * @author aarkaev
 * @since 19.11.2016
 */

@Entity
@Table(name = "TBL_STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "firstName", length = 100, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 100, nullable = false)
    private String lastName;

	@ManyToOne
	@JoinColumn(name = "course", foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE"))
    private Course course;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Student student = (Student) o;

        return id == student.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", course=" + course + '}';
    }
}
