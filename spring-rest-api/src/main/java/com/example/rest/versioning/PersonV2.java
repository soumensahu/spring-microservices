package com.example.rest.versioning;

public class PersonV2 {
	private String name;

	public PersonV2(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonV2() {
		super();
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
}
