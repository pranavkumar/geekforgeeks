import java.util.Scanner;


/*
median of two sorted arrays
 */

public class GFGMOSA {

    public GFGMOSA() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr_n = new int[n];
        int[] arr_k = new int[k];
        for (int i = 0; i < n; i++) {
            arr_n[i] = in.nextInt();
        }

        for (int i = 0; i < k; i++) {
            arr_k[i] = in.nextInt();
        }


        boolean isOdd = (n + k) % 2 != 0;


        int index = 0;
        int index_n = 0;
        int index_k = 0;

        int[] arr_nk = new int[n + k];
        int med1 = (n + k) / 2;
        int med2 = ((n + k) / 2) - 1;
        int last = Integer.MIN_VALUE;
        int last_last = Integer.MIN_VALUE;

        while (index < n + k) {
            if (index_n == n && index_k < k) {
                for (int j = index_k; j < k; j++) {
                    arr_nk[index] = arr_k[j];
                    index++;
                    if (index == med1 + 1) {
                        last = arr_nk[index - 1];
                    }
                    if (index == med2 + 1) {
                        last_last = arr_nk[index - 1];
                    }
                    if (last != Integer.MIN_VALUE && last_last != Integer.MIN_VALUE) {
                        if (isOdd) {
                            System.out.println(last);
                        } else {
                            System.out.println(((float) last + (float) last_last) / 2);
                        }
                        return;
                    }
                }
                break;
            }
            if (index_k == k && index_n < n) {
                for (int j = index_n; j < n; j++) {
                    arr_nk[index] = arr_n[j];
                    index++;
                    if (index == med1 + 1) {
                        last = arr_nk[index - 1];
                    }
                    if (index == med2 + 1) {
                        last_last = arr_nk[index - 1];
                    }
                    if (last != Integer.MIN_VALUE && last_last != Integer.MIN_VALUE) {
                        if (isOdd) {
                            System.out.println(last);
                        } else {
                            System.out.println(((float) last + (float) last_last) / 2);
                        }
                        return;
                    }
                }
                break;
            }
            if (arr_n[index_n] <= arr_k[index_k]) {
                arr_nk[index] = arr_n[index_n];
                index_n++;
            } else {
                arr_nk[index] = arr_k[index_k];
                index_k++;
            }
            index++;
            if (index == med1 + 1) {
                last = arr_nk[index - 1];
            }
            if (index == med2 + 1) {
                last_last = arr_nk[index - 1];
            }
            if (last != Integer.MIN_VALUE && last_last != Integer.MIN_VALUE) {
                if (isOdd) {
                    System.out.println(last);
                } else {
                    System.out.println(((float) last + (float) last_last) / 2);
                }
                return;
            }
        }
    }
}
