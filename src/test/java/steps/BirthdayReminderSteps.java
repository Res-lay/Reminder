package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BirthdayReminder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BirthdayReminderSteps {
    private BirthdayReminder reminder;
    private String birthdayPerson;
    private List<String> birthdayReminders;

    @DataTableType
    public FriendInfo transform(Map<String, String> entry) {
        return new FriendInfo(entry.get("Name"), entry.get("Birthday"));
    }

    @Given("I have a list of people")
    public void i_have_a_list_of_friends(List<FriendInfo> friends) {
        reminder = new BirthdayReminder();
        for (FriendInfo friend : friends) {
            reminder.addFriend(friend.name, friend.birthday);
        }
    }

    @When("Today is {String} birthday")
    public void today_is_birthday(String name) {
        birthdayPerson = name;
        birthdayReminders = reminder.getFriendsWithTodayBirthday();
    }

    @Then("I receive a birthday reminder for {String}")
    public void i_receive_a_birthday_reminder(String name) {
        assertTrue(birthdayReminders.contains(name));
        assertEquals(name, birthdayPerson);
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
