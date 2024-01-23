package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {

    public WebElementFacade getEmptyCart(){

        return find(".shopping_cart_badge");
    }
}
