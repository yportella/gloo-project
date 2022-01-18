package control;

import entity.Grid;
import entity.Path;

import entity.Direction;

public class Controller implements IController {
	
	private Grid grid;
	private Path currentPath;
	private Direction[] direction0 = new Direction[] {};
	private Direction[] direction1 = new Direction[] {};
	private Direction[] direction2 = new Direction[] {};
	private Direction[] direction3 = new Direction[] {};
	private Direction[] direction4 = new Direction[] {};
	private Direction[] direction5 = new Direction[] {};
	private int[][] pos0 = new int[][] {{0, 0},{4, 0}};
	private int[][] pos1 = new int[][] {{5, 0},{4, 4}};
	private int[][] pos2 = new int[][] {{1, 2},{2, 3}};
	private int[][] pos3 = new int[][] {{4, 1},{3, 2}};
	private int[][] pos4 = new int[][] {{4, 2},{1, 4}};
	private int[][] pos5 = new int[][] {{2, 2},{5, 5}};
	
	public Controller(Grid grid) {
		this.grid = grid;
	}
	
	@Override
	public boolean clickCell(int line, int column) {
		try {
			Path path = grid.createNewPath(line, column);
			currentPath = path;
			int tagId = currentPath.getTagId();
			updatePos(tagId, line, column);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public boolean action(Direction direction) {
		boolean adv = currentPath.advance(direction); 
		if (adv) {
			int tagId = currentPath.getTagId();
			updateDirections(tagId, direction);
		} else {
			System.out.println("On ne peut pas avancer");
		}
		boolean res = grid.isFinished();
		grid.GridString();
		return res;
    }

	@Override
	public int getNbLines() {
		return grid.getNbLines();
		}

	@Override
	public int getNbColumns() {
	    return grid.getNbColumns();
	    }

	@Override
	public int getNbTags() {
	    return 6;
	    }

	@Override
	public int[] getStartPathPosition( int tag ) {
	    return switch( tag ) {
	    	case 0 -> pos0[0];
	    	case 1 -> pos1[0];
	    	case 2 -> pos2[0];
	    	case 3 -> pos3[0];
	    	case 4 -> pos4[0];
	    	case 5 -> pos5[0];
	        default -> null;
	        };
	    }

	@Override
	public int[] getSecondEndPosition( int tag ) {
	    return switch( tag ) {
	    	case 0 -> pos0[1];
	    	case 1 -> pos1[1];
	    	case 2 -> pos2[1];
	    	case 3 -> pos3[1];
	    	case 4 -> pos4[1];
	    	case 5 -> pos5[1];
	    	default -> null;
        	};
	    }

	@Override
	public Direction[] getDirections( int tag ) {
		return switch( tag ) {
        case 0 -> direction0;
        case 1 -> direction1;
        case 2 -> direction2;
        case 3 -> direction3;
        case 4 -> direction4;
        case 5 -> direction5;
        default -> null;
        };
    }
	
	private void updateDirections(int tagId, Direction dir) {
		switch (tagId) {
		case 0 -> direction0 = updateDir(direction0,dir);
        case 1 -> direction1 = updateDir(direction1,dir);
        case 2 -> direction2 = updateDir(direction2,dir);
        case 3 -> direction3 = updateDir(direction3,dir);
        case 4 -> direction4 = updateDir(direction4,dir);
        case 5 -> direction5 = updateDir(direction5,dir);
		};		
	}
	
	private Direction[] updateDir(Direction[] directions, Direction dir) {
		int n = directions.length;
		Direction[] newDir = new Direction[n+1];
		for(int i = 0; i < n; i++) {
			newDir[i] = directions[i];
		}
		newDir[n] = dir;
		return newDir;
	}
	
	private void updatePos(int tagId, int line, int column) {
		int[] coord = new int[] {line, column};
		switch(tagId) {
        case 0 -> pos0 = swapPos(pos0, coord);
        case 1 -> pos1 = swapPos(pos1, coord);
        case 2 -> pos2 = swapPos(pos2, coord);
        case 3 -> pos3 = swapPos(pos3, coord);
        case 4 -> pos4 = swapPos(pos4, coord);
        case 5 -> pos5 = swapPos(pos5, coord);
        };
	}
	
	private int[][] swapPos(int[][] pos, int[] coord) {
		if ((pos[0][0] == coord[0])&&(pos[0][1] == coord[1])) {
			return pos;
		} else {
			return new int[][] {coord,pos[0]};
		}
	}
	
}
