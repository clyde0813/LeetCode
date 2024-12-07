class Solution {
    static class Point{
        double distance;
        int[] point;
        public Point(double distance, int[] point){
            this.distance = distance;
            this.point = point;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] results = new int[k][];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(point -> point.distance));
        for(int[] point : points){
            // Omitting the square root calculation, as it's unnecessary for distance ranking
            double distance = (long) point[0] * point[0] + (long) point[1] * point[1];
            pq.add(new Point(distance, point));
        }
        for(int i=0;i<k;i++){
            results[i] = pq.poll().point;
        }
        return results;
    }
}