import calculator.EvaluatorUI;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuBarIconTest {
    public static void main(String[] args) throws MalformedURLException {
        TrayIcon trayIcon = null;
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(new URL("https://img.icons8.com/ultraviolet/30/000000/plus-minus.png"));
            EvaluatorUI eval = new EvaluatorUI();
            trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        eval.setLocation(e.getX(), e.getY());
                        eval.changeVisibility();
                    }
                }
            });
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
            // ...
        } else {
            // disable tray option in your application or
            // perform other actions
            //...
        }
        // ...
        // some time later
        // the application state has changed - update the image
        if (trayIcon != null) {
            //trayIcon.setImage(updatedImage);
        }

    }
}