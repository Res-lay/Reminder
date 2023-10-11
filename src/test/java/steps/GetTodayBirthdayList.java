package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BirthdayReminder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetTodayBirthdayList {
    private BirthdayReminder reminder;
    private List<String> friendsWithTodayBirthday;

    @DataTableType
    public FriendInfo transform(Map<String, String> entry) {
        return new FriendInfo(entry.get("Name"), entry.get("Birthday"));
    }

    @Given("I have a list of friends")
    public void i_have_a_list_of_friends(List<FriendInfo> friends) {
        reminder = new BirthdayReminder();
        for (FriendInfo friend : friends) {
            reminder.addFriend(friend.name, friend.birthday);
        }
    }

    @When("Today {String} and {String} celebrate their birthday")
    public void today_friends_celebrate_their_birthday(String name1, String name2) {
        friendsWithTodayBirthday = reminder.getFriendsWithTodayBirthday();
    }

    @Then("The friends list happy birthday today contains {String} and {String}")
    public void the_friends_list_happy_birthday_today_contains(String name1, String name2) {
        assertTrue(friendsWithTodayBirthday.contains(name1));
        assertTrue(friendsWithTodayBirthday.contains(name2));
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
