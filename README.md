# ChessKnightBFS

## Premise
A knight is moved across an n x n (in this case, 8 x 8) chessboard from a source to a destination. This chessboard is 
increasingly numbered with integers from 0 to 63 inclusive, where the top left corner's value is 0 at (0,0), and the 
bottom right corner'svalue is 63 at (7, 7). A knight's single movement consists of 2 squares in one direction, followed 
by 1 square in the other direction. This program returns the number of minimum steps for the knight to reach the 
destination from the source.

## Algorithm
A Breadth-First-Search algorithm is used to find the shortest path of an unweighted graph.

## Runtime and Space Complexity Analysis
Runtime: Worst case: O(n^2), where n = dimension of the square board size (8 x 8 chessboard)

- The worst case is for the knight to traverse through the entire chessboard from the source to destination.

Space : Worst case: O(n^2)

- All of the nodes of the graph (64 nodes) are stored in multiple data structures such as an array, linkedlist, set, 
and queue.
