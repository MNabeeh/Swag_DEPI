package json_dataReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonDataReader {

	public List<String[]> JsonReader() throws IOException, ParseException {
		String filePath = System.getProperty("user.dir") + "/src/test/java/JsonDataReader/UserData.json";
		File srcFile = new File(filePath);

		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));


		List<String[]> usersList = new ArrayList<>();

		for (Object jsonObj : jArray) {
			JSONObject person = (JSONObject) jsonObj;
			String username = (String) person.get("username");
			String password = (String) person.get("password");


			usersList.add(new String[]{username, password});
		}

		return usersList;
	}
}
