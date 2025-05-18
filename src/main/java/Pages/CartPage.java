package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;


public class CartPage extends PageBase{

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getCheckoutButton() {
        return driver.findElement(By.cssSelector("a.checkout-button.button.alt.wc-forward"));
    }


    public WebElement getCartItem() {
        return driver.findElement(By.linkText("Thinking in HTML"));
    }
}
