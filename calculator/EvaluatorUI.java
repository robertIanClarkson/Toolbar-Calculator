package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
    private Font font = new Font("Monospaced", Font.BOLD, 30);
    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    private Button[] buttons = new Button[bText.length];
    private Evaluator equation = new Evaluator();
    private String command = new String();
    private String textFromField = new String();

    private static final String[] bText = {
            "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
            "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    private static boolean visible = false;

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        txField.setFont(font);
        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(bText[i]);
        }
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }
        setTitle("Calculator");
        setSize(300, 300);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(visible);
    }

    public void changeVisibility() {
        if(visible == false) {
            visible = true;
        } else {
            visible = false;
        }
        setVisible(visible);
    }

    public void actionPerformed(ActionEvent buttonClicked) {
        command = buttonClicked.getActionCommand();
        textFromField = txField.getText();
        if (command.equals("=")) {
            txField.setText(String.valueOf(equation.eval(textFromField)));
        } else if (command.equals("C")) {
            txField.setText("" + txField.getText().substring(0, txField.getText().length() - 1));
        } else if (command.equals("CE")) {
            try {
                for (int index = textFromField.length(); index >= 0; index--) {
                    if (Operator.check(Character.toString(textFromField.charAt(index - 1)))) {
                        txField.setText(textFromField.substring(0, index));
                        break;
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                txField.setText("");
            }
        } else {
            txField.setText(textFromField + command);
        }
    }
}