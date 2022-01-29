package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Direction;
import entity.Cell;
import entity.Grid;
import entity.Path;
import entity.Tag;

class TestPath {

	@Test
	void testPathNotNull() {
		Path p = new Path(new Tag(2));
		assertNotNull(p);
	}
	
	@Test
	void testPathTag() {
		Path p = new Path(new Tag(2));
		assertEquals(p.getTagId(), 2);
	}
	
	@Test
	void testAddCell() {
		Path p = new Path(new Tag(2));
		Grid grid = new Grid(3,3,2);
		Cell c = new Cell(grid, 0, 0);
		p.addCell(c);
		assertEquals(p.getLastCell(), c);
	}
	
	@Test
	void testAdvanceTrue() {
		Path p = new Path(new Tag(2));
		Grid grid = new Grid(2,2,2);
		Cell cell1 = new Cell(grid, 0, 0);
		Cell cell2 = new Cell(grid, 0, 1);
		Cell cell3 = new Cell(grid, 1, 0);
		Cell cell4 = new Cell(grid, 1, 1);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		p.addCell(cell1);
		boolean b = p.advance(Direction.RIGHT);
		assertTrue(b);
		assertEquals(p.getLastCell(), cell2);
	}
	
	
	// If we don't have a neighbor in the direction
	@Test
	void testAdvanceFalse() {
		Path p = new Path(new Tag(2));
		Grid grid = new Grid(2,2,2);
		Cell cell1 = new Cell(grid, 0, 0);
		Cell cell2 = new Cell(grid, 0, 1);
		Cell cell3 = new Cell(grid, 1, 0);
		Cell cell4 = new Cell(grid, 1, 1);
		grid.setCells(new Cell[][] {{cell1, cell2},{cell3,cell4}});
		p.addCell(cell1);
		boolean b = p.advance(Direction.UP);
		assertFalse(b);
	}

}
