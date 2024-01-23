package starter.actions;

import net.serenitybdd.core.steps.UIInteractions;

public class RemoveProductsFromCartActions extends UIInteractions {

    public void removeProducts(){
        find("#add-to-cart-sauce-labs-bike-light").click();
        find("#add-to-cart-sauce-labs-backpack").click();
        find("#add-to-cart-sauce-labs-fleece-jacket").click();
        find(".shopping_cart_link").click();
        find("#remove-sauce-labs-backpack").click();
        find("#remove-sauce-labs-bike-light").click();
        find("#remove-sauce-labs-fleece-jacket").click();
    }

    public void removeOneProduct(){
        find("#add-to-cart-sauce-labs-bike-light").click();
        find("#add-to-cart-sauce-labs-backpack").click();
        find("#add-to-cart-sauce-labs-fleece-jacket").click();
        find(".shopping_cart_link").click();
        find("#remove-sauce-labs-backpack").click();
    }
}
