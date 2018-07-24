
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private final TextField txField = new TextField();
    private final Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] BTEXT = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "E"
    };
    private final Button[] buttons = new Button[BTEXT.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(BTEXT[i]);
        }

        //add buttons to button panel
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(450, 450);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // button clicked
        char button = arg0.getActionCommand().charAt(0);
        // determines appropriate command
        switch (button) {
            // clears everything
            case 'E':
                this.txField.setText("");
                break;
            // backspace
            case 'C':
                String str = this.txField.getText();
                if (str.length() > 0) {
                    this.txField.setText(str.substring(0, str.length()-1));
                }
                break;
            // executes eval expression
            // returns result to txField
            case '=':
                Evaluator instance = new Evaluator();
                String expr = this.txField.getText();
                int result = instance.eval(expr);
                expr = Integer.toString(result);
                this.txField.setText(expr);
                break;
            // buttons 0-9,+,-,*,/,^,(,)
            // are valid operators/ operands
            // so they get added to txField
            default:
                this.txField.setText(this.txField.getText() + button);
                break;
        }
    }
}
