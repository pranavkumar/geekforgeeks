
/*
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.

Example

Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3}
 */

import java.util.Scanner;

public class GFGSOE {

    public GFGSOE() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int lo = 0;
        int hi = n - 1;


        while (lo < hi) {
            if (arr[lo] % 2 != 0) {
                int start = lo;
                int end = lo;
                while (end < hi) {
                    if (arr[end + 1] % 2 != 0) {
                        end++;
                    } else {
                        break;
                    }
                }
                if (start == end) {
                    int temp = arr[start + 1];
                    arr[start + 1] = arr[start];
                    arr[start] = temp;
                } else {
                    if (end == hi) {
                        break;
                    }
                    int temp = arr[end + 1];
                    for (int i = end + 1; i > start; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[start] = temp;
                }
                lo++;
            } else {
                lo++;
            }


        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
