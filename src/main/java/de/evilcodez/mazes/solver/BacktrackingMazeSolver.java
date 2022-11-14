package de.evilcodez.mazes.solver;

import de.evilcodez.mazes.grid.Cell;
import de.evilcodez.mazes.grid.Grid;

import java.util.*;

public class BacktrackingMazeSolver extends MazeSolver {

    @Override
    public List<Cell> findPath(Cell start, Cell end) {
        if (start.getGrid() != end.getGrid()) throw new IllegalArgumentException("Cells must be in the same grid");
        final Stack<Cell> stack = new Stack<>();
        final Set<Cell> visited = new HashSet<>();
        final Grid grid = start.getGrid();
        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty()) {
            final Cell cell = stack.peek();
            if (cell == end) {
                return new ArrayList<>(stack);
            }
            final List<Cell> neighbors = grid.getNeighborsOf(cell);
            neighbors.removeIf(c -> visited.contains(c) || grid.hasWallsBetween(cell, c));
            if (neighbors.isEmpty()) {
                stack.pop();
                continue;
            }
            final Cell next = neighbors.get(0);
            stack.push(next);
            visited.add(next);
        }
        return null;
    }
}
