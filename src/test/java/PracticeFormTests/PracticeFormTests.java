package PracticeFormTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.ENTER;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
//        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practiceFormTests() {
        open("/automation-practice-form");
//        getWebDriver().manage().window().maximize();

        $("#firstName").setValue("Petr");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Petr_Ivanov@mail.ru");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").sendKeys(CONTROL, "a");
        $("#dateOfBirthInput").press("2","0","0","2"," ","M","a","y"," ","15").sendKeys(ENTER);
        $("#subjectsInput").press("C","o","m","p").sendKeys(ENTER);
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("D:\\Sample\\Cat.jpg"));
        $("#currentAddress").setValue("India");
        $("#state").click();
        $("#state > div > div.css-1hwfws3 > div.css-1wa3eu0-placeholder").press("U","t","t","a").sendKeys(ENTER);
        $("#city").press("A","g","r","a").sendKeys(ENTER);
        $("#submit").click();
        sleep(1000000000);
    }
}
