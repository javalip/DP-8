public class ArithmeticSlice {

    public int numberOfArithmeticSlicesDP(int[] nums) {
        /**
         tc - o(n)
         sc - o(1)
         dynamic programming. optimizing on space by taking prev variable and not using dp array
         start from i=2(position 3).
         mintain int prev.
         if(nums[i-1] - nums[i-2] == nums[i]-nums[i-1]){
         prev = prev+1;
         count = count+prev;
         else
         prev =0;
         return count;

         (start from the back of array from third position bcos subarray length mentioned is 3 here.)
         if the differance between i+2 and i+1 is same as i and i+1 elements,
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int prev =0;
        int count =0;
        for(int i=2; i<n; i++){
            if(nums[i-1] - nums[i-2] == nums[i]-nums[i-1]){
                prev = prev+1;
                count = count+prev;
            }else{
                prev=0;
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        /**
         tc - o(n)
         sc - o)n)
         dynamic programming.
         start from the back of array from third position bcos subarray length mentioned is 3 here.
         if the differance between i+2 and i+1 is same as i and i+1 elements, fill dp[1] with 1+dp[i+1].
         because the i+1 place in dp array contains the solution to prev
         sun problem and this way we are optimizing on time

         Same problem can be done starying from i=2 which is from the begining aswell.
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[]dp = new int[n];
        int count =0;
        for(int i=n-3; i>=0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1]-nums[i]){
                dp[i] = dp[i+1] +1;
                count = count+dp[i];
            }
        }
        return count;
    }

    //Brute force
    public int numberOfArithmeticSlicesBF(int[] nums) {
        /**
         tc = o(n2)
         sc = o(1)
         approach - brute force.
         take two variables i and j.
         - calculate diff between i and i+1
         place j as i+1. if diff between j and j+1 = diff then increament the count.
         same thing continues until all j+1 diff is same as the diff.
         when diff between j and j+1 is not same as the diff,
         it breaks out of inner loop and starts all over again for new value of i.
         at the end return count
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j + 1] - nums[j] == diff) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
