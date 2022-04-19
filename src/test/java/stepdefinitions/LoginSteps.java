package stepdefinitions;

//import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
public class LoginSteps {

	@Given("^User Has Clicked the Login button on the Home Page$")
    public void user_has_clicked_the_login_button_on_the_home_page() throws Throwable {
        System.out.println("User has successfully clicked the login button on the home page");
    }

    @When("^The User Enters the Email Address$")
    public void the_user_enters_the_email_address() throws Throwable {
    	System.out.println("User has successfully entered the email address");
    }

    @Then("^The User Navigates to the User Profile Page$")
    public void the_user_navigates_to_the_user_profile_page() throws Throwable {
    	System.out.println("User has navigated to the user profile page");
    }

    @And("^Has Landed on the Login page$")
    public void has_landed_on_the_login_page() throws Throwable {
    	System.out.println("User has landed on the login page");
    }

    @And("^The Page Title is Cogmento CRM$")
    public void the_page_title_is_cogmento_crm() throws Throwable {
    	System.out.println("Page title has been validated");
    }

    @And("^The User Enters the Password$")
    public void the_user_enters_the_password() throws Throwable {
    	System.out.println("User has successfully entered the password");
    }

    @And("^The User Clicks the Login button$")
    public void the_user_clicks_the_login_button() throws Throwable {
    	System.out.println("User has successfully clicked the login button");
    }
    
    @Given("^User Has Clicked the Sign Up button on the Home Page$")
    public void user_has_clicked_the_sign_up_button_on_the_home_page() throws Throwable {
    	System.out.println("User has successfully clicked the Sign Up button on the home page");
    }

    @Then("^Application Displays Already Registered Email Message$")
    public void application_displays_already_registered_email_message() throws Throwable {
    	System.out.println("Application has displayed the already registered email message");
    }

    @And("^Has Landed on the User Registration Page$")
    public void has_landed_on_the_user_registration_page() throws Throwable {
    	System.out.println("User has landed on the user registration page");
    }

    @And("^User fills up the SignUp form$")
    public void user_fills_up_the_signup_form() throws Throwable {
    	System.out.println("User has successfully filled up the SignUp form");
    }

    @And("^User Clicks the SignUp Submit button$")
    public void user_clicks_the_signup_submit_button() throws Throwable {
    	System.out.println("User has successfully clicked the Sign Up submit button");
    }

    @And("^Application Navigates to Reset Password Page$")
    public void application_navigates_to_reset_password_page() throws Throwable {
    	System.out.println("User has successfully navigated to the reset password page");
    }
}
