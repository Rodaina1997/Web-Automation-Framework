package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase{



    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Thinking in HTML']")
    public WebElement thinkingInHtmlBook;

    @FindBy(xpath="//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/span[2]/ins/span")
    public WebElement bookPrice;

    @FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[2]")
    public WebElement addToBasketBtn;

    @FindBy(xpath = "//*[@id=\"wpmenucartli\"]")
    public WebElement cartBtn;


}
