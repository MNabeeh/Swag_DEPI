package Features_Test;

import org.testng.annotations.DataProvider;

public class DataProviders {


    @DataProvider(name = "LoginDataProvider")

     public  Object []getData() {
        String[][] data = { {"standard_user", "secret_sauce"}};
        return data;
    }

}
