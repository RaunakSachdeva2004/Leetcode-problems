class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int len1 = firstList.length, len2 = secondList.length;
        List<Integer[]> res = new ArrayList<>();

        while( i< len1 && j < len2){
            int e1 = firstList[i][1];
            int e2 = secondList[j][1];
            int s1 = firstList[i][0];
            int s2 = secondList[j][0];
        
            if(e1 >= s2 && e2 >= s1){
                res.add(new Integer[] {
                    Math.max(s1,s2),Math.min(e1,e2)
                });
            }

            if(e1 < e2) i++;
            else j++;

        }

        int[][] ans = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            Integer[] item = res.get(k);
            ans[k] = new int[]{item[0], item[1]};
        }

        return ans;



    }
}