
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // If numRows is 0, return an empty triangle.
        if (numRows == 0) {
            return triangle;
        }

        // Add the first row (always [1]).
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // Generate subsequent rows.
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // The first element of each row is always 1.
            currentRow.add(1);

            // Each middle element is the sum of the two elements above it.
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element of each row is always 1.
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}