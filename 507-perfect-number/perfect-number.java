class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0, og = num;
        int i = 1;
        while(i<num){
            if(og%i == 0) sum = sum+i;

            i++;

        }

        return sum == num;
    }
}