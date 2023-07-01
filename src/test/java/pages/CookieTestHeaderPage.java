package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookieTestHeaderPage {

    private final WebDriver driver;

    @FindBy(css = "[type='text'][name= 'login']")
    private WebElement userLoginField;

    @FindBy(css = "[type='password'][name= 'psw']")
    private WebElement userPasswordField;

    @FindBy(css = "[name='subm1']")
    private WebElement loginButton;

    @FindBy(css = "[href='/logout.php']")
    private WebElement logoutButton;

    public CookieTestHeaderPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Вставили имя пользователя {loginSQL} в поле ввода логина")
    public CookieTestHeaderPage enterUserLogin(final String loginUserSQL) {
        userLoginField.sendKeys(loginUserSQL);
        return this;
    }

    @Step("Вставили пароль {passwordUserSQL} в поле ввода пароля")
    public CookieTestHeaderPage enterUserPassword(final String passwordUserSQL) {
        userPasswordField.sendKeys(passwordUserSQL);
        return this;
    }

    @Step("Нажали кнопку логина")
    public CookieTestHeaderPage clickLoginSQLButton() {
        loginButton.click();
        return this;
    }

    public WebElement getUserLoginField() {
        return userLoginField;
    }


    public boolean visibilityLogoutButton() {
        return logoutButton.isDisplayed();
    }
}
