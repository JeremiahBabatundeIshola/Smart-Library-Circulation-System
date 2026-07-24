package model;

import java.util.ArrayList;

public class UserAccount {

    private String userName;
    private ArrayList<String> borrowHistory;

    public UserAccount(String userName) {
        this.userName = userName;
        borrowHistory = new ArrayList<>();
    }

    public void borrowItem(String itemTitle) {
        borrowHistory.add(itemTitle);
    }

    public void showHistory() {

        System.out.println("Borrow History for " + userName);

        for (String item : borrowHistory) {
            System.out.println(item);
        }
    }
}