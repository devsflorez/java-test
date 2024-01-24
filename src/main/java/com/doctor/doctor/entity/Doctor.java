package com.doctor.doctor.entity;

import java.util.List;

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
@Table(name = "doctors")
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String first_name;
  private String last_name_father;
  private String last_name_mother;
  private String specialty;
	
	public Doctor(String first_name, String last_name_father, String last_name_mother, String specialty) {
		this.first_name = first_name;
    this.last_name_father = last_name_father;
    this.last_name_mother = last_name_mother;
    this.specialty = specialty;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

  @Column(name = "last_name_father", nullable = false)
	public String getLastNameFather() {
		return last_name_father;
	}

	public void setLastNameFather(String last_name_father) {
		this.last_name_father = last_name_father;
	}

  @Column(name = "last_name_mother", nullable = false)
	public String getLastNameMother() {
		return last_name_mother;
	}

	public void setlastNameMother(String last_name_mother) {
		this.last_name_mother = last_name_mother;
	}

  @Column(name = "specialty", nullable = false)
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", first_name=" + first_name + "]";
	}

  public void addAttribute(String string, List<Doctor> all) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addAttribute'");
  }
}
