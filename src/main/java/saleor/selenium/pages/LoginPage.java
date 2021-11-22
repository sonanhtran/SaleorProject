package saleor.selenium.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saleor.selenium.bases.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver){
        super(webDriver);
        path="";
    }

    @FindBy(xpath = "//li[contains(@data-test, 'MenuLogin')]")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[contains(@data-test, 'userButton')]")
    private WebElement btnUser;

    @FindBy(xpath = "//div[@class = 'login']")
    private WebElement tabLogin;

    @FindBy(xpath = "//span[contains(., 'Email')]/preceding-sibling::input")
    private WebElement txbEmail;

    @FindBy(xpath = "//span[contains(., 'Password')]/preceding-sibling::input")
    private WebElement txbPassword;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement btnSubmit;

    //Create login function
    public void logIn(String email, String password) throws InterruptedException {
        //Click login button to open login overlay tab
        btnLogin.click();

        //Wait for login tab loading
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(tabLogin));

        //Clear email and password in text box
        txbEmail.clear();
        txbPassword.clear();

        //Enter email and password into the text box
        txbEmail.sendKeys(email);
        txbPassword.sendKeys(password);

        //Click on submit button
        btnSubmit.click();
    }

    //Verify login success
    public void verifyAfterlogInSuccess(){
        //Wait for login tab loading
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnUser));
    }
}
