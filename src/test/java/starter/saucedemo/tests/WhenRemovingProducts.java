package starter.saucedemo.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import starter.saucedemo.actions.LoginActions;
import starter.saucedemo.actions.RemoveProductsFromCartActions;
import starter.saucedemo.actors.User;
import starter.saucedemo.pages.CartPage;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenRemovingProducts {

    @Steps
    LoginActions loginActions;
    RemoveProductsFromCartActions removeActions;
    CartPage cartPage;

    @Managed
    WebDriver driver;

    @BeforeEach
    public void userLoginSaucedemo(){
        loginActions.as(User.STANDARD_USER);
    }

    @Test
    @DisplayName("Remove 3 products from cart")
    public void removeProductsFromCart(){
        removeActions.removeProducts();
        Serenity.reportThat("The cart should be empty",
                ()->  assertThat(cartPage.getEmptyCart().shouldNotBePresent())
        );

    }


    /*Test para probar si elegí bien el selector para validar que carro está vacío*/
    /*@Test
    @DisplayName("Remove only 1 product ")
    public void removeOneProductFromCart(){
        removeActions.removeOneProduct();
        assertThat(cartPage.getEmptyCart().shouldNotBePresent());
    }*/
}
