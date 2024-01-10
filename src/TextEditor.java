// import java.awt.MenuBar;

import javax.swing.*;
public class TextEditor{

    JFrame frame;
    JMenuBar mb;
    JMenu file,edit;
    JMenuItem newWindow,open,save,cut,copy,paste,selectAll,close;
    JTextArea ta;

    TextEditor(){
        frame = new JFrame("Text Editor");
        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");

        newWindow = new JMenuItem("New Window");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");

        file.add(newWindow);
        file.add(open);
        file.add(save);

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        mb.add(file);
        mb.add(edit);


        ta = new JTextArea();
        ta.setBounds(3,3,500,500);
        frame.add(mb);
        frame.add(ta);
        frame.setJMenuBar(mb);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500,500);
    }

    
    public static void main(String[] args) {
        new TextEditor();
    }
}