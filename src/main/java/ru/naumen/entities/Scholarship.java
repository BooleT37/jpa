package ru.naumen.entities;

import javax.persistence.*;

/**
 * @author aarkaev
 * @since 19.11.2016
 */
@Entity
@Table(name = "TBL_SCHOLARSHIP")
public class Scholarship {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
    @JoinColumn(name = "student", foreignKey = @ForeignKey(name = "FK_STUDENT"))
    private Student student;

    @Column(name = "amount", nullable = false)
    private double amount;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

	public int getId() {
		return id;
	}

	@Override
    public String toString() {
        return "Scholarship{" + "student=" + student + ", amount=" + amount + '}';
    }
}
