package controller;

import java.util.ArrayList;
import model.LibraryItem;

public class SortEngine {

    public void sortByTitle(ArrayList<LibraryItem> items) {

        for (int i = 0; i < items.size() - 1; i++) {

            for (int j = 0; j < items.size() - i - 1; j++) {

                if (items.get(j).getTitle()
                        .compareToIgnoreCase(items.get(j + 1).getTitle()) > 0) {

                    LibraryItem temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }
}