package com.example.rest.versioning;

public class PersonV1 {
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

	public PersonV1(Name name) {
		super();
		this.name = name;
	}

	public PersonV1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
