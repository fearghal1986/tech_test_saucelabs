package tech_test.steps.login;

import tech_test.pages.CheckoutCompletePage;
import io.cucumber.java.en.Then;

import static tech_test.pages.CheckoutOverviewPage.*;
import static org.junit.Assert.assertTrue;




public class CheckoutOverviewStepDefs {

    @Then("user selects finish and the sale is completed")
    public void userSelectsFinishAndTheSaleIsCompleted() {
        selectFinishButton();
        assertTrue(CheckoutCompletePage.isCheckoutOverviewPageOpen());

    }
}
