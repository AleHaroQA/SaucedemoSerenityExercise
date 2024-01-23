package starter.pages;

import net.serenitybdd.core.pages.PageObject;

public class CheckoutCompletePage extends PageObject {

    public String getCompleteText(){

        return find(".complete-header").getText();
    }


}
