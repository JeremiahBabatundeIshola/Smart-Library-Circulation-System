package model;

import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<LibraryItem> items;

    public LibraryDatabase() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public ArrayList<LibraryItem> getItems() {
        return items;
    }
}