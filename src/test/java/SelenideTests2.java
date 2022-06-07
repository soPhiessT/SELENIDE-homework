import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.AssertionMode.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


@Listeners({ SoftAsserts.class})
public class SelenideTests2 {
    public SelenideTests2 () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
        Configuration.timeout = 2000;
        Configuration.assertionMode = SOFT;

    }

    @Test
    public void FirstTest(){
        SoftAssert softAssert = new SoftAssert();
        open("/books");
        ElementsCollection books = $(".rt-table")
                .find(".rt-tbody")
                .findAll(By.className("rt-tr-group"));
        books.filterBy(matchText("O'Reilly Media"))
                .filterBy(matchText("JavaScript"))
                .shouldBe(CollectionCondition.size(10))
                .get(0)
                .shouldHave(matchText("Learning JavaScript Design Patterns"));
        books.filterBy(matchText("O'Reilly Media"))
                .filterBy(matchText("JavaScript")).stream()

                .forEach(el->{el.find(".mr-2").scrollTo().click(); back();});
        softAssert.assertAll();
    }
    @Test
    public void SecondTest(){
        SoftAssert softAssert = new SoftAssert();
        open("/books");
        ElementsCollection books = $(".rt-table")
                .find(".rt-tbody")
                .findAll(By.className("rt-tr-group"));
        books.stream().forEach(el->
            el.find(By.tagName("img")).shouldHave(Condition.matchText("/images/bookimage")));
        softAssert.assertAll();
        }
    }