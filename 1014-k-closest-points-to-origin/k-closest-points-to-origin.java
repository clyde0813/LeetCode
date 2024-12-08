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
            double distance = (double) point[0] * point[0] + (double) point[1] * point [1];
            pq.add(new Point(distance, point));
        }
        for(int i=0; i<k; i++){
            results[i] = pq.poll().point;
        }
        return results;
    }
}