package testJson;

import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class Test_json {
   // ReadDataFromJson readDataFromJson;

    @Test
    public void test1() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson=new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().url);

    }
    @Test
    public void test2() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson=new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().login.validCredentials.password);
        System.out.println(readDataFromJson.readJsonFile().login.validCredentials.username);

    }
    @Test
    public void test3() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson=new ReadDataFromJson();
        System.out.println();
        System.out.println();

    }
    @Test
    public void test4() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson=new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().login.invalidCredentials.invalidPassword.password);
        System.out.println();

    }

}
