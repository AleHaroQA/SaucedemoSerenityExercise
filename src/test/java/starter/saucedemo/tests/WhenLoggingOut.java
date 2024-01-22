package starter.saucedemo.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.saucedemo.actions.LoginActions;
import starter.saucedemo.actions.LogoutActions;
import starter.saucedemo.actors.User;
import starter.saucedemo.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOut {

    @Steps
    LoginActions loginActions;
    LogoutActions logoutActions;
    HomePage homePage;

    @Managed
    WebDriver driver;

    @BeforeEach
    public void userLoginSaucedemo(){
        loginActions.as(User.STANDARD_USER);
    }

    @Test
    @DisplayName("Logout")
    public void userCanLogout(){
        logoutActions.logout();
        Serenity.reportThat("The home page should include the correct text",
                ()-> assertThat(homePage.getLoginLogo()).isEqualToIgnoringCase("Swag Labs")
        );

    }
}
