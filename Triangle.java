import java.util.List;

public class Triangle {
    /**
     Time complexity - o(mXn), where m - Length of triangle and n is kength of each list inside triangle
     Space complexity - 0(1) - we modified the same list and did not use another array
     Approach - we start from the last but one rwo. traversing left to right,
     for each element j at i, check the min of i+1(j+1, j) and add the min to element at j
     finally we will have the answet at the top of triangle, which is list 0 and elemtn 0.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int m = triangle.size();
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j,
                        triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
