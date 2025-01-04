import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Başarılı giriş kontrolü")
    public void LoginSuccesfull() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();

        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(), "Hesabım");
    }

    @Test(description = "Başarısız giriş kontrolü")
    public void LoginUnSuccesfull() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword("Careert38..")
                .clickLogin();
        Thread.sleep(5000);
        loginPage.errorMessageController(errorLoginMessage);
    }

    @Test(description = "Maximum Minimum karakter giriş kontrolü")
    public void MaxMinCharecterControl() throws InterruptedException {
        loginPage.fillEmail("c")
                .fillPassword("Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38Careert38.")
                .clickLogin();

        loginPage.errorMessageController("Lütfen geçerli bir e-posta adresi giriniz.");

        loginPage.fillEmail(email)
                .clearPassword()
                //.fillPassword(password)
                .clickLogin()
                .errorMessageController("Lütfen şifrenizi giriniz.");

    }

}
