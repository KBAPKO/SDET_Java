package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserLoginPage {

    private final WebDriver driver;

    @FindBy(css = "[type='email']")
    private WebElement userEmailField;

    @FindBy(css = "[type='password']")
    private WebElement userPasswordField;

    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@type='email']/parent::*//div[@class='inline-error']")
    private WebElement emailError;

    @FindBy(css = ".password-container .inline-error")
    private WebElement passwordError;

    @FindBy(css = ".bodyMainBold")
    private WebElement incorrectDataIcon;

    public UserLoginPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Вставили логин {email} в поле ввода email")
    public UserLoginPage insertUserEmail(final String email) {
        userEmailField.sendKeys(email);
        return this;
    }

    @Step("Вставили пароль {password} в поле ввода пароля")
    public UserLoginPage insertUserPassword(final String password) {
        userPasswordField.sendKeys(password);
        return this;
    }

    @Step("Нажали кнопку логина")
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorEmailText() {
        return emailError.getText();
    }

    public String getErrorPasswordText() {
        return passwordError.getText();
    }

    public boolean alertIconAppeared() {
        return Waiters.waitForVisibility(driver, incorrectDataIcon)
                .isDisplayed();
    }

    @Step("переместили фокус на поля ввода пароля и логина")
    public UserLoginPage clickLoginFields() {
        Waiters.waitForVisibility(driver, userEmailField)
                .click();
        Waiters.waitForVisibility(driver, userPasswordField)
                .click();
        return this;
    }

    public UserLoginPage assertEmailErrorText(final String text) {
        Assert.assertEquals(getErrorEmailText(), text);
        return this;
    }

    public UserLoginPage assertPasswordErrorText(final String text) {
        Assert.assertEquals(getErrorPasswordText(), text);
        return this;
    }
}
