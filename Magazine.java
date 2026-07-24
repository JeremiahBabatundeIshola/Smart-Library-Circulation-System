package model;

public class Magazine extends LibraryItem implements Borrowable {

    private boolean borrowed;

    public Magazine(String id, String title, String author, int year) {
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
        System.out.println("Magazine: " + title);
    }
}