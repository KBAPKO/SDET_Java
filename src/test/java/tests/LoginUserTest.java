package tests;

import helpers.AllureListeners;
import helpers.PropertiesProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.UserLoginPage;

@Listeners(AllureListeners.class)
public class LoginUserTest extends BaseTest {

    private static final String INCORRECT_LOGIN = "FTC_MaxSh";

    @BeforeMethod
    private void openURL() {
        driver.get(PropertiesProvider.getProperty("w2aSiteURL"));
        driver.manage().window().maximize();
    }

    @DataProvider(name = "authorization")
    public Object[][] authorizationData() {
        return new Object[][]{{PropertiesProvider.getProperty("correctEmail"),
                PropertiesProvider.getProperty("correctPassword"), 1},
                {PropertiesProvider.getProperty("correctEmail"), "", 2},
                {"", PropertiesProvider.getProperty("correctPassword"), 3},
                {INCORRECT_LOGIN, PropertiesProvider.getProperty("correctPassword"), 4},
                {"", "", 5}};
    }

    @Epic("way2automation Site")
    @Feature("Страница авторизации")
    @Story("Проверка авторизации разных комбинаций")
    @Test(dataProvider = "authorization")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUserTest(final String email,
                              final String password, final int id) {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.insertUserEmail(email)
                .insertUserPassword(password)
                .clickLoginFields();
        switch (id) {
            case (1):
                userLoginPage.clickLoginButton();
                Assert.assertNotEquals(PropertiesProvider.getProperty("w2aSiteURL"),
                        driver.getCurrentUrl());
                break;
            case (2):
                userLoginPage.assertPasswordErrorText("This field is required");
                break;
            case (3):
                userLoginPage.assertEmailErrorText("This field is required");
                break;
            case (4):
                userLoginPage.assertEmailErrorText("Please provide a valid email address");
                break;
            case (5):
                userLoginPage.assertEmailErrorText("This field is required")
                        .assertPasswordErrorText("This field is required")
                        .clickLoginButton();
                Assert.assertTrue(userLoginPage.alertIconAppeared());
                break;
            default:
                throw new IllegalArgumentException("Неверные вводные данные");
        }
    }

}
