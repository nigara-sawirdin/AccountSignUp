package stepdefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import static utils.DriverUtil.*;
import static utils.Automations.init;


public class Hooks {

    @Before
    public static void beforeScenario(){
        openBrowser();
        init(getDriver());
    }

    @After
    public static void afterScenario(){
        closeBrowser();
    }
}
