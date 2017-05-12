import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExportJSONServiceImpl implements ExportJSONService {
	
	public ExportJSONServiceImpl(List<Requirement> requirement,String cale)
	{
		cale=cale+"\\Requirement.json";
		try{
		FileOutputStream fos=new FileOutputStream(cale);
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		PrintWriter ow = new PrintWriter(osw);
		for(Requirement req:requirement)
		{
			JSONObject reqobject=new JSONObject();
			JSONArray atribut=new JSONArray();
			for(Attribut at:req.getAttributeList())
			{
				JSONObject atr=new JSONObject();
				atr.put("type", at.getType());
				atr.put("description", at.getDescription());
				atribut.add(atr);
			}
			reqobject.put("attributes", atribut);
			reqobject.put("creator", req.getCreatorReq());
			reqobject.put("modifyDate",req.getModifyDate());
			reqobject.put("creationDate",req.getCreationDate());
			reqobject.put("longDescription", req.getLongDescriptionReq());
			reqobject.put("shortDescription", req.getShortDescriptionReq());
			reqobject.put("name", req.getNameReq());
			ow.write(reqobject.toJSONString());
		}
		ow.close();
		}catch(IOException e)
		{
			//ignore
		}
	}
}
