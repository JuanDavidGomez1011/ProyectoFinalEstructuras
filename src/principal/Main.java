package principal;

import vistas.PanelPrincipal;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new PanelPrincipal().setVisible(true);
        });

    }
}
