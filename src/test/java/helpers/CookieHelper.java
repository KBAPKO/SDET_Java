package helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CookieHelper {
    public static void writeCookieToFile(final WebDriver webDriver, final String cookieName) {
        File file = new File("src/test/resources/" + cookieName + ".data");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            Cookie cookie = webDriver.manage().getCookieNamed(cookieName);
            writer.write(cookie.getValue());
        } catch (IOException e) {
            System.out.println("Ошибка при записи куки - " + e.getLocalizedMessage());
        }
    }

    public static Cookie readCookiesFromFile(final String cookieName) {
        Cookie cookie = new Cookie("", "");
        try {
            File file = new File("src/test/resources/" + cookieName + ".data");
            BufferedReader br = new BufferedReader(new FileReader(file));
            cookie = new Cookie(cookieName, br.readLine());
        } catch (Exception ex) {
            System.out.println("Ошибка при чтении куки - " + ex.getLocalizedMessage());
        }
        return cookie;
    }
}
