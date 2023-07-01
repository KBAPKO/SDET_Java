package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import tests.BaseTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AllureListeners implements ITestListener {

    @Override
    public void onTestFailure(final ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        BufferedImage screen = new AShot().takeScreenshot(driver).getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(screen, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] attach = baos.toByteArray();
        saveScreenshot(attach);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(final byte[] screenshot) {
        return screenshot;
    }
}
