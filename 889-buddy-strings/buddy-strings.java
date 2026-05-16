class Solution {

    public boolean checkFreq(String s) {

        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {

            arr[ch - 'a']++;

            if (arr[ch - 'a'] > 1)
                return true;
        }

        return false;
    }


    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())  return false;

        if(s.equals(goal)) return checkFreq(s);

        ArrayList<Integer> index = new ArrayList<>();

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) != goal.charAt(i))  index.add(i);
        }

        if(index.size() != 2) return false;

        char[] arr = s.toCharArray();

        char temp = arr[index.get(0)];
        arr[index.get(0)] = arr[index.get(1)];
        arr[index.get(1)] = temp;

        return new String(arr).equals(goal); 
    }
}