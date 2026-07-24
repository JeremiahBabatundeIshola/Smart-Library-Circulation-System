package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    private JTable itemTable;
    private JTextField titleField;
    private JTextField userField;
    private JComboBox<String> typeCombo;
    private JLabel statusBar;

    public MainWindow() {

        setTitle("Smart Library Circulation & Automation System");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("View Items", createViewPanel());
        tabs.addTab("Borrow / Return", createBorrowPanel());
        tabs.addTab("Admin", createAdminPanel());
        tabs.addTab("Search & Sort", createSearchPanel());

        add(tabs, BorderLayout.CENTER);

        statusBar = new JLabel("System Ready");
        add(statusBar, BorderLayout.SOUTH);
    }

    private JPanel createViewPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"ID", "Title", "Author", "Type"};
        Object[][] data = {
                {"B001", "Java Programming", "Jeremiah Babatunde", "Book"},
                {"M001", "Technology Today", "Jeremiah Babatunde", "Magazine"},
                {"J001", "Computer Science Research", "Jeremiah Babatunde", "Journal"}
        };

        itemTable = new JTable(new DefaultTableModel(data, columns));
        panel.add(new JScrollPane(itemTable), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createBorrowPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        userField = new JTextField(20);
        titleField = new JTextField(20);

        JButton borrowButton = new JButton("Borrow");
        JButton returnButton = new JButton("Return");

        borrowButton.setToolTipText("Borrow a selected library item");
        returnButton.setToolTipText("Return a borrowed library item");

        borrowButton.addActionListener(e -> {
            if (userField.getText().isEmpty() || titleField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter user name and item title");
            } else {
                JOptionPane.showMessageDialog(this, userField.getText() + " borrowed " + titleField.getText());
                statusBar.setText("Item borrowed successfully");
            }
        });

        returnButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Item returned successfully");
            statusBar.setText("Item returned");
        });

        panel.add(new JLabel("User Name:"));
        panel.add(userField);
        panel.add(new JLabel("Item Title:"));
        panel.add(titleField);
        panel.add(borrowButton);
        panel.add(returnButton);

        return panel;
    }

    private JPanel createAdminPanel() {

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField idField = new JTextField(15);
        JTextField itemTitleField = new JTextField(15);
        JTextField authorField = new JTextField(15);

        typeCombo = new JComboBox<>(new String[]{"Book", "Magazine", "Journal"});

        JButton addButton = new JButton("Add");
        JButton undoButton = new JButton("Undo");

        addButton.setToolTipText("Add new library item");
        undoButton.setToolTipText("Undo last admin action");

        addButton.addActionListener(e -> {
            try {
                if (idField.getText().isEmpty() || itemTitleField.getText().isEmpty()) {
                    throw new Exception("ID and Title are required");
                }

                JOptionPane.showMessageDialog(this, "Item added successfully");
                statusBar.setText("New item added");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        undoButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Last admin action undone");
            statusBar.setText("Undo completed");
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Item ID:"), gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Title:"), gbc);

        gbc.gridx = 1;
        panel.add(itemTitleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Author:"), gbc);

        gbc.gridx = 1;
        panel.add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Type:"), gbc);

        gbc.gridx = 1;
        panel.add(typeCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(addButton, gbc);

        gbc.gridx = 1;
        panel.add(undoButton, gbc);

        return panel;
    }

    private JPanel createSearchPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField searchField = new JTextField(20);
        JComboBox<String> sortCombo = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort", "Merge Sort"});

        JButton searchButton = new JButton("Search");
        JButton sortButton = new JButton("Sort");

        searchButton.setToolTipText("Search item by title");
        sortButton.setToolTipText("Sort items using selected algorithm");

        searchButton.addActionListener(e -> {
            if (searchField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter search text");
            } else {
                JOptionPane.showMessageDialog(this, "Search completed for: " + searchField.getText());
                statusBar.setText("Search completed");
            }
        });

        sortButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Items sorted using " + sortCombo.getSelectedItem());
            statusBar.setText("Items sorted");
        });

        panel.add(new JLabel("Search Title:"));
        panel.add(searchField);
        panel.add(new JLabel("Choose Sorting Algorithm:"));
        panel.add(sortCombo);
        panel.add(searchButton);
        panel.add(sortButton);

        return panel;
    }
}