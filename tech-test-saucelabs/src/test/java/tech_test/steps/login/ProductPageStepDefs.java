package tech_test.steps.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static tech_test.pages.CartPage.*;
import static tech_test.pages.ProductPage.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class ProductPageStepDefs {

    @Then("product page is displayed")
    public void productPageIsDisplayed() {

        isProductPageOpen();
    }

    @And("item {string} is added to cart")
    public void itemIsAddedToCart(String prod) {

        selectProduct(prod);
        selectAddToCart();

    }

    @And("item {string} is added to cart and Products Page reopened")
    public void itemIsAddedToCartReopen(String prod) {

        selectProduct(prod);
        selectAddToCart();
        selectBackToProducts();

    }

    @Then("cart displays {string}")
    public void cartDisplays(String amount) {

        assertTrue(cartContainer().contains(amount));

    }

    @Then("cart is emptied and nothing displayed in cart")
    public void cartIsEmptiedAndNothingDisplayedInCart() {

        selectShoppingCart();
        emptyCart();
        selectContinueShopping();
        assertFalse(cartContainerDisplayed());

    }

    @And("{string} items are added to cart")
    public void itemsAreAddedToCart(String amount) {

        selectProduct("Sauce Labs Bike Light");
        selectAddToCart();
        selectBackToProducts();
        selectProduct("Sauce Labs Backpack");
        selectAddToCart();
        selectBackToProducts();
        assertTrue(cartContainer().contains(amount));

    }

    @Then("cart displays {string} after item removed")
    public void cartDisplaysAfterItemRemoved(String amount) {

        selectShoppingCart();
        selectFirstRemoveButton();
        selectContinueShopping();
        assertTrue(cartContainer().contains(amount));

    }

    @Then("remove button is displayed")
    public void removeButtonIsDisplayed() {

        assertTrue(isRemoveButtonDisplayed());

    }
}
