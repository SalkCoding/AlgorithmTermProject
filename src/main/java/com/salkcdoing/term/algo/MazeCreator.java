package com.salkcdoing.term.algo;


import com.salkcdoing.term.data.Cell;
import com.salkcdoing.term.data.CellState;

import java.util.Random;

public class MazeCreator {

    private final int size;

    private final Cell[][] maze;

    public MazeCreator(int size) {
        if (size % 2 == 0) size++;
        this.size = size;
        this.maze = new Cell[size][size];
    }

    public Cell[][] createMaze() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maze[i][j] = new Cell(CellState.WALL);
            }
        }

        for (int i = 1; i < size; i += 2) {
            for (int j = 1; j < size; j += 2) {
                maze[i][j] = new Cell(CellState.EMPTY);
            }
        }

        Random random = new Random(System.currentTimeMillis());

        //Create way down or right
        for (int i = 1; i < size; i += 2) {
            for (int j = 1; j < size; j += 2) {
                if (i == size - 2 && j == size - 2) continue;

                if (i == size - 2) {
                    //right
                    maze[i][j + 1].setState(CellState.EMPTY);
                    continue;
                }

                if (j == size - 2) {
                    //down
                    maze[i + 1][j].setState(CellState.EMPTY);
                    continue;
                }

                if (random.nextBoolean()) maze[i][j + 1].setState(CellState.EMPTY);//right
                else maze[i + 1][j].setState(CellState.EMPTY);//down
            }
        }
        return maze;
    }

    public void printMaze() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maze[i][j].getState() == CellState.EMPTY) System.out.print("○");
                else System.out.print("●");
            }
            System.out.println();
        }
    }
}
