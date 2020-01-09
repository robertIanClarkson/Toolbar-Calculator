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
import java.net.MalformedURLException;
import java.net.URL;

public class MenuBarIconTest {
    public static void main(String[] args) throws MalformedURLException {
        TrayIcon trayIcon = null;
         if (SystemTray.isSupported()) {
             SystemTray tray = SystemTray.getSystemTray();
             Image image = Toolkit.getDefaultToolkit().getImage(new URL("https://img.icons8.com/ultraviolet/30/000000/plus-minus.png"));
             EvaluatorUI eval = new EvaluatorUI();
             ActionListener listener = new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     System.out.println(e);
                     eval.changeVisibility();
                 }
             };
             // create a popup menu
             // PopupMenu popup = new PopupMenu();
             // popup.addActionListener(listener);
             // // create menu item for the default action
             // MenuItem defaultItem = new MenuItem("ON/OFF");
             // defaultItem.addActionListener(listener);
             // popup.add(defaultItem);
//             popup.add()
             // construct a TrayIcon
             trayIcon = new TrayIcon(image, "Tray Demo");
             // set the TrayIcon properties
             trayIcon.addActionListener(listener);
             // ...
             // add the tray image
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
