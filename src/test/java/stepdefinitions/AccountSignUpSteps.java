package stepdefinitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Automations.*;

public class AccountSignUpSteps {

    Faker faker = new Faker();

    @Given("^user goes to portfolio account sign up page$")
    public void user_goes_to_portfolio_account_sign_up_page() {
        String site = System.getProperty("url");
        visit(site);
    }

    @Given("^enters personal information$")
    public void enters_personal_information() {
        // first name input
        By loc_firstname = By.cssSelector("input#firstName");
        type(loc_firstname, faker.name().firstName() );

        // last name input
        By loc_lastname = By.cssSelector("input#lastName");
        type(loc_lastname, faker.name().lastName());

        // email input
        By loc_email = By.cssSelector("input#email");
        type(loc_email, faker.internet().emailAddress() );
    }

    @Given("^secret password$")
    public void secret_password() {
        // secret password input
        String passwordText = "Password!2022";
        By loc_password = By.cssSelector("input#password");
        type(loc_password, passwordText);

        // confirm the password
        By loc_confirm_password = By.cssSelector("input#confirmPassword");
        type(loc_confirm_password, passwordText);
    }

    @Given("^accepts terms and condition$")
    public void accepts_terms_and_condition() {
        // Select accredited
        By loc_accredited = By.cssSelector("#accreditedYes");
        click(loc_accredited);

        By loc_agree = By.id("hasAgreedTos");
        click(loc_agree);
    }

    @Given("^validates the captcha$")
    public void validates_the_captcha() {
        By loc_captcha_frame = By.cssSelector("iframe[role='presentation']");
        By loc_captcha_button = By.xpath("//span[@id='recaptcha-anchor']/div[1]");
        frameClick(loc_captcha_frame, loc_captcha_button);
    }

    @When("^user clicks the Create an account button$")
    public void user_clicks_the_Create_an_account_button() {
        By loc_create_account = By.xpath("/html//span[text()='Create an account']");
        click(loc_create_account);
    }

    @Then("^user can see the crowdstree user home page$")
    public void user_can_see_the_crowdstree_user_home_page() {
        By loc_webinar_banner = By.xpath("//div[text()='Webinar!']");
        isVisible(loc_webinar_banner);
    }

}
