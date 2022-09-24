import java.util.HashMap;
import java.util.PriorityQueue;

public class FindKClosestPoint {
    static class Coordinates {
        int x, y;
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pair {
        Coordinates c;
        Integer d;

        Pair(Coordinates c, int d) {
            this.c = c;
            this.d = d;
        }
    }

    static int[][] findKClosestPoint(int[][] coordinates, int k) {
        int [][]closestPoints = new int[k][2];
        Integer d;

        HashMap<Coordinates, Integer> map = new HashMap<>();
        for (int[] i: coordinates) {
            d = (i[0] * i[0]) + (i[1] * i[1]);
            map.put(new Coordinates(i[0], i[1]), d);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.d.compareTo(o1.d));

        for (Coordinates c: map.keySet()) {
            pq.add(new Pair(c, map.get(c)));

            if (pq.size() > k)
                pq.poll();
        }

        int i = 0;

        while (!pq.isEmpty()) {
            closestPoints[i][0] = pq.peek().c.x;
            closestPoints[i][1] = pq.peek().c.y;
            i++;
            pq.poll();
        }

        return closestPoints;
    }

    public static void main(String[] args) {
        int[][] coordinates = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };
        int k = 2;
        int[][] closestPoint = findKClosestPoint(coordinates, k);

        for (int[] point: closestPoint) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}
