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
    static int x, y;
    static TrayIcon trayIcon = null;
    public static void main(String[] args) throws MalformedURLException {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
            Image image_background = Toolkit.getDefaultToolkit().getImage("icon_background.png");
            EvaluatorUI eval = new EvaluatorUI();
            trayIcon = new TrayIcon(image, "Calculator");
            trayIcon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        x = 100*(e.getX()/100);
                        y = e.getY();
                        eval.setLocation(x, y);
                        eval.changeVisibility();
                        if(eval.isVisible()) {
                            trayIcon.setImage(image_background);
                        } else {
                            trayIcon.setImage(image);
                        }

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