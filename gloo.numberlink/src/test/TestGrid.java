package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Cell;
import entity.Grid;
import entity.Direction;

class TestGrid {

	@Test
	void testGridNotNull() {
		Grid grid = new Grid(6,6,6);
		assertNotNull(grid);
	}
	
	@Test
	void testCorrectNeighbor1() {
		Grid grid = new Grid(2,2,1);
		Cell cell1 = new Cell(grid, 0, 0);
		Cell cell2 = new Cell(grid, 1, 0);
		Cell cell3 = new Cell(grid, 0, 1);
		Cell cell4 = new Cell(grid, 1, 1);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		assertEquals(grid.getNeighbor(cell1, Direction.DOWN), cell3);
	}

	@Test
	void testCorrectNeighbor2() {
		Grid grid = new Grid(2,2,1);
		Cell cell1 = new Cell(grid, 0, 0);
		Cell cell2 = new Cell(grid, 1, 0);
		Cell cell3 = new Cell(grid, 0, 1);
		Cell cell4 = new Cell(grid, 1, 1);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		assertEquals(grid.getNeighbor(cell1, Direction.RIGHT), cell2);
	}
	
	@Test
	void testCorrectNeighbor3() {
		Grid grid = new Grid(2,2,1);
		Cell cell1 = new Cell(grid, 0, 0);
		Cell cell2 = new Cell(grid, 1, 0);
		Cell cell3 = new Cell(grid, 0, 1);
		Cell cell4 = new Cell(grid, 1, 1);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		assertEquals(grid.getNeighbor(cell4, Direction.LEFT), cell3);
	}
	
	@Test
	void testCorrectNeighbor4() {
		Grid grid = new Grid(2,2,1);
		Cell cell1 = new Cell(grid, 0, 0);
		Cell cell2 = new Cell(grid, 1, 0);
		Cell cell3 = new Cell(grid, 0, 1);
		Cell cell4 = new Cell(grid, 1, 1);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		assertEquals(grid.getNeighbor(cell4, Direction.UP), cell2);
	}
}
