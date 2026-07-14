class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String dig = "123456789";
        List<Integer> res = new ArrayList<>();

        int lowlen = String.valueOf(low).length();
        int highlen = String.valueOf(high).length();

        for(int len = lowlen; len <= highlen; len++){
            for(int st = 0; st+len<=9; st++){
                int num = Integer.parseInt(dig.substring(st,st + len));
                if(num >= low && num <= high)
                    res.add(num);
            }

        }

        return res;
    }
}