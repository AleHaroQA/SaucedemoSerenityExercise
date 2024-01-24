package starter.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.actions.LoginActions;
import starter.actions.RemoveProductsFromCartActions;
import starter.actors.User;
import starter.pages.CartPage;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenRemovingProducts {

    @Steps
    LoginActions loginActions;
    @Steps
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
                ()->  assertThat(cartPage.getEmptyCart().isPresent()).isFalse()
       );
    }


    /*Test para probar si elegí bien el selector para validar que carro está vacío*/
    //Debe ser "fail"
    @Test
    @Disabled
    @DisplayName("Remove only 1 product ")
    public void removeOneProductFromCart(){
        removeActions.removeOneProduct();
        assertThat(cartPage.getEmptyCart().isPresent()).isFalse();
    }
}
