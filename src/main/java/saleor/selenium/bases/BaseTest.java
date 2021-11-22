package saleor.selenium.bases;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private static boolean firstRun = true;

    @BeforeAll
    public static void beforeAll() {
        if (firstRun) {
            firstRun = false;
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_win32_95");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_win64_0.19.1.exe");
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/edgedriver_15063.exe");
        }
    }
}
