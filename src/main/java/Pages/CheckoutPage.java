package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"customer_details\"]/div[1]/div")
    public WebElement billingDetailsForm;

    @FindBy(xpath = "//*[@id=\"customer_details\"]/div[1]/div/h3")
    public WebElement billingDetailsTitle;
}
