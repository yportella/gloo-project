package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Cell;
import entity.End;
import entity.Grid;
import entity.Tag;

class TestEnd {

	@Test
	void testEndNotNull() {
		Grid grid = new Grid(3,3,2);
		Cell c = new Cell(grid, 0, 0);
		Tag tag = new Tag(0);
		End e = new End(tag, c);
		assertNotNull(e);
	}
	
	@Test
	void testEndCorrect() {
		Grid grid = new Grid(3,3,2);
		Cell c = new Cell(grid, 0, 0);
		Tag tag = new Tag(0);
		End e = new End(tag, c);
		assertEquals(e.getTag(), tag);
		assertEquals(e.getCell(), c);
	}
	
	@Test
	void testSameTagTrue() {
		Grid grid = new Grid(3,3,2);
		Cell c = new Cell(grid, 0, 0);
		Tag tag = new Tag(0);
		End e = new End(tag, c);
		assertTrue(e.sameTag(tag));
	}
	
	@Test
	void testSameTagFalse() {
		Grid grid = new Grid(3,3,2);
		Cell c = new Cell(grid, 0, 0);
		Tag tag = new Tag(0);
		End e = new End(tag, c);
		assertFalse(e.sameTag(new Tag(2)));
	}

}
