/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banglapdftobangladoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Habib Rahman
 */
public class ConvertGUI extends JPanel implements ActionListener {

    static private final String newline = "\n";
    String str = "",str2="";
    JButton openButton, convButton;
    JTextArea log;
    JFileChooser fc;

    public ConvertGUI() {
        super(new BorderLayout());
        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(30, 30);
        log.setLocation(0, 0);
        log.setMargin(new Insets(125, 125, 25, 25));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("SELECT", createImageIcon("E:/CSE_600_Project/pdf_logo.JPG"));
        openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        convButton = new JButton("CONVERT", createImageIcon("E:/CSE_600_Project/doc_logo.JPG"));
        convButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(convButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Handle open button action.

        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(ConvertGUI.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                str = file.getAbsolutePath();
                str2=file.getParent();
                //This is where a real application would open the file.
                log.setFont(new Font("Times New Roman", 20, 20));
                log.setForeground(Color.darkGray);
                log.append("Selecting the PDF... " + file.getName() + "" + newline);
                
            } else {
                log.setForeground(Color.red);
                log.append("Not Selected..." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        }
        else{
            BanglaPDFtoBanglaDOC bdf = new BanglaPDFtoBanglaDOC();
            try {
                log.setForeground(Color.BLUE);
                log.append("Converting...\n");
                log.setFont(new Font("TImes New Roman",20,20));
                BanglaPDFtoBanglaDOC.Run(str,str2);
                log.append("Conversion Completed!\n");
            } catch (IOException ex) {
                log.setForeground(Color.RED);
                log.append("Conversion Failed!");
                
                //Logger.getLogger(ConvertGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ConvertGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            //log.append("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Bangla PDF to DOC Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new ConvertGUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
