// 建立一个n个大小的大顶堆keep n个当前最小的数。初始化为第一行，poll一个a(最小的)，作为第一小，push一个a同列下面的入堆继续比较，再poll一个最为第二小，直到k个。

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        
        // first row
        for (int col = 0; col <= n - 1; col++) {
            pq.offer(new Tuple(0, col, matrix[0][col]));
        }
        
        // column based pushing (and only iterate k elements)
        for (int row = 0; row < k - 1; row++) {
            Tuple t = pq.poll();
            if (t.row == n - 1) continue;
            pq.offer(new Tuple(t.row + 1, t.col, matrix[t.row + 1][t.col]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int row, col, val;
    public Tuple (int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
