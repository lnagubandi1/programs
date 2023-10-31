import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0,5},
                {0,1,1,1,7},
                {2,5,7,0,0}};
        int[][] dist = new int[3][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{2, 0});
        dist[2][0] = arr[2][0];
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int dis = dist[x][y];
            if(x-1 > -1) {
                int up = arr[x-1][y] + dis;
                queue.add(new int[]{x-1,y});
                dist[x-1][y] = Math.max(dist[x-1][y],up);
            }
            if(y+1 < 5) {
                int right = arr[x][y+1] + dis;
                queue.add(new int[]{x,y+1});
                dist[x][y+1] = Math.max(dist[x][y+1],right);
            }
        }
        System.out.println(dist[0][4]);
    }
}
