package starter.saucedemo.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import starter.saucedemo.actions.LoginActions;
import starter.saucedemo.actions.PurchaseActions;
import starter.saucedemo.actors.Buyer;
import starter.saucedemo.actors.User;
import starter.saucedemo.pages.CheckoutCompletePage;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenPurchasingAProduct {

    @Steps
    LoginActions loginActions;
    PurchaseActions purchaseActions;
    CheckoutCompletePage completePage;

    @Managed
    WebDriver driver;

    @BeforeEach
    public void userLoginSaucedemo(){
        loginActions.as(User.STANDARD_USER);
    }

    @Test
    @DisplayName("User buy a product")
    public void completeBuyflow(){
        purchaseActions.purchase(Buyer.FULL_BUYER);
        Serenity.reportThat("The checkout complete page should include the correct text",
                ()-> assertThat(completePage.getCompleteText()).isEqualToIgnoringCase("Thank you for your order!")
        );
    }
}
