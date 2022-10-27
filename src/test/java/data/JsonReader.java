package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	
	public String fname,lname,day,mon,year,mail,com,pass,cpass;
	
	
	public void readerFromJson() throws FileNotFoundException, IOException, ParseException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
		File src=new File(path);
		JSONParser parser=new JSONParser();
		JSONArray array=(JSONArray) parser.parse(new FileReader(src));
		
		for (Object object : array) {
			JSONObject person=(JSONObject) object;
			fname=(String) person.get("firstname");
			System.out.println(fname);
			lname=(String) person.get("lastname");
			day=(String) person.get("day");
			mon=(String) person.get("month");
			year=(String) person.get("year");
			mail=(String) person.get("mail");
			com=(String) person.get("com");
			pass=(String) person.get("pass");
			cpass=(String) person.get("cpass");
			
		}
	}

}
