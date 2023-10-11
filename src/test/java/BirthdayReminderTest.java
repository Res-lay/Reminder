import org.example.BirthdayReminder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BirthdayReminderTest {

    private BirthdayReminder reminder;

    @BeforeEach
    void setUp() {
        reminder = new BirthdayReminder();
    }

    @Test
    public void testAddFriend() {
        BirthdayReminder birthdayReminder = new BirthdayReminder();
        String friend = "Alice";
        LocalDate friendBirthday = LocalDate.of(1991, 10, 11);

        birthdayReminder.addFriend(friend, friendBirthday);

        assertTrue(birthdayReminder.hasFriend(friend));
    }

    @Test
    public void testGetFriendsWithTodayBirthday() {
        String friendName1 = "Alice";
        LocalDate friendBirthday1 = LocalDate.of(1990, 10, 15);
        String friendName2 = "Bob";
        LocalDate friendBirthday2 = LocalDate.now();

        reminder.addFriend(friendName1, friendBirthday1);
        reminder.addFriend(friendName2, friendBirthday2);


        List<String> friendsWithTodayBirthday = reminder.getFriendsWithTodayBirthday();

        assertEquals(1, friendsWithTodayBirthday.size());
        assertTrue(friendsWithTodayBirthday.contains(friendName2));
    }
    @Test
    public void testSendBirthdayReminder() {
        reminder.addFriend("Alice", LocalDate.of(1995,10, 12));
        reminder.addFriend("Bob", LocalDate.of(1995,9, 30));

        boolean isReminderSent = reminder.sendBirthdayReminder("Alice");

        assertTrue(isReminderSent, "Sending birthday reminder for Alice.");
    }
    @Test
    void testGetNearestBirthdays() {
        LocalDate today = LocalDate.now();
        LocalDate birthday1 = today.plusDays(3);  // Alice's birthday in 3 days
        LocalDate birthday2 = today.plusDays(5);  // Bob's birthday in 5 days

        reminder.addFriend("Alice", birthday1);
        reminder.addFriend("Bob", birthday2);

        List<String> nearestBirthdays = reminder.getNearestBirthdays();

        assertEquals(2, nearestBirthdays.size());
        assertTrue(nearestBirthdays.contains("Alice"));
        assertTrue(nearestBirthdays.contains("Bob"));
    }
}
