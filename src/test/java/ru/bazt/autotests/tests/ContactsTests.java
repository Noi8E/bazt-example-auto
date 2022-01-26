package ru.bazt.autotests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bazt.autotests.pages.Contacts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Feature("ContactsTests")
public class ContactsTests extends TestBase {

    @Test
    @Description("Образец теста без PageObject")
    @DisplayName("Страница с контактами работает")
    void contactsTestsWOPageObject() {
        step("Open main page", () -> open(""));
        step("На странице отображается шапка", () -> {
            $(".header_auto").shouldBe(visible);
        });
        step("Кликнуть на кнопку с контактами", () -> {
            $(".navigation").shouldBe(visible);
            $("a[href='contacts']").click();
        });
        step("На странце контактов отображается корректный номер телефона", () -> {
            $x("//div[@class='content']/div[@class='telephone']").shouldHave(text("+7 (495) 646 11 75"));
        });
    }

    @Test
    @Description("Образец теста с применением PageObject")
    @DisplayName("Страница с контактами работает")
    void contactsTestWithPageObject() {
        Contacts contacts = new Contacts();
        contacts
                .openMainPage()
                .headerIsVisible()
                .clickToContactsButton()
                .isPhoneNumberVisible();
    }

}
