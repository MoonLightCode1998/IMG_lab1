package GIK;
import javax.swing.*;

public class Frame extends JFrame {
    public Frame(){
        initUI();
    }
    private void initUI(){
        add(new BackGround());
        setTitle("HAPPY X-MASS EVE");
        setSize(1900,900);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
