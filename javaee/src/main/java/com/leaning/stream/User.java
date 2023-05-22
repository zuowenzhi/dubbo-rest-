package com.leaning.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private Long id;
	private String name;
	private int age;
	private int height;

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public User(String name,int age, int height) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
}