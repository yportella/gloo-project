package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Cell;
import entity.End;
import entity.Grid;
import entity.Tag;

class TestTag {

	@Test
	void testTagNotNull() {
		Tag t = new Tag(3);
		assertNotNull(t);
	}
	
	@Test
	void testTagCorrect() {
		Tag t = new Tag(3);
		assertEquals(t.getTagId(), 3);
	}
	
	@Test
	void testTagFalse() {
		Tag t = new Tag(3);
		assertNotEquals(t.getTagId(), 2);
	}
	
	@Test
	void testSetEndsNotNull() {
		Grid grid = new Grid(3,3,2);
		Cell c1 = new Cell(grid, 0, 0);
		Cell c2 = new Cell(grid, 0, 1);
		Tag tag = new Tag(0);
		End e1 = new End(tag, c1);
		End e2 = new End(tag, c2);
		tag.setEnds(e1, e2);
		assertNotNull(tag.getEnds()[0]);
		assertNotNull(tag.getEnds()[1]);
	}
	
	@Test
	void testSetEndsTrue() {
		Grid grid = new Grid(3,3,2);
		Cell c1 = new Cell(grid, 0, 0);
		Cell c2 = new Cell(grid, 0, 1);
		Tag tag = new Tag(0);
		End e1 = new End(tag, c1);
		End e2 = new End(tag, c2);
		tag.setEnds(e1, e2);
		assertEquals(tag.getEnds()[0], e1);
		assertEquals(tag.getEnds()[1], e2);
	}

}
