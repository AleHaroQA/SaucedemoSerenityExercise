package starter.tests;

import net.serenitybdd.annotations.Managed;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.actions.LoginActions;
import starter.actors.User;
import starter.pages.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingIn {

    @Steps
    LoginActions login;
    InventoryPage inventoryPage;
    @Managed
    WebDriver driver;

    @Test
    @DisplayName("Login")
    public void userCanLoginViaHomePage(){
        login.as(User.STANDARD_USER);
        Serenity.reportThat("The inventory page should include the correct text",
                ()-> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
        );
    }

}
