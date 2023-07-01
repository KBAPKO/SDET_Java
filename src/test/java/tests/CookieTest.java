package tests;

import helpers.JSHelper;
import helpers.PropertiesProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CookieTestHeaderPage;

import java.io.File;

import static helpers.CookieHelper.readCookiesFromFile;
import static helpers.CookieHelper.writeCookieToFile;
import static helpers.JSHelper.checkPageScroll;

public class CookieTest extends BaseTest {
    @BeforeMethod
    private void openURL() {
        driver.get(PropertiesProvider.getProperty("exercisesSQlURL"));
        driver.manage().window().maximize();
    }

    @Epic("Авторизация")
    @Feature("Вход в профиль")
    @Story("Вход в профиль с использованием Cookie")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void cookieLoginTest() {
        String cookieName = "PHPSESSID";
        CookieTestHeaderPage cookieTestHeaderPage = new CookieTestHeaderPage(driver);
        if (new File("src/test/resources/" + cookieName + ".data").exists()) {
            driver.manage().addCookie(readCookiesFromFile(cookieName));
            driver.navigate().refresh();
        } else {
            cookieTestHeaderPage.enterUserLogin(PropertiesProvider
                            .getProperty("loginSQL"))
                    .enterUserPassword(PropertiesProvider
                            .getProperty("passwordSQL"))
                    .clickLoginSQLButton();
            writeCookieToFile(driver, cookieName);
        }
        Assert.assertTrue(cookieTestHeaderPage.visibilityLogoutButton());
    }

    @Test
    @Story("Проверка работы JavaScript")
    public void javaScriptTest () {
        SoftAssert softAssert = new SoftAssert();
        CookieTestHeaderPage cookieTestHeaderPage = new CookieTestHeaderPage(driver);

        cookieTestHeaderPage.getUserLoginField().click();

        Assert.assertEquals(driver.switchTo().activeElement(),
                cookieTestHeaderPage.getUserLoginField());

        JSHelper.blurElement(driver,cookieTestHeaderPage.getUserLoginField());

        softAssert.assertNotEquals(driver.switchTo().activeElement(),
                cookieTestHeaderPage.getUserLoginField());
        softAssert.assertTrue(checkPageScroll(driver));
        softAssert.assertAll();
    }
}
