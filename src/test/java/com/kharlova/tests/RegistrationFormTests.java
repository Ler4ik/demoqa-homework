package com.kharlova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        String firstName = "Valeriya";
        String lastName = "Kharlova";
        String userEmail = "valvalsan@gmail.com";
        String gender = "Female";
        String userNumber = "9538023112";
        String year = "1988";
        String month = "December";
        String day = "31";
        String subjects = "Maths";
        String hobbies = "Reading";
        String address = "Mirgorodskay street";
        String state = "NCR";
        String city = "Noida";


        open("/automation-practice-form");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).shouldHave(text(firstName + " " + lastName ));
        $(".table-responsive").$(byText("Student Email")).shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).shouldHave(text("1.png"));
        $(".table-responsive").$(byText("Address")).shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).shouldHave(text(state + " " + city));

    }



}
