package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Kullanıcı bilgisi alınır")
    public String getAccountValue(){
        screenshot();
        return driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
    }
}
