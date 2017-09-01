

/*


Find maximum average subarray of k length
Given an array with positive and negative numbers, find the maximum average subarray of given length.

Example:

Input:  arr[] = {1, 12, -5, -6, 50, 3}, k = 4
Output: Maximum average subarray of length 4 begins
        at index 1.
Maximum average is (12 - 5 - 6 + 50)/4 = 51/4

 */






import java.util.Scanner;




public class GFGMASLK {

    public GFGMASLK() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        float sum = 0;
        float avg = 0;
        for (int i = 0; i < k; i++) {
            sum += (float) arr[i];
        }
        avg = sum / k;
        int last = 0;

        float max_avg = avg;
        int max_at = Integer.MIN_VALUE;

        for (int i = k; k < n; k++) {
            float delta = (arr[k] - arr[last]) / k;
            avg += delta;

            last++;
            if (avg > max_avg) {
                max_avg = avg;
                max_at = last;
            }
        }

        System.out.println(max_avg);
    }
}
