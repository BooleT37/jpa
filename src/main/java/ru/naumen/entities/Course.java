package ru.naumen.entities;

import javax.persistence.*;

/**
 * @author aarkaev
 * @since 19.11.2016
 */

@Entity
@Table(name = "TBL_COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "courseNum", nullable = false)
    private int number;
	@Column(name = "title", length = 500, nullable = false)
    private String title;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Course course = (Course) o;

		return id == course.id;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + number;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		return result;
	}

	@Override
    public String toString() {
        return "Course{" + "number=" + number + ", title='" + title + '\'' + '}';
    }
}
