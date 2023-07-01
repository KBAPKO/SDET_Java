package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSHelper {

    @Step("Снятие фокуса с элемента")
    public static void blurElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur()", element);
    }

    @Step("Проверка наличия скролла у страницы")
    public static boolean checkPageScroll(WebDriver driver) {
        return (boolean) ((JavascriptExecutor) driver)
                .executeScript("return document.body.offsetHeight > window.innerHeight");
    }
}