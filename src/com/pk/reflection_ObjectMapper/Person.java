package com.pk.reflection_ObjectMapper;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {


    private Integer age;
    
    private Map<String, Object> payload;
    
    
    public Person() {
		super();
	}


	public Person(Integer age, Map<String, Object> payload) {
		super();
		this.age = age;
		this.payload = payload;
	}


	public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", payload=" + payload + "]";
	}



}
