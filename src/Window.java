import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame{
    private JTextArea textIn;
    private JPanel panel1;
    private JLabel wordsOut;

    public Window() {
        textIn.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("1");
                updateCounter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("2");
                updateCounter();
            }

            public void changedUpdate(DocumentEvent e) {
                System.out.println("3");
                updateCounter();
            }
        });
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textIn.setWrapStyleWord(true);
        setTitle("Word counter");
    }
    void updateCounter(){
        int count = countWords(textIn.getText()).size();

        wordsOut.setText(count+((count==1)?" word":" words"));
    }
    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
        w.pack();
        w.setSize(600,600);
    }

    ArrayList<String> countWords(String str){
        ArrayList<String> words = new ArrayList<>();
        str=str.replaceAll("\n"," ");
        while(str.contains("  ")) {
            str = str.replaceAll("  ", " ");
        }
        while(str.contains(" ")){
            String word=str.substring(0,str.indexOf(' '));
            str = str.substring(str.indexOf(' ') + 1);
            words.add(word);
        }
        if (!str.equals(' ')&&!str.equals(""))
            words.add(str);
        return words;
    }
}
