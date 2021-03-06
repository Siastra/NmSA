import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import static spark.Spark.*;

/**
 * name: Glavanits Marcel & Alexander Lampalzer
 * matnr.: i14075 & i14085
 * catnr.: 03 & 10
 * Created on 20.04.2017
 * file: View
 * Class: 3CHIF
 */

public class View {
    private JFrame frame;

    public View() {
        URL url = NmSA.class.getResource("/icons/loading-gif.gif");
        ImageIcon imageIcon = new ImageIcon(url);

        JFrame frame = new JFrame("TitleLessJFrame");
        frame.getContentPane().add(new JLabel(imageIcon));
        frame.setUndecorated(true);
        frame.setSize(400, 300);
        frame.setType(Window.Type.UTILITY);
        frame.setAlwaysOnTop( true );
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);

        this.frame = frame;
    }

    /**
     * Starts the Webserver
     */
    void startWS() {
        port(80);
        staticFileLocation("/public/dist");
        init();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.frame.setVisible(false);
        startWebbrowser();
        this.frame.dispose();
    }

    /**
     * Starts the Browser
     */
    private void startWebbrowser() {
        String url = "http://localhost";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public void log(String message) {
        System.out.println(message);
    }
}
