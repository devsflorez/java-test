package com.doctor.doctor.entity;

import java.time.LocalDateTime;

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
@Table(name = "quotes")
public class Quote {
  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @ManyToOne
  @JoinColumn(name = "consulting_id")
  private Consulting consulting;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private LocalDateTime datetime;
	
	public Quote(String name) {
		this.name = name;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

  @Column(name = "dateTime", nullable = false)
  public LocalDateTime getDateTime() {
    return datetime;
  }

  public void setDateTime(LocalDateTime datetime) {
    this.datetime = datetime;
  }

	@Override
	public String toString() {
		return "Quote [id=" + id + ", name=" + name + "]";
	}
}
