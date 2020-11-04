import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightBFS {
    /*
        all 8 possible ways to move a knight
        (x + 2, y + 1)
        (x + 2, y - 1)...
     */
    static final int[] xs = {2, 2, -2, -2, 1, 1, -1, -1};
    static final int[] ys = {1, -1, 1, -1, 2, -2, 2, -2};
    static final int BOARD_SIZE = 8;
    static final int NUM_CELLS = 64;
    static int src = 0;
    static int dest = 1;

    public static void main(String []args) {
        System.out.println(solution(src, dest));
    }


    public static int solution(int src, int dest) {
        // store dist arr
        int[] dist = new int[NUM_CELLS];
        // store parent of node
        int[] parent = new int[NUM_CELLS];
        // store path
        LinkedList<Integer> path = new LinkedList<>();
        // visited set
        Set<Integer> visited = new HashSet<>();
        // check if dest exists in boarder
        boolean exists = false;
        // for bfs
        Queue<Node> q = new LinkedList<>();

        Node source = new Node(src / BOARD_SIZE, src % BOARD_SIZE);
        q.add(source);

        // all distances will be infinity except source
        for (int i = 0; i < NUM_CELLS; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        dist[src] = 0;

        bfs(q, visited, dist, parent, exists);
        printPaths(exists, path, parent, dest);

        return dist[dest];
    }

    /*
        BFS
     */
    public static void bfs(Queue<Node> q, Set<Integer> visited, int[] dist, int parent[], boolean exists) {
        // begin bfs
        while (!q.isEmpty()) {
            // check if node is visited
            Node node = q.poll();
            if (!visited.contains(node.getVal())) {
                visited.add(node.getVal());
                // go thru neighbors
                for (int i = 0; i < BOARD_SIZE; i++) {
                    int neighborX  = node.x + xs[i];
                    int neighborY  = node.y + ys[i];
                    int neighborVal = neighborX * BOARD_SIZE + neighborY;
                    // check if its in in the board, check if visited then add to array if not
                    if (isValidCoord(neighborX, neighborY) && !visited.contains(neighborVal)) {
                        Node neighbor = new Node(neighborX, neighborY);
                        dist[neighbor.getVal()] = dist[node.getVal()] + 1;
                        parent[neighbor.getVal()] = node.getVal();
                        q.add(neighbor);
                        // this is when we stop BFS
                        if (node.getVal() == dest) {
                            exists = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    /*
        checks if possible neighbor is within the board
     */
    public static boolean isValidCoord(int x,  int y) {
        if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
            return true;
        }
        return false;
    }

    /*
        prints paths from destination to source
     */
    public static void printPaths(boolean exists, LinkedList<Integer>path, int parent[], int dest) {
        if (exists)  {
            path.add(dest);
            int tempDest = dest;
            System.out.println(dest);
            while (parent[tempDest] != -1) {
                System.out.println(parent[tempDest]);
                path.add(parent[tempDest]);
                tempDest = parent[tempDest];
            }
        }
    }
}
