package com.salkcdoing.term.algo;

import com.salkcdoing.term.data.Cell;
import com.salkcdoing.term.data.CellState;
import com.salkcdoing.term.data.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarEuclidean {

    private final Cell[][] maze;
    private final PriorityQueue<Point> queue;

    private final int size;

    private final boolean[][] visited;

    //down, right, top, left
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public AStarEuclidean(Cell[][] maze) {
        this.maze = maze;
        this.queue = new PriorityQueue<>(new DistanceComparator());
        this.size = maze.length;
        visited = new boolean[size][size];
    }

    public void printPath() {
        visited[1][1] = true;
        queue.add(new Point(1, 1));

        while (!queue.isEmpty()) {
            Point here = queue.poll();
            if (here.x() == size - 2 && here.y() == size - 2) break;

            for (int i = 0; i < 4; i++) {
                int nx = here.x() + dx[i];
                int ny = here.y() + dy[i];
                if (nx < 1 || ny < 1 || nx >= size - 1 || ny > size - 1) continue;
                if (maze[nx][ny].getState() == CellState.WALL || visited[nx][ny]) continue;
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visited[i][j]) System.out.print("◎");
                else if (maze[i][j].getState() == CellState.EMPTY) System.out.print("○");
                else System.out.print("●");
            }
            System.out.println();
        }
    }

    private class DistanceComparator implements Comparator<Point> {

        private final Point start = new Point(1, 1);
        private final Point goal = new Point(size - 2, size - 2);

        @Override
        public int compare(Point arg0, Point arg1) {
            if (getDistanceFromGoal(arg0) > getDistanceFromGoal(arg1)) {
                return 1;
            } else {
                return getDistanceFromGoal(arg0) < getDistanceFromGoal(arg1) ? -1 : 0;
            }
        }


        private double getDistanceFromGoal(Point c) {
            return g(c) + h(c);
        }

        //Heuristic start -> current
        private double g(Point c) {
            return Math.hypot(c.x() - start.x(), c.y() - start.y());
        }

        //Heuristic current -> goal
        private double h(Point c) {
            return Math.hypot(c.x() - goal.x(), c.y() - goal.y());
        }
    }
}
