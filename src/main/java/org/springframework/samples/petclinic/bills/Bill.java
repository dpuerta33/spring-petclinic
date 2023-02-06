package org.springframework.samples.petclinic.bills;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;

import java.time.LocalDate;

@Entity
@Table(name = "visit")
public class Bill extends BaseEntity {

	@Column(name = "paymentDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public Bill() {
		this.date = LocalDate.now();
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.getId())
			.append("new", this.isNew())
			.append("paymentDate", this.getDate())
			.toString();
	}

}
