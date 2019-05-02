import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * The button controller.
 *
 * @author  Ben Clarke
 *
 */
public class ButtonClicked implements ActionListener {
    private CaesarGUI cgui;
    private CaesarDecipherGUI cdgui;

    /**
     * Makes the Caesar GUI accessible to the class.
     *
     * @param   cgui    the Caesar GUI
     */
    public ButtonClicked(CaesarGUI cgui) {
        this.cgui = cgui;
    }

    /**
     * Makes the Caesar Decipher GUI accessible to the class.
     *
     * @param   cdgui    the Caesar Decipher GUI
     */
    public ButtonClicked(CaesarDecipherGUI cdgui) {
        this.cdgui = cdgui;
    }

    /**
     * This method is called when the button is clicked. Triggers the GUI to encrypt.
     *
     * @param   e       the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        if (this.cgui != null) {
            this.cgui.encrypt();
        } else if (this.cdgui != null) {
            this.cdgui.decrypt();
        }
    }
}
