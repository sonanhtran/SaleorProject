package saleor.selenium.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saleor.selenium.bases.BaseTest;
import saleor.selenium.pages.LoginPage;

import java.io.IOException;

public class LoginTest extends BaseTest {
    public WebDriver webDriver;

   @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void loginSuccessfully() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        String filePath = "E:\\SourceCode\\SaleorProject\\src\\datafile\\test.csv";
        String usr = loginPage.getDataByRowAndColumnValue(filePath,"username", 1);
        String pass = loginPage.getDataByRowAndColumnValue(filePath,"password", 1);

        loginPage.goToPage();
        loginPage.logIn(usr, pass);
        loginPage.verifyAfterlogInSuccess();
    }
    public void afterEach() {
        //webDriver.quit();
    }
}


