package boundary;

import java.awt.Graphics;

import javax.swing.JPanel;

import control.Controller;
 
public class Viewer extends JPanel {
 
    private Controller controller;
 
    public Viewer(Controller controller) {
        this.controller = controller;
    }
 
    @Override
    public void paint() {
    }
 
}
