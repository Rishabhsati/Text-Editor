import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {

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

        // adding action event to the menu items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

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

        // adding action event to the menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        // adding file and edit in the menu bar
        menuBar.add(file);
        menuBar.add(edit);

        // Initialize text area
        textArea = new JTextArea();
        // set the layout bound of text area
        textArea.setBounds(0, 0, 400, 400);

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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//       perform action for cut
        if(actionEvent.getSource()==cut) textArea.cut();
//       perform action for copy
        if(actionEvent.getSource()==copy) textArea.copy();
//       perform action for paste
        if(actionEvent.getSource()==paste) textArea.paste();
//       perform action for selectAll
        if(actionEvent.getSource()==selectAll) textArea.selectAll();
//       perform action for close the window or file
        if(actionEvent.getSource()==close) System.exit(0);

        if(actionEvent.getSource()==openFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                try{
                    FileReader fileReader = new FileReader(filePath);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermidiate = "",output = "";
                    while((intermidiate = bufferedReader.readLine())!= null){
                        output += intermidiate+"\n";
                    }
                    textArea.setText(output);
                }
                catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }

        if(actionEvent.getSource()==saveFile){
            JFileChooser fileChooser = new JFileChooser(":C");
            int chooseOption = fileChooser.showSaveDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}