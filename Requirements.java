import java.text.ParseException;
import java.util.*;

public class Requirements {
	private ArrayList <Requirement> requirementList=new ArrayList<Requirement>();
	
	public Requirement createNew(String name,String shortDescription,String longDescription,String creationDate,String modifyDate,String creator) throws ParseException{
		Requirement req=new Requirement(name,shortDescription,longDescription,creationDate,modifyDate,creator);
		requirementList.add(req);
		return req;
	}
	public void displayAll(){
		if(requirementList.isEmpty())
			System.out.println("We don't have Requirement");
		else
		{	
			for(Requirement it:requirementList)
				System.out.println(it+"\n\n");
		}
	}
	public void displaydetails(Object o){
		if(o instanceof Requirement)
			System.out.println(((Requirement)o));
	}
}
