package store_project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SomeTests {
    @BeforeAll
    static void baseUrl() {
        Configuration.baseUrl = "https://larne.ru";
    }

    @Test
    void Project() {
        // Открываем магазин, закрываем нижнюю плажку, переходим в каталог
        open ("https://larne.ru");
        $x("//span[@class='modal_close']").shouldBe(Condition.visible).click();
        open("/catalog/platya/");
        // Открываем платье с пролистыванием вниз, смотрим миниатюры платьев, выбираем таблицу размеров
        $x("(//a[@class='catalog-item__img-wrap'])[10]").hover().click();
        $x("(//button[@class='item__thumb-btn'])[3]").click();
        $x("//div[@class='item__info animate']").shouldBe(Condition.visible);
        $x("(//button[@class='accordion__btn'])[3]").click();
        sleep(2000);
        $x("(//button[@class='accordion__btn'])[4]").click();
        sleep(2000);
        $x("(//button[@class='accordion__btn'])[1]").click();
        sleep(2000);
        $x("//button[@class='item__all-size']").click();
        $x("(//div[@class='table__col'])[19]").scrollTo();
        // Выбираем размер S
        $x("//button[@class='sizeguide__close']").click();
        $x("(//div[@class='product-item-scu-item-text item__size item__size__js'])[2]").click();
        sleep(5000);
    }
}
