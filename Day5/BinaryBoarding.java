import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;
class BinaryBoarding {

    public static void main(String[] args) throws Exception {
        File file = new File("./input.txt");
        Scanner sc = new Scanner(file);

        int[] bin = new int[0];
        while (sc.hasNextLine())
            bin = append(bin, Integer.parseInt(sc.nextLine().replace('F', '0').replace('B', '1').replace('R', '1').replace('L', '0'), 2));

        System.out.println(result1(bin));
        System.out.println(result2(bin));
    }

    static int[] append(int[] arr, int e) {
        int[] narr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        narr[narr.length-1] = e;
        return narr;
    }

    static int result1(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    static int result2(int[] arr) {
        Arrays.sort(arr);
        int max = (arr[arr.length-1]*(arr[arr.length-1]+1))/2;
        int min = ((arr[0]-1)*(arr[0]))/2;
        int res = max - min;
        for (int i : arr) {
            res-= i;
        }
        return res;
    }
}
