class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];

        for(char ch : sentence.toCharArray()){
            int index = ch-'a';
            arr[index]++;
        }

        for(int count : arr){
            if(count == 0)  return false;
           
        }
        return true;
    }
}