// import java.awt.MenuBar;

import javax.swing.*;

public class TextEditor {

    // frame of the text editor
    JFrame frame;
    // menu bar
    JMenuBar menuBar;
    // menu item file
    JMenu file;
    // menu items of file
    JMenuItem newFile, openFile, saveFile;
    // menu item edit
    JMenu edit;
    // menu item of edit
    JMenuItem cut, copy, paste, selectAll, close;
    // text area
    JTextArea textArea;

    TextEditor() {
        // Initialize frame
        frame = new JFrame("Text Editor");
        // Initialize menu bar
        menuBar = new JMenuBar();
        // Initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");

        // Initialize menu item of file
        newFile = new JMenuItem("New File");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");

        // adding file items in the file
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        // Initialize menu item of edit
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        // adding file items in the edit
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        // adding file and edit in the menu bar
        menuBar.add(file);
        menuBar.add(edit);

        // Initialize text area
        textArea = new JTextArea();
        // set the layout bound of text area
        textArea.setBounds(0, 0, 500, 500);

        // adding menubar to the frame
        frame.add(menuBar);
        // adding text area to the frame
        frame.add(textArea);

        frame.setJMenuBar(menuBar);
        frame.setBounds(100, 100, 400, 400);

        frame.setVisible(true);
        frame.setLayout(null);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}