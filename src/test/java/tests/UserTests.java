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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Story("Finding thinking in HTML Book")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, enabled = true)
    public void UserCanFindThinkingInHTMLBookAlongWithPrice() {
        Assert.assertTrue(homePage.thinkingInHtmlBook.isDisplayed());
        Assert.assertTrue(homePage.bookPrice.isDisplayed());
    }


    @Test(priority = 2, enabled = true)
    public void UserCanAddBookToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePage.addToBasketBtn);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.addToBasketBtn)).click();
        driver.switchTo().defaultContent();
    }

    @Story("Cart Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, enabled = true )
    public void UserCanViewCart() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(homePage.cartBtn))).click();
        System.out.println(homePage.cartBtn.getText());
    }

    @Story("Cart Items")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, enabled = true)
    public void UserCanViewCartItems() {
        wait.until(ExpectedConditions.visibilityOf(homePage.cartBtn));
        Assert.assertEquals(cartPage.cartItem.getText(),"Thinking in HTML");
    }

    @Story("Check-Out")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5, enabled = true)
    public void UserCanCheckout() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",cartPage.checkoutBtn);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(cartPage.checkoutBtn)));
        cartPage.checkoutBtn.click();
    }

    @Story("Billing Details Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6, enabled = true)
    public void UserCanViewBillingDetailsForm() {
        Assert.assertTrue(checkoutPage.billingDetailsForm.isDisplayed());
        Assert.assertEquals(checkoutPage.billingDetailsTitle.getText(),"Billing Details");
    }

}