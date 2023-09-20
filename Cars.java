package Test;

public abstract class Cars {
	private String name = "none";
	public Cars(String name) {
		this.name=name;
	}
	public Cars() {}
    abstract double price();
    abstract String color();
    
    void show() {
    	System.out.println("Nmae of car is: "+name);
    	System.out.println("Nmae of prize is: "+price());
    	System.out.println("Nmae of car is: "+color());
    }
  
}

class Maruti extends Cars{
    private double price = 0;
    private static String name="Maruti";
    private String color="none";
    public Maruti(String color,double price) {
    	super(name);
		this.color=color;
		this.price=price;
	}
    
    String name() {
    	return name;
    }
	
	double price() {
		return price;
	}

	
	String color() {
		return color;
	}
	
}

class Tata extends Cars{
    private double price = 0;
    private static String name="Tata";
    private String color="none";
    public Tata(String color,double price) {
    	super(name);
		this.color=color;
		this.price=price;
	}
	double price() {
		return price;
	}

	
	String color() {
		return color;
	}
	public String name() {
	
		return name;
	}
	
}
