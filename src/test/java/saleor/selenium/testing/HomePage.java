package saleor.selenium.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import saleor.selenium.bases.BaseTest;

import java.io.IOException;

public class HomePage extends LoginTest {

    @BeforeEach
    public void beforeEach() {
        webDriver = new ChromeDriver();
    }

    @FindBy(xpath ="//li[contains(@class, 'cart')]//span[contains(@class, 'cart__quantity')]")
    private WebElement icn_quantity;

    @Test
    public void getQuantityOnCart() throws IOException, InterruptedException {
        LoginTest loginTest = new LoginTest();
        loginTest.loginSuccessfully();
        icn_quantity.getText();
        System.out.println(icn_quantity.getText());
    }
}
