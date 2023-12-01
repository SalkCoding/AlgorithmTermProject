package com.salkcdoing.term;

import com.salkcdoing.term.algo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        MazeCreator creator = new MazeCreator(size);

        System.out.println("Created maze");
        var maze = creator.createMaze();
        creator.printMaze();

        System.out.println("Solved by DFS");
        DFS dfs = new DFS(maze);
        dfs.printPath();

        System.out.println("Solved by BFS");
        BFS bfs = new BFS(maze);
        bfs.printPath();

        System.out.println("Solved by A* (Euclidean heuristic function)");
        AStarEuclidean astar = new AStarEuclidean(maze);
        astar.printPath();

        System.out.println("Solved by A* (Manhattan heuristic function)");
        AStarManhattan aStarManhattan = new AStarManhattan(maze);
        aStarManhattan.printPath();
    }
}