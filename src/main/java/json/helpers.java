package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class helpers {



        public static Object[][] parseJSON(String filePath) throws IOException {
            JsonArray jsonArray = JsonParser.parseReader(new FileReader(filePath)).getAsJsonArray();
            Object[][] data = new Object[jsonArray.size()][3];

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                data[i][0] = obj.get("username").getAsString();
                data[i][1] = obj.get("password").getAsString();
                data[i][2] = obj.get("expectedResult").getAsString();
            }
            return data;


        }
    }

