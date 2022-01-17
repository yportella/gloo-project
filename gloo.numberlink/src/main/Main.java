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
		Grid grid = new Grid(6,6);
		Cell cell00 = new Cell(grid,0,0);
		Cell cell01 = new Cell(grid,0,1);
		Cell cell02 = new Cell(grid,0,2);
		Cell cell03 = new Cell(grid,0,3);
		Cell cell04 = new Cell(grid,0,4);
		Cell cell05 = new Cell(grid,0,5);
		Cell cell10 = new Cell(grid,1,0);
		Cell cell11 = new Cell(grid,1,1);
		Cell cell12 = new Cell(grid,1,2);
		Cell cell13 = new Cell(grid,1,3);
		Cell cell14 = new Cell(grid,1,4);
		Cell cell15 = new Cell(grid,1,5);
		Cell cell20 = new Cell(grid,2,0);
		Cell cell21 = new Cell(grid,2,1);
		Cell cell22 = new Cell(grid,2,2);
		Cell cell23 = new Cell(grid,2,3);
		Cell cell24 = new Cell(grid,2,4);
		Cell cell25 = new Cell(grid,2,5);
		Cell cell30 = new Cell(grid,3,0);
		Cell cell31 = new Cell(grid,3,1);
		Cell cell32 = new Cell(grid,3,2);
		Cell cell33 = new Cell(grid,3,3);
		Cell cell34 = new Cell(grid,3,4);
		Cell cell35 = new Cell(grid,3,5);
		Cell cell40 = new Cell(grid,4,0);
		Cell cell41 = new Cell(grid,4,1);
		Cell cell42 = new Cell(grid,4,2);
		Cell cell43 = new Cell(grid,4,3);
		Cell cell44 = new Cell(grid,4,4);
		Cell cell45 = new Cell(grid,4,5);
		Cell cell50 = new Cell(grid,5,0);
		Cell cell51 = new Cell(grid,5,1);
		Cell cell52 = new Cell(grid,5,2);
		Cell cell53 = new Cell(grid,5,3);
		Cell cell54 = new Cell(grid,5,4);
		Cell cell55 = new Cell(grid,5,5);
		Tag tag0 = new Tag(0);
		Tag tag1 = new Tag(1);
		Tag tag2 = new Tag(2);
		Tag tag3 = new Tag(3);
		Tag tag4 = new Tag(4);
		Tag tag5 = new Tag(5);
		End e01 = new End(tag0, cell00);
		End e02 = new End(tag0, cell40);
		cell00.setEnd(e01);
		cell40.setEnd(e02);
		End e11 = new End(tag1, cell50);
		End e12 = new End(tag1, cell44);
		cell50.setEnd(e11);
		cell44.setEnd(e12);
		End e21 = new End(tag2, cell12);
		End e22 = new End(tag2, cell23);
		cell12.setEnd(e21);
		cell23.setEnd(e22);
		End e31 = new End(tag3, cell41);
		End e32 = new End(tag3, cell32);
		cell41.setEnd(e31);
		cell32.setEnd(e32);
		End e41 = new End(tag4, cell42);
		End e42 = new End(tag4, cell14);
		cell42.setEnd(e41);
		cell14.setEnd(e42);
		End e51 = new End(tag5, cell22);
		End e52 = new End(tag5, cell55);
		cell22.setEnd(e51);
		cell55.setEnd(e52);
		grid.setCells(new Cell[][] {{cell00, cell01, cell02, cell03, cell04, cell05},
			{cell10, cell11, cell12, cell13, cell14, cell15},
			{cell20, cell21, cell22, cell23, cell24, cell25},
			{cell30, cell31, cell32, cell33, cell34, cell35},
			{cell40, cell41, cell42, cell43, cell44, cell45},
			{cell50, cell51, cell52, cell53, cell54, cell55}});
		Controller myController = new Controller(grid);
		NumberlinkWindow myWindow = new NumberlinkWindow(myController);
	}

}
