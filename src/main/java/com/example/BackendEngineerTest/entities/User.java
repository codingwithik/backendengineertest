package com.example.BackendEngineerTest.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 2)
	private String age;
	
	private String timestamp;
	
	
}
