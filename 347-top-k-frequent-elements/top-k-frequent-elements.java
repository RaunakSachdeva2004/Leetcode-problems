class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int freq = frequencyMap.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for (int i = buckets.length - 1; i >= 0 && resultIndex < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[resultIndex++] = num;
                    if (resultIndex == k) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}