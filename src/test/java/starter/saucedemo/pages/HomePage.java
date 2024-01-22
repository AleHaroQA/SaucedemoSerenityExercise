package starter.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {

    public String getLoginLogo(){
        return find(".login_logo").getText();
    }
}
