package com.pk.reflection_ObjectMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeExample {
	
	
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
    	
    	String jsonString = "{\"name\":\"John\",\"city\":\"pune\", \"age\":30}";
        HashMap<String, Object> mapObj = new ObjectMapper().readValue(jsonString, HashMap.class);

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        Person person = mapper.convertValue(mapObj, Person.class);        
        System.out.println(person);
                
        Field[] classFields = person.getClass().getDeclaredFields();
        ArrayList<String> list = new ArrayList<String>();
        for( Field name: classFields) {
        	System.out.print(name.getName()+",");
        	list.add(name.getName());
        }
        Map<String, Object> payload;
        payload = mapObj.entrySet().stream()
        				.filter(k -> !list.contains(k.getKey()))
        				.collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue() ));
        person.setPayload(payload);
        System.out.println("person="+person);
        
    }
    
}
