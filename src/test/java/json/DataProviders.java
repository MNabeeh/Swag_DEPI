package json;

import org.testng.annotations.DataProvider;

public class DataProviders {


    @DataProvider(name = "LoginDataProvider")

     public  Object [][] getData() {
        Object [][] data = { {"standard_user", "secret_sauce"}};
        return data;
    }

}
