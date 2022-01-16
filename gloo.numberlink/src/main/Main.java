package main;

import javax.swing.SwingUtilities;


import entity.Cell;
import entity.Grid;
import entity.Path;
import entity.Tag;
import control.Controller;
import entity.End;
import boundary.NumberlinkWindow;

public class Main implements Runnable {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}

	@Override
	public void run() {
		Grid grid = new Grid(2,2);
		Cell cell1 = new Cell(grid,0,0);
		Cell cell2 = new Cell(grid,0,1);
		Cell cell3 = new Cell(grid,1,0);
		Cell cell4 = new Cell(grid,1,1);
		Tag tag = new Tag(0);
		End e1 = new End(tag, cell1);
		End e2 = new End(tag, cell4);
		cell1.setEnd(e1);
		cell4.setEnd(e2);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		Controller myController = new Controller(grid);
		NumberlinkWindow myWindow = new NumberlinkWindow(myController);
	}

}
