import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

public class Viewer {

    private JTextField textField;
    private String[] buttons;
    private String[] actionCommands;
    private Controller controller;
    private Font font;

    public Viewer() {

        controller = new Controller(this);
        font = new Font("Arial", Font.PLAIN, 25);

        buttons = new String[]{"C", "del", "x" + "\u00B2", "\u00F7", "\u0025", "\u221A", "1/x", "\u00D7", "7",
                "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "=", "\u00B1", "0", "."};

        actionCommands = new String[]{"C", "Delete", "Sqr", "Divide", "Percent", "Sqrt", "OneDivideToX", "Multiple", "Seven",
                "Eight", "Nine", "Minus", "Four", "Five", "Six", "Plus", "One", "Two", "Three", "Equal", "Sign", "Zero", "Point"};

        textField = new JTextField();
        textField.setBounds(10, 10, 316, 95);
        textField.setFont(font);
        textField.setForeground(java.awt.Color.BLACK);

        JFrame jframe = new JFrame("Calculator");
        jframe.setSize(355, 520);
        jframe.setLayout(null);
        jframe.add(textField);
        jframe.setLocationRelativeTo(null);

        for (int i = 0, x = 10; i < 4; i++, x = x + 80) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, 110, 75, 55);
            button.setFont(font);
            if (i == 0) {
                button.setBackground(Color.RED);
            } else {
                button.setBackground(Color.GRAY);
            }
            button.setForeground(Color.WHITE);
            button.addActionListener(controller);
            button.setActionCommand(actionCommands[i]);
            jframe.add(button);
        }

        for (int i = 4, x = 10; i < 8; i++, x = x + 80) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, 170, 75, 55);
            button.setFont(font);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(controller);
            button.setActionCommand(actionCommands[i]);
            jframe.add(button);
        }

        for (int i = 8, x = 10; i < 12; i++, x = x + 80) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, 230, 75, 55);
            button.setFont(font);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(controller);
            button.setActionCommand(actionCommands[i]);
            jframe.add(button);
        }

        for (int i = 12, x = 10; i < 16; i++, x = x + 80) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, 290, 75, 55);
            button.setFont(font);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(controller);
            button.setActionCommand(actionCommands[i]);
            jframe.add(button);
        }

        for (int i = 16, x = 10; i < 20; i++, x = x + 80) {
            JButton button = new JButton(buttons[i]);
            if (i == 19) {
                button.setBounds(250, 350, 75, 115);
            } else {
                button.setBounds(x, 350, 75, 55);
            }
            button.setFont(font);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(controller);
            button.setActionCommand(actionCommands[i]);
            jframe.add(button);
        }

        for (int i = 20, x = 10; i < 23; i++, x = x + 80) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, 410, 75, 55);
            button.setFont(font);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(controller);
            button.setActionCommand(actionCommands[i]);
            jframe.add(button);
        }

        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    public void update(String text) {
        textField.setText(text);
    }

}

