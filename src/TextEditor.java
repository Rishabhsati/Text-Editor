import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
    JMenuItem newWindow, openFile, saveFile;
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
        newWindow = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");

        // adding file items in the file
        file.add(newWindow);
        file.add(openFile);
        file.add(saveFile);

        // adding action event to the menu items
        newWindow.addActionListener(this);
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
//        frame.add(textArea);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));

        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);
        frame.add(panel);
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

//        perform action for open file
        if(actionEvent.getSource()==openFile){
//            file choosing menu for slect the file and given the starting path is C: drive
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);
//            perform action if we choose any file otherwise it is null
            if(chooseOption==JFileChooser.APPROVE_OPTION){
//                select the file
                File file = fileChooser.getSelectedFile();
//                get the file path
                String filePath = file.getPath();
//                try and catch for exception handling
                try{
//                    added file reader to get the file data
                    FileReader fileReader = new FileReader(filePath);
//                    added bufferreader to read the file
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermidiate = "",output = "";
//                    here we are reading the file line by line
                    while((intermidiate = bufferedReader.readLine())!= null){
                        output += intermidiate+"\n";
                    }
//                    set the text in the text area
                    textArea.setText(output);
                }
                catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }

//        perform action for save file
        if(actionEvent.getSource()==saveFile){
//            file choosing menu for slect the file and given the starting path is C: drive
            JFileChooser fileChooser = new JFileChooser(":C");
            int chooseOption = fileChooser.showSaveDialog(null);
//            perform action if we choose any file otherwise it is null
            if(chooseOption==JFileChooser.APPROVE_OPTION){
//                adding the file path and name with extension .txt
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
//        perform action for new window
        if(actionEvent.getSource()==newWindow){
            TextEditor textEditor = new TextEditor();
        }
    }
}