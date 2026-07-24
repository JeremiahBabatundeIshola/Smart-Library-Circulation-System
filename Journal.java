package model;

public class Journal extends LibraryItem implements Borrowable {

    private boolean borrowed;

    public Journal(String id, String title, String author, int year) {
        super(id, title, author, year);
        borrowed = false;
    }

    @Override
    public void borrowItem() {
        borrowed = true;
    }

    @Override
    public void returnItem() {
        borrowed = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Journal: " + title);
    }
}