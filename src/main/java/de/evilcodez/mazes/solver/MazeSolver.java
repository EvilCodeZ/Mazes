package de.evilcodez.mazes.solver;

import de.evilcodez.mazes.grid.Cell;

import java.util.List;

public abstract class MazeSolver {

    public abstract List<Cell> findPath(Cell start, Cell end);
}
