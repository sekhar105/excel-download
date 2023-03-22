package com.excel.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "studentmarks_good")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cls;
//	 @ElementCollection
//	    @MapKeyColumn(name="name")
//	    @Column(name="value")
//	    @CollectionTable(name="example_attributes", joinColumns=@JoinColumn(name="example_id"))
//	    Map<String, String> attributes = new HashMap<String, String>(); // maps from attribute name to value
	
}
