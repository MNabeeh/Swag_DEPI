package json_dataReader;

import org.testng.annotations.DataProvider;

public class UsersDataProvider {

    @DataProvider(name = "usersData")
    public static Object[][] usersData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                // Add more users if needed
        };
    }
    // Data provider for checkout tests
    @DataProvider(name = "checkoutData")
    public static Object[][] checkoutData() {
        return new Object[][] {
                {"Maha", "Ali", "12345"},
        };
    }
}
