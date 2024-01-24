package com.doctor.doctor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consultings")
public class Consulting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long number;
  private String floor;
	
	public Consulting(long number, String floor) {
		this.number = number;
    this.floor = floor;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "number", nullable = false)
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

  @Column(name = "floor", nullable = false)
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Consulting [id=" + id + ", floor=" + floor + "]";
	}
}
