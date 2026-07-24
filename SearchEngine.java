package controller;

import java.util.ArrayList;
import model.LibraryItem;

public class SearchEngine {

    public LibraryItem linearSearch(ArrayList<LibraryItem> items, String title) {

        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }

        return null;
    }

    public LibraryItem recursiveSearch(ArrayList<LibraryItem> items, String title, int index) {

        if (index >= items.size()) {
            return null;
        }

        if (items.get(index).getTitle().equalsIgnoreCase(title)) {
            return items.get(index);
        }

        return recursiveSearch(items, title, index + 1);
    }
}