package reader;

import com.google.gson.Gson;
import data1.DataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {


    public DataModel readJsonFile () throws FileNotFoundException {
        FileReader fileReader = new FileReader("ExcelDataReader/jsonData1.json");
        DataModel datamodel;
        datamodel = new Gson().fromJson(fileReader, DataModel.class);

        return datamodel;



    }
}
