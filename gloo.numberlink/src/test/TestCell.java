package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Cell;
import entity.Grid;

class TestCell {

	@Test
	void testCellNotNull() {
		Grid grid = new Grid(2,2,1);
		Cell cell = new Cell(grid, 0, 0);
		assertNotNull(cell);
	}
	
	@Test
	void testValidCell() {
		Grid grid = new Grid(2,2,1);
		assertThrows(
                IllegalArgumentException.class,
                () -> { new Cell(grid, 0, 2); }
            );
	}

}
