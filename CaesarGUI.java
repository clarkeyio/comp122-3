import javax.swing.*;

/**
 *
 * The caesar graphical user interface. Instantiates every component of the frame,
 * and adds it to it.
 *
 * @author  Ben Clarke
 * @see     RotationCipher
 *
 */
public class CaesarGUI extends JFrame {
    private Caesar caesar;
    private JTextField textField;
    private JTextField integerField;
    private JTextField cryptoField;
    private JButton button;
    private JLabel textLabel;
    private JLabel integerLabel;
    private JLabel cryptoLabel;

    /**
     * The constructor. Instantiates the labels, text fields and buttons and adds
     * it to the adds it to the class.
     */
    public CaesarGUI() {
        // Create an instance of the Caesar class and make it available to the CaesarGUI
        // class.
        this.caesar = new Caesar();

        setLayout(null);

        // Create instances of various different components, make them accessible
        // the class.
        textField = new JTextField();
        integerField = new JTextField();
        cryptoField = new JTextField();
        button = new JButton("Encrypt");
        textLabel = new JLabel("Text to encrypt:");
        integerLabel = new JLabel("Encryption key:");
        cryptoLabel = new JLabel("Encrypted text:");

        // Add every component to the JFrame
        add(textField);
        add(integerField);
        add(cryptoField);
        add(button);
        add(textLabel);
        add(integerLabel);
        add(cryptoLabel);

        // Create an instance of the ButtonClicked ActionListener, add it to the button
        ButtonClicked bc = new ButtonClicked(this);
        button.addActionListener(bc);

        // Set the x-coordinate, y-coordinate, width and height of each component
        textLabel.setBounds(10, 10, 300, 50);
        textField.setBounds(10, 60, 300, 50);
        integerLabel.setBounds(10, 110, 300, 50);
        integerField.setBounds(10, 160, 300, 50);
        cryptoLabel.setBounds(10, 210, 300, 50);
        cryptoField.setBounds(10, 260, 300, 50);
        button.setBounds(160, 340, 150, 50);
    }

    /**
     * Creates an instance of itself and sets frame properties such as title,
     * close opertation, bounds and visibility.
     *
     * @param   args    an array of arguments
     */
    public static void main(String[] args) {
        JFrame frame = new CaesarGUI();
        frame.setTitle("Caesar Crypt");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(50, 50, 340, 450);
        frame.setVisible(true);
    }

    /**
     * Rotates the text by an integer amount, and updates the relevant field.
     */
    public void encrypt() {
        int n;
        // Try to parse the text in the integer field as an integer
        try {
            // This is the line that could fail
            n = Integer.parseInt(integerField.getText());
            String encrypted = this.caesar.rotate(textField.getText(), n);
            cryptoField.setText(encrypted);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Encryption key must be an integer value.",
                "Invalid Encryption Key",
                JOptionPane.WARNING_MESSAGE);
        }
    }
}
