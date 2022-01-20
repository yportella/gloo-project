package control;

import entity.Grid;
import entity.Path;

import entity.Direction;

public class Controller implements IController {
	
	private Grid grid;
	private Path currentPath;
	private Direction[][] directions = new Direction[getNbTags()][];
	private int[][][] positions = new int [getNbTags()][][];
	
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
	    return positions[tag][0];
	}

	@Override
	public int[] getSecondEndPosition( int tag ) {
	    return positions[tag][1];
	    }

	@Override
	public Direction[] getDirections( int tag ) {
		if (directions[tag] == null) {
			directions[tag] = new Direction[] {};
		};
		return directions[tag];
    }
	
	private void updateDirections(int tagId, Direction dir) {
		directions[tagId] = updateDir(directions[tagId],dir);	
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
		positions[tagId] = swapPos(positions[tagId], coord);
	}
	
	private int[][] swapPos(int[][] pos, int[] coord) {
		if ((pos[0][0] == coord[0])&&(pos[0][1] == coord[1])) {
			return pos;
		} else {
			return new int[][] {coord,pos[0]};
		}
	}
	
	public void setPositions(int tagId, int line1, int col1, int line2, int col2) {
		positions[tagId] = new int[][] {{line1, col1}, {line2, col2}};
	}
	
}
