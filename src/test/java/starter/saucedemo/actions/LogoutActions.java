package starter.saucedemo.actions;

import net.serenitybdd.core.steps.UIInteractions;

public class LogoutActions extends UIInteractions {

    public void logout(){
        find("#react-burger-menu-btn").click();
        find("#logout_sidebar_link").click();
    }

}
