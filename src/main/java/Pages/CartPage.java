package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a.checkout-button.button.alt.wc-forward")
    public WebElement checkoutBtn;

    @FindBy(linkText = "Thinking in HTML")
    public WebElement cartItem;
}
