import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {
    JFrame converterFrame;
    JPanel checkingPanel;
    JTextField firstInputField;
    JLabel resultLabel;

    JTextField secondInputField;
    JButton getResult;

    public Main() {
        //Create and set up the window.
        converterFrame = new JFrame("Comparing strings");
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //   converterFrame.setSize(new Dimension(300, 300));
        converterFrame.setMinimumSize(new Dimension(400,100));
        //Create and set up the panel.
        checkingPanel = new JPanel(new GridLayout(2, 2));

        //Add the widgets.
        addWidgets();

        //Set the default button.
        converterFrame.getRootPane().setDefaultButton(getResult);

        //Add the panel to the window.
        converterFrame.getContentPane().add(checkingPanel, BorderLayout.CENTER);

        //Display the window.
        converterFrame.pack();
        converterFrame.setVisible(true);
    }

    /**
     * Create and add the widgets.
     */
    private void addWidgets() {
        //Create widgets.
        firstInputField = new JTextField(2);
        secondInputField = new JTextField(2);
        getResult = new JButton("Check");
        resultLabel = new JLabel("Enter two strings", SwingConstants.LEFT);

        //Listen to events from the Convert button.
        getResult.addActionListener(this);

        //Add the widgets to the container.
        checkingPanel.add(firstInputField);
        checkingPanel.add(secondInputField);
        checkingPanel.add(getResult);
        checkingPanel.add(resultLabel);

      //  celsiusLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
   //   fahrenheitLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void actionPerformed(ActionEvent event) {
        String one = firstInputField.getText();
        String two = secondInputField.getText();
        boolean result = true;

        if(one.length()!= two.length())
        {
            result = false;
            resultLabel.setText("Check length");
        }
        for(int i = 0; i < one.length() && i <two.length(); i++)
      {
          CompareSymbols cmp = new CompareSymbols(one.charAt(i), two.charAt(i));
          new Thread(cmp).start();
         if( cmp.returnResult() == false)
         {
             result = false;
             resultLabel.setText("Trouble in " + i + " position" + one.charAt(i) +"!=" + two.charAt(i));
         }
      }
        if(result == true)
          resultLabel.setText(" Equal");

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        new Main();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
                createAndShowGUI();
            }
        });

        //(new Thread((Runnable) new Main())).start();

    }
}