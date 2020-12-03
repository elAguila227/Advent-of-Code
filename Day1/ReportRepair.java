import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class ReportRepair {

    public static void main(String[] args) throws Exception {
        File file = new File("./input.txt"); 
        Scanner sc = new Scanner(file); 

        int[] repo = new int[0];
        while (sc.hasNextLine()) 
            repo = append(repo, Integer.parseInt(sc.nextLine())); 

        System.out.println(result1(repo));
        System.out.println(result2(repo));
    }

    static int result1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 2020) {
                    return arr[i]*arr[j];
                }
            }
        }
        return -1;
    }

    static int result2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k]== 2020) {
                        return arr[i]*arr[j]*arr[k];
                    }
                }
            }
        }
        return -1;
    }

    static int[] append(int[] arr, int e) {
        int[] narr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        narr[narr.length-1] = e;
        return narr;
    }
}
