import gui.MainWindow;
import utils.FileHandler;

public class App {

    public static void main(String[] args) {

        MainWindow window = new MainWindow();
        window.setVisible(true);

        FileHandler fileHandler = new FileHandler();

        fileHandler.saveData("B001, Java Programming, Jeremiah Babatunde, Book");

        System.out.println(fileHandler.loadData());
    }
}