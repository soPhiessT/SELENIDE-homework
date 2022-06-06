import com.codeborne.selenide.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.selector.ByAttribute;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SelenideTests {
    public SelenideTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
        Configuration.timeout = 20000;

    }

    @Test
    public void checkBox() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        open("http://the-internet.herokuapp.com/checkboxes");
        $(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        $(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).shouldBe(Condition.type("checkbox"));
        $(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).shouldBe(Condition.type("checkbox"));
    }

    @Test
    public void dropDown() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        open("http://the-internet.herokuapp.com/dropdown");
        $(By.id("dropdown")).shouldHave(Condition.text("Please select an option")).isSelected();
        $(By.id("dropdown")).selectOptionByValue("2");
        $(byAttribute("value", "2")).isSelected();
    }

    @Test
    public void textBox() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/text-box");
        SelenideElement name = $(byId("userName"));
        name.click();
        name.sendKeys("Sophie Sturua");
        $(byAttribute("placeholder", "name@example.com")).sendKeys("sophio.sturua@gmail.com");
        $(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Saguramo, street 27, home 4");
        $(".form-control", 3).sendKeys("Liakhvi street 17");

        $(By.id("submit")).click();

        $$(By.className("mb-1")).shouldHave(CollectionCondition.exactTexts
                ("Name:Sophie Sturua",
                        "Email:sophio.sturua@gmail.com",
                        "Current Address :Saguramo, street 27, home 4",
                        "Permananet Address :Liakhvi street 17"));


    }

}
