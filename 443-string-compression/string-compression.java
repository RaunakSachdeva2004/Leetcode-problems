class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0, i = 0;

        while( i < n){
            char curr = chars[i];
            int count = 0;

            // counting duplicates
            while( i <n && chars[i] == curr){
                count++;
                i++;
            }

            // Assign character
            chars[index] = curr;
            index++;

            if(count > 1){
                String count_str = Integer.toString(count);

                for (char ch : count_str.toCharArray()) {
                    chars[index] = ch;
                    index++;
                } 

            }
        }

        return index;


    }
}