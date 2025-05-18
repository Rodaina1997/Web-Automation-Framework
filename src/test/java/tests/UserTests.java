package tests;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.time.Duration;

public class UserTests extends TestBase {

    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void initializePageObjects() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }


    @Story("Finding thinking in HTML Book")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, enabled = true)
    public void UserCanFindThinkingInHTMLBookAlongWithPrice() {
        Assert.assertTrue(homePage.thinkingInHtmlBook.isDisplayed());
        Assert.assertTrue(homePage.bookPrice.isDisplayed());
    }


    @Test(priority = 2, enabled = true)
    public void UserCanAddBookToCart()  {
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePage.addToBasketBtn);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getAddToBasketBtn())).click();
    }

    @Story("Cart Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, enabled = true ,dependsOnMethods ={"UserCanAddBookToCart"})
    public void UserCanViewCart() throws InterruptedException {
      // Thread.sleep(100);
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCartButton(),"1"));
        homePage.getCartButton().click();
        //wait.until(ExpectedConditions.visibilityOf(homePage.getCartButton())).click();
    }

    @Story("Cart Items")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, enabled = true, dependsOnMethods = {"UserCanViewCart"})
    public void UserCanViewCartItems() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getCartButton()));
        Assert.assertEquals(cartPage.getCartItem().getText(),"Thinking in HTML");
    }

    @Story("Check-Out")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5, enabled = true, dependsOnMethods = {"UserCanViewCartItems"})
    public void UserCanCheckout() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(cartPage.getCheckoutButton())));
        cartPage.getCheckoutButton().click();
    }

    @Story("Billing Details Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6, enabled = true , dependsOnMethods = {"UserCanCheckout"})
    public void UserCanViewBillingDetailsForm() {
        Assert.assertTrue(checkoutPage.billingDetailsForm.isDisplayed());
        Assert.assertEquals(checkoutPage.billingDetailsTitle.getText(),"Billing Details");
    }

}
