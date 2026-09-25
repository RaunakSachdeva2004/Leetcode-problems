class Solution {
    
    public void bfs(int i , boolean[] vis,int[][] adj){
        int n = adj.length;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(i);

        while(q.size()>0){
            int fr = q.remove();

            for(int j = 0; j<n;j++){
                if(adj[fr][j] == 1 && vis[j]==false){
                    q.add(j); vis[j]=true;
                }
            }
        }
    }


    
    
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        boolean[] vis = new boolean[n];

        for(int i = 0; i< n; i++){
            if(vis[i] == false){
                bfs(i,vis,adj);
                count++;
            }
        }       
        return count;
    }
}