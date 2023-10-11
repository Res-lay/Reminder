package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BirthdayReminder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NearestBirthdaySteps {
    private BirthdayReminder reminder;
    private List<String> nearestBirthdays;

    @DataTableType
    public FriendInfo transform(Map<String, String> entry) {
        return new FriendInfo(entry.get("Name"), entry.get("Birthday"));
    }

    @Given("I have a list of my friends")
    public void i_have_a_list_of_friends(List<FriendInfo> friends) {
        reminder = new BirthdayReminder();
        for (FriendInfo friend : friends) {
            reminder.addFriend(friend.name, friend.birthday);
        }
    }

    @When("I determine the nearest birthdays")
    public void i_determine_the_nearest_birthdays() {
        nearestBirthdays = reminder.getNearestBirthdays();
    }

    @Then("The list of nearest birthdays contains {String}")
    public void the_list_of_nearest_birthdays_contains(String names) {
        String[] namesArray = names.split(" and ");
        for (String name : namesArray) {
            assertTrue(nearestBirthdays.contains(name));
        }
    }

    static class FriendInfo {
        String name;
        LocalDate birthday;

        public FriendInfo(String name, String birthday) {
            this.name = name;
            this.birthday = LocalDate.parse(birthday);
        }
    }
}
