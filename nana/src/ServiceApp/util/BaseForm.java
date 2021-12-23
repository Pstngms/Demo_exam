package ServiceApp.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class BaseForm extends JFrame {
    public static String title = "Good Boy";
    public static Image Ico = null;
    static {
        try {
            Ico = ImageIO.read(BaseForm.class.getClassLoader().getResource("school_logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    public BaseForm(int width, int height) {
        setMinimumSize(new Dimension(width, height));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2
        );
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        if (Ico!=null){
            setIconImage(Ico);
        }
    }
}