# Algorithm Term Project - Group 8
Maze creation and path finding algorithm source code written by Java.

<hr>

# Maze creation algorithm
The maze creation algorithm uses the binary tree algorithm to create a maze.

### Binary tree  algorithm pseudo code
> 1. Designate all edges as unreachable walls
>    2. All even-numbered tiles are made into walls.
>       1. If you do this, all non-wall areas (green tiles) will be surrounded by walls on all sides.
>       2. Edge (1) is also blocked by a wall (because it’s an even number).
>    3. In this state, the wall in one of the two directions, either to the right or downward based on the tile rather than the wall, will be made green and drilled through.
>
> Summary: From the perspective of one accessible tile, one of the two walls to the right and bottom is randomly selected and changed into the accessible tile. In other words, it randomly selects one of two directions and clears the path.

Referenced document: [Maze creation algorithm (Binary Tree, Side Winder) with C#](https://ansohxxn.github.io/algorithm%20lesson%202/chapter3-2/)
<hr>

# Path finding algorithm

### Breadth-First Search (BFS)
````
BFS (G, s) //Where G is the graph and s is the source node.
    let Q be queue.
    Q.enqueue( s ) //Inserting s in queue until all its neighbour vertices are marked.

    mark s as visited.
    while ( Q is not empty)
        //Removing that vertex from queue,whose neighbour will be visited now
        v  =  Q.dequeue( )

        //processing all the neighbours of v  
        for all neighbours w of v in Graph G
            if (w is not visited) and (w is a passable node) and (w is in corret range)
                Q.enqueue( w ) //Stores w in Q to further visit its neighbour
                mark w as visited.
````

Referenced document: [Breadth First Search Tutorial](https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/)

### Depth-First Search (DFS)
````
DFS (S, s) //Where G is the graph and s is the source node.
    let S be stack.
    S.push( s ) //Inserting s in stack until all its neighbour vertices are marked.

    mark s as visited.
    while ( S is not empty)
        //Removing that vertex from stack, whose neighbour will be visited now
        v  =  S.pop( )

        //processing all the neighbours of v  
        for all neighbours w of v in Graph G
            if (w is not visited) and (w is a passable node) and (w is in corret range)
                S.push( w ) //Stores w in Q to further visit its neighbour
                mark w as visited.
````

Referenced document: [Breadth First Search Tutorial](https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/)

### A* algorithm with Euclidean distance as heuristic function

Let us call the heuristic weight function f(x) and assume that it consists of h(x) = g(x) + h(x). <br>
At this time, g(x) is the Euclidean distance from the start node to the x node, and h(x) is the Euclidean distance from the x node to the destination node.

Euclidean distance from $(x_1, y_1)$ to $(x_2, y_2)$ = $\sqrt{(x_1-x_2)^2+(y_1-y_2)^2}$

````
A* (G, s) //Where G is the graph and s is the source node.
    let PQ be priority queue. //And PQ is sorted in ascending order based on the heuristic function f(x).
    PQ.enqueue( s ) //Inserting s in queue until all its neighbour vertices are marked.

    mark s as visited.
    while ( PQ is not empty)
        //Removing that vertex from queue,whose neighbour will be visited now
        v  =  PQ.dequeue( )

        //processing all the neighbours of v  
        for all neighbours w of v in Graph G
            if (w is not visited) and (w is a passable node) and (w is in corret range)
                PQ.enqueue( w ) //Stores w in Q to further visit its neighbour
                mark w as visited.
````

### A* algorithm with Manhattan distance as heuristic function

Let us call the heuristic weight function f(x) and assume that it consists of h(x) = g(x) + h(x). <br>
At this time, g(x) is the Manhattan distance from the start node to the x node, and h(x) is the Manhattan distance from the x node to the destination node.

````
A* (G, s) //Where G is the graph and s is the source node.
    let PQ be priority queue. //And PQ is sorted in ascending order based on the heuristic function f(x).
    PQ.enqueue( s ) //Inserting s in queue until all its neighbour vertices are marked.

    mark s as visited.
    while ( PQ is not empty)
        //Removing that vertex from queue,whose neighbour will be visited now
        v  =  PQ.dequeue( )

        //processing all the neighbours of v  
        for all neighbours w of v in Graph G
            if (w is not visited) and (w is a passable node) and (w is in corret range)
                PQ.enqueue( w ) //Stores w in Q to further visit its neighbour
                mark w as visited.
````

Referenced document: [A* search algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm)
