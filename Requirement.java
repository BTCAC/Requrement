import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Requirement {
	private String name;
	private String shortDescription;
	private String longDescription;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	private Date creationDate=new Date();
	private Date modifyDate=new Date();
	private String creator;
	private ArrayList <Attributes> attributesList=new ArrayList<Attributes>();
	private ArrayList <Requirement> requirementList=new ArrayList<Requirement>();
	
	
	
	public Requirement(String name,String shortDescription,String longDescription,String creationDate,String modifyDate,String creator) throws ParseException{
		this.name=name;
		this.shortDescription=shortDescription;
		this.longDescription=longDescription;
		this.creationDate = sdf.parse(creationDate);
		this.modifyDate = sdf.parse(modifyDate);
		this.creator=creator;
	}
	public String toString(){
		String date1 = sdf.format(creationDate);
		String date2 = sdf.format(modifyDate);
		if(attributesList.isEmpty())
			return "Name: "+name+"\nShort Description: "+ shortDescription+"\nLong Description: "+longDescription+"\nCreation Date: "+date1+"\nModify Date"+date2+"\nCreator"+creator;
		else
		{	
			String printAttributes="";
			for(Attributes it:attributesList){
				printAttributes="\n"+printAttributes+it;
			}
			return "Name: "+name+"\nShort Description: "+ shortDescription+"\nLong Description: "+longDescription+"\nCreation Date: "+date1+"\nModify Date"+date2+"\nCreator: "+creator+printAttributes;
		}
			
	}
	public void addAttributes(String type,String description){
		Attributes Att=new Attributes(type,description);
		boolean t=false;
		for(Attributes it:attributesList){
			if(it.equals(Att)){
				t=true;
				it.changeDescription(description);
			}
		}
		if(t==false)
		attributesList.add(Att);
	}
	public void addRequirement(Requirement r){
		requirementList.add(r);
	}
	public void setNameReq(String n){
		name=n;
	}
	public void setShortDescriptionReq(String n){
		shortDescription=n;
	}
	public void setLongDescriptionReq(String n){
		longDescription=n;
	}
	public void setCreatorReq(String n){
		creator=n;
	}
	
	
	public static void main(String[] argv){
		try {
			Requirement req1=new Requirement("Marius","ana are mere","ana are mere si pere","31-08-1982 10:20:56","31-08-1982 10:20:56","niko");
			req1.addAttributes("color", "rose");
			
			System.out.println(req1);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
