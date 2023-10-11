package steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BirthdayReminder;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddFriendSteps {
    private BirthdayReminder reminder;
    private String addedFriendName;

    @ParameterType("\\d{4}-\\d{2}-\\d{2}")
    public LocalDate localDate(String value) {
        return LocalDate.parse(value);
    }
    @ParameterType(".*")
    public String String(String value) {
        return value;
    }

    @Given("I have an empty friend list")
    public void i_have_an_empty_friend_list(){
        reminder = new BirthdayReminder();
    }

    @When("I add a friend with name {string} and the date of birth {localDate}")
    public void i_add_a_friend_with_name_and_the_date_of_birth(String name, LocalDate birthday){
        reminder.addFriend(name, birthday);
        addedFriendName = name;
    }

    @Then("There is {String} in friends list")
    public void there_is_in_friends_list(String name){
        System.out.println(name);
        assertEquals(name, addedFriendName);
    }
}
