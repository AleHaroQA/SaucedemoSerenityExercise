package starter.actions;

import net.serenitybdd.core.steps.UIInteractions;
import starter.actors.Buyer;

public class PurchaseActions extends UIInteractions {

    public void purchase(Buyer buyer){
        find("#add-to-cart-sauce-labs-bike-light").click();
        find(".shopping_cart_link").click();
        find("[data-test='checkout']").click();
        find("#first-name").sendKeys(buyer.getFirstName());
        find("#last-name").sendKeys(buyer.getLastName());
        find("#postal-code").sendKeys(buyer.getZipCode());
        find("#continue").click();
        find("[data-test='finish']").click();

    }
}
