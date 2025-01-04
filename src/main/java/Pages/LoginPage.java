package Pages;

import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    @Step("E-posta alanı doldurulur")
    public LoginPage fillEmail(String text){
        WebElement element = driver.findElement(By.id("login-email"));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Step("Parola alanı doldurulur")
    public LoginPage fillPassword(String text){
        driver.findElement(By.name("login-password")).sendKeys(text);
        return this;
    }

    @Step("Parola alanı temizlenir")
    public LoginPage clearPassword() throws InterruptedException {
        driver.findElement(By.cssSelector("[class='i-eye-close']")).click();
        sleep(3000);
        driver.findElement(By.name("login-password")).clear();
        screenshot();
        return this;
    }

    @Step("Login buttonuna tıklanır")
    public LoginPage clickLogin(){
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        return this;
    }

    @Step("Hata mesajı kontrolü")
    public LoginPage errorMessageController(String text){
        String message = driver.findElement(By.cssSelector("[id='error-box-wrapper'] [class='message']")).getText();
        Allure.addAttachment(message, "");
        screenshot();
        Assert.assertEquals(message, text);
        return this;
    }
}
