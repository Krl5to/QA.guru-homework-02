package practiceformtests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.ENTER;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
//        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
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
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        $("#currentAddress").setValue("India");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Petr Ivanov"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("Petr_Ivanov@mail.ru"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("0123456789"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("15 May,2002"));
        $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Computer Science"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Reading, Music"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("Cat.jpg"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("India"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}
