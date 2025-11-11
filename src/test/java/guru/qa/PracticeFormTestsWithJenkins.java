package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestsWithJenkins {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void positiveFillPracticeFormTest(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Something@mail.org");
        $("#genterWrapper").$(byText(("Male"))).click();
        $("#userNumber").setValue("9169284215");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Picture1.png");
        $("#currentAddress").setValue("Something address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        $("#submit").click();

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
    }

}

//
//$(".modal-dialog").should(appear);
//$("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//$(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
//text("alex@egorov.com"), text("1234567890"));
//        });