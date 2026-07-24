package model;

import java.util.LinkedList;
import java.util.Queue;

public class ReservationQueue {

    private Queue<String> waitList;

    public ReservationQueue() {
        waitList = new LinkedList<>();
    }

    public void addToQueue(String userName) {
        waitList.add(userName);
    }

    public void showQueue() {

        System.out.println("Reservation Queue:");

        for (String user : waitList) {
            System.out.println(user);
        }
    }
}