class Solution {
    public int maximumMinimumPath(int[][] A) {
        int[][] dir = new int[][]{{-1,0},{0,1},{0,-1},{1,0}};
        boolean[][] visited = new boolean[A.length][A[0].length];

        Queue<int[]> que = new PriorityQueue<>((a,b)->b[2]-a[2]);
        que.add(new int[]{0,0,A[0][0]});
        visited[0][0] = true;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            if(temp[0]==A.length-1 && temp[1] == A[0].length-1) return temp[2];
            for(int[] x:dir){
                int newX = temp[0] + x[0];
                int newY = temp[1] + x[1];
                if(newX<0 || newY <0 || newX > A.length-1 || newY > A[0].length-1 || visited[newX][newY])                           continue;
                que.add(new int[]{newX,newY,Math.min(temp[2],A[newX][newY])});
                visited[newX][newY] = true;

            }
        }
        return -1;
    }
}
