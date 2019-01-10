package com.loggitor.v2.loggitor.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class App {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String type;

	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "app_defect",
    joinColumns = @JoinColumn(name = "app_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "defect_id",
    referencedColumnName = "id"))
	private Set<Defect> defects = new HashSet<Defect>();

	
	
	public App() {
		//empty constructor 
	}
	
	//constructor
	public App(String name, String type, Set<Defect> defects) {
		super();
		this.name = name;
		this.type = type;
		this.defects = defects;
	}



	//constructor
	public App(String name, String type,Defect defects) {
		super();
		this.name = name;
		this.type = type;
		this.defects.add(defects);
	}
	

	
	//constructor
	public App(String name, String type) {
		super();
		this.name = name;
		this.type = type;

	}
	
	

	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public Set<Defect> getDefects() {
		return defects;
	}





	public void setDefects(Set<Defect> defects) {
		this.defects = defects;
	}


	
	public void addDefect(int d)
	{
		defects.add(new Defect(d));
	}

	
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		if (!App.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
		
		App other = (App) obj;
		
		if(this.name.equals(other.getName()))
			return true;
		else
			return false;
	}
	
	
	
}
