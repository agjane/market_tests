package store_project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class SomeTests {
    @BeforeAll
    static void baseUrl() {
        Configuration.baseUrl = "https://larne.ru";
    }

    @Test
    void Project() {
        // Открываем магазин, закрываем нижнюю плажку, переходим в каталог
        open ("https://larne.ru");
        $(".modal_close").shouldBe(Condition.visible).click();
        open("/catalog/platya/");
        // Открываем платье с пролистыванием вниз, смотрим миниатюры платьев, выбираем таблицу размеров
        $("[href='/catalog/platya/plate-mini-s-drapirovannoy-yubkoy-i-tsvetochnym-printom/']").hover().click();
        $(".item__thumb").sibling(1).click();
        $("[class='item__info animate']").shouldBe(Condition.visible);
        $(".item__all-size").click();
        // Выбираем размер S
        $(".sizeguide__close").shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $(".item__thumb").click();
        sleep(5000);
    }
}
