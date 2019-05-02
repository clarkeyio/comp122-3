import javax.swing.*;

/**
 *
 * The caesar decipher graphical user interface. Instantiates every component of
 * the frame, and adds it to it.
 *
 * @author  Ben Clarke
 * @see     RotationCipher
 *
 */
public class CaesarDecipherGUI extends JFrame {
    private Caesar caesar;
    private JTextField textField;
    private JTextField cryptoField;
    private JButton button;
    private JLabel textLabel;
    private JLabel cryptoLabel;

    /**
     * The constructor. Instantiates the labels, text fields and buttons and adds
     * it to the adds it to the class.
     */
    public CaesarDecipherGUI() {
        // Create an instance of the Caesar class and make it available to the CaesarGUI
        // class.
        this.caesar = new Caesar();

        setLayout(null);

        // Create instances of various different components, make them accessible
        // the class.
        textField = new JTextField();
        cryptoField = new JTextField();
        button = new JButton("Decrypt");
        textLabel = new JLabel("Text to decrypt:");
        cryptoLabel = new JLabel("Decrypted text:");

        // Add every component to the JFrame
        add(textField);
        add(cryptoField);
        add(button);
        add(textLabel);
        add(cryptoLabel);

        // Create an instance of the ButtonClicked ActionListener, add it to the button
        ButtonClicked bc = new ButtonClicked(this);
        button.addActionListener(bc);

        // Set the x-coordinate, y-coordinate, width and height of each component
        textLabel.setBounds(10, 10, 300, 50);
        textField.setBounds(10, 60, 300, 50);
        cryptoLabel.setBounds(10, 110, 300, 50);
        cryptoField.setBounds(10, 160, 300, 50);
        button.setBounds(160, 240, 150, 50);
    }

    /**
     * Creates an instance of itself and sets frame properties such as title,
     * close opertation, bounds and visibility.
     *
     * @param   args    an array of arguments
     */
    public static void main(String[] args) {
        JFrame frame = new CaesarDecipherGUI();
        frame.setTitle("Caesar DeCrypt");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(50, 50, 340, 350);
        frame.setVisible(true);
    }

    /**
     * Decrypts the encrypted text without a secret key, and updates the relevant
     * field.
     */
    public void decrypt() {
        String decrypted = this.caesar.decipher(textField.getText());
        cryptoField.setText(decrypted);
    }
}
