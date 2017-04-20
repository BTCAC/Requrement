
public class Attributes {
	private String type;
	private String description;
	public Attributes(String type,String description){
		this.type=type;
		this.description=description;
	}
	public boolean equals(Object o){
		if(o instanceof Attributes && this.type==((Attributes)o).type)
		return true;
		else 
		return false;
	}
	public String toString(){
		return type+": "+description;
	}
	public void changeDescription(String description){
		this.description=description;
	}
	public String getType(){
		return type;
	}
	
}
