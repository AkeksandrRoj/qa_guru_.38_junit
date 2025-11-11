package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTestsWithJenkins {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

    }


    @Tag("homeWork")
    @Test
    void positiveFillPracticeFormTest() {
        step("Открываем страницу формы", () -> {
            open("automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Задаем имя: ", () -> {
            $("#firstName").setValue("Ivan");
        });
        step("Задаем фамилию: ", () -> {
            $("#lastName").setValue("Ivanov");
        });
        step("Задаем электронную почту: ", () -> {
            $("#userEmail").setValue("Something@mail.org");
        });
        step("Задаем пол: ", () -> {
            $("#genterWrapper").$(byText(("Male"))).click();
        });
        step("Задаем номер телефона: ", () -> {
            $("#userNumber").setValue("9169284215");
        });
        step("Задаем дату рождения: ", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("November");
            $(".react-datepicker__year-select").selectOption("2000");
            $(".react-datepicker__day--020").click();
        });
        step("Задаем предмет: ", () -> {
            $("#subjectsInput").setValue("English").pressEnter();
        });
        step("Задаем хобби: ", () -> {
            $("#hobbiesWrapper").$(byText("Reading")).click();
        });
        step("Задаем картинку: ", () -> {
            $("#uploadPicture").uploadFromClasspath("Picture1.png");
        });
        step("Задаем адрес: ", () -> {
            $("#currentAddress").setValue("Something address");
        });
        step("Задаем штат: ", () -> {
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        });
        step("Задаем город: ", () -> {
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        });
        step("Отправляем форму", () -> {
            $("#submit").click();
        });


        step("Ожидаем, что модальное окно с введенными данными открылось", () -> {
            $(".modal-dialog").should(appear);
        });
        step("Ожидаем совпадение с заданными данными", () -> {
            $(".modal-body").shouldHave(text("Ivan"));
            $(".modal-body").shouldHave(text("Ivanov"));
            $(".modal-body").shouldHave(text("Something@mail.org"));
            $(".modal-body").shouldHave(text("9169284215"));
            $(".modal-body").shouldHave(text("November"));
            $(".modal-body").shouldHave(text("2000"));
            $(".modal-body").shouldHave(text("20"));
            $(".modal-body").shouldHave(text("English"));
            $(".modal-body").shouldHave(text("Reading"));
            $(".modal-body").shouldHave(text("Picture1.png"));
            $(".modal-body").shouldHave(text("Something address"));
            $(".modal-body").shouldHave(text("Rajasthan"));
            $(".modal-body").shouldHave(text("Jaiselmer"));
        });
    }

}

