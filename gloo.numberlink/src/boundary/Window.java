package boundary;

import javax.swing.JFrame;

import control.Controller;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements KeyListener {
	 
    private Controller controller;
    private Viewer viewer;
}
