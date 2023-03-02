package com.leaning.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private Long id;
	private String name;
	private String age;
	private int height;

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}


	// setter、getter方法我就不写了
}