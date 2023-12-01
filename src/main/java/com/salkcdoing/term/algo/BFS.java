package com.salkcdoing.term.algo;


import com.salkcdoing.term.data.Cell;
import com.salkcdoing.term.data.CellState;
import com.salkcdoing.term.data.Point;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private final Cell[][] maze;
    private final Queue<Point> queue;

    private final int size;

    private final boolean[][] visited;

    //down, right, top, left
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public BFS(Cell[][] maze) {
        this.maze = maze;
        this.queue = new LinkedList<>();
        this.size = maze.length;
        visited = new boolean[size][size];
    }

    public void printPath() {
        queue.add(new Point(1, 1));
        visited[1][1] = true;

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

}

