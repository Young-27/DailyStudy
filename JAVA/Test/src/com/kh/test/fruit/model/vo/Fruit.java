package com.kh.test.fruit.model.vo;


public class Fruit {
	
	private String name;
	private String flavor;
	
	public Fruit() {}

	public Fruit(String name, String flavor) {
		this.name = name;
		this.flavor = flavor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", flavor=" + flavor + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Fruit other = (Fruit)obj;
		
		if(this.name.contentEquals(other.name) && this.flavor.equals(other.flavor)){
			return true;
		}else {
			return false;
		}
		
	}
	
	
			
	

}
