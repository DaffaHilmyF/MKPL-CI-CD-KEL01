import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.untitlednankatsu.model.Book;

import java.util.Collections;

public class BookTest {
    private Book bookInstance;
    @Given("I create an Book instance")
    public void iCreateAnBookInstance() {
        bookInstance = new Book();
    }

    @When("I input {string}, {string}, and {string}")
    public void iInputAnd(String arg0, String arg1, String arg2) throws Exception {
        bookInstance = new Book(arg0, arg1, arg2);
    }

    @Then("I see the book information is equal to {string}, {string}, and {string}")
    public void iSeeTheBookInformationIsEqualToAnd(String arg0, String arg1, String arg2) {
        Assert.assertEquals("Title is not equal", bookInstance.getTitle(), arg0);
        Assert.assertEquals("Description is not equal", bookInstance.getDescription(), arg1);
        Assert.assertEquals("Author is not equal", bookInstance.getAuthor(), Collections.singletonList(arg2));
    }

    @When("I input {string}, {string}, and {string}, I see incorrect title error {string}")
    public void iInputAndISeeIncorrectTitleError(String arg0, String arg1, String arg2, String arg3) {
        var actualException = Assert.assertThrows(Exception.class, ()->{
            bookInstance = new Book(arg0, arg1, arg2);
        });

        Assert.assertEquals(arg3, actualException.getMessage());
    }

    @When("I input {string}, {string}, and {string}, I see the incorrect description error {string}")
    public void iInputAndISeeTheIncorrectDescriptionError(String arg0, String arg1, String arg2, String arg3) {
        var actualException = Assert.assertThrows(Exception.class, ()->{
            bookInstance = new Book(arg0, arg1, arg2);
        });

        Assert.assertEquals(arg3, actualException.getMessage());
    }

    @When("I input {string}, {string}, and {string}, I see the incorrect authors error {string}")
    public void iInputAndISeeTheIncorrectAuthorsError(String arg0, String arg1, String arg2, String arg3) {
        var actualException = Assert.assertThrows(Exception.class, ()->{
            bookInstance = new Book(arg0, arg1, arg2);
        });

        Assert.assertEquals(arg3, actualException.getMessage());

    }
}
