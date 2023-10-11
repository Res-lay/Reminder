package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirthdayReminder {
    private Map<String, LocalDate> friends = new HashMap<>();

    public void addFriend(String name, LocalDate bDate) {
        friends.put(name, bDate);
    }

    public boolean hasFriend(String name) {
        return friends.containsKey(name);
    }

    public List<String> getFriendsWithTodayBirthday() {
        LocalDate today = LocalDate.now();
        List<String> friendsWithTodayBirthday = new ArrayList<>();

        for (Map.Entry<String, LocalDate> entry : friends.entrySet()) {
            if (entry.getValue().getMonthValue() == today.getMonthValue()
                    && entry.getValue().getDayOfMonth() == today.getDayOfMonth())
                friendsWithTodayBirthday.add(entry.getKey());
        }
        return friendsWithTodayBirthday;
    }

    public boolean sendBirthdayReminder(String name) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = friends.get(name);

        if (birthday != null && today.getMonth() == birthday.getMonth() && today.getDayOfMonth() == birthday.getDayOfMonth()) {
            System.out.println("Sending birthday reminder for " + name);
            return true;
        }

        return false;
    }
    public List<String> getNearestBirthdays() {
        LocalDate today = LocalDate.now();
        List<String> nearestBirthdays = new ArrayList<>();
        int daysToConsider = 7;

        for (Map.Entry<String, LocalDate> entry : friends.entrySet()) {
            LocalDate birthday = entry.getValue();
            if (today.getMonthValue() == birthday.getMonthValue()
                    && today.getDayOfMonth() <= birthday.getDayOfMonth()) {
                int daysUntilBirthday = birthday.getDayOfMonth() - today.getDayOfMonth();
                if (daysUntilBirthday >= 0 && daysUntilBirthday <= daysToConsider) {
                    nearestBirthdays.add(entry.getKey());
                }
            } else if (today.getMonthValue() < birthday.getMonthValue()) {
                int daysUntilBirthday = (int) today.until(birthday, ChronoUnit.DAYS);
                if (daysUntilBirthday >= 0 && daysUntilBirthday <= daysToConsider) {
                    nearestBirthdays.add(entry.getKey());
                }
            }
        }

        return nearestBirthdays;
    }
}
