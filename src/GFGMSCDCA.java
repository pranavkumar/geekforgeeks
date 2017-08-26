import java.util.Arrays;
import java.util.Scanner;


/*


Maximize sum of consecutive differences in a circular array
Given an array of n elements. Consider array as circular
array i.e element after an is a1.
The task is to find maximum sum of the difference between consecutive elements with rearrangement
of array element allowed i.e after
rearrangement of element find |a1 – a2| + |a2 – a3| + …… + |an – 1 – an| + |an – a1|.
 */
public class GFGMSCDCA {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();

        }

        Arrays.sort(arr);

        int[] fin = new int[n];
        fin[0] = arr[0];
        fin[1] = arr[arr.length - 1];

        int lo = 0;
        int hi = arr.length - 1;
        boolean turn = true;
        int index = 2;

        while (index <= arr.length - 1) {
            if (turn) {
                lo++;
                fin[index] = arr[lo];
            } else {
                hi--;
                fin[index] = arr[hi];
            }
            index++;
            turn = !turn;
        }

        int sum = 0;

        for (int i = 1; i < n; i++) {
            sum += Math.abs(fin[i] - fin[i - 1]);

        }

        sum += Math.abs(fin[fin.length - 1] - fin[0]);

        System.out.print(sum);


    }
}
