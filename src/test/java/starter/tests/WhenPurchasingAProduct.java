package starter.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.actions.LoginActions;
import starter.actions.PurchaseActions;
import starter.actors.Buyer;
import starter.actors.User;
import starter.pages.CheckoutCompletePage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenPurchasingAProduct {

    @Steps
    LoginActions loginActions;
    @Steps
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
