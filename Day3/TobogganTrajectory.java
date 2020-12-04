import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class TobogganTrajectory {

    public static void main(String[] args) throws Exception {
        File file = new File("./input.txt");
        Scanner sc = new Scanner(file);

        String[] map = new String[0];
        while (sc.hasNextLine())
            map = append(map, sc.nextLine());

        System.out.println(result1(map));
        System.out.println(result2(map));
    }

    static String[] append(String[] arr, String e) {
        String[] narr = new String[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        narr[narr.length-1] = e;
        return narr;
    }

    static int result1(String[] arr) {
        int[] cords = {3, 1};
        int tree = 0;
        for (int s = 0; (cords[1]*s) < arr.length; s++) {
            if (arr[cords[1]*s].charAt((cords[0]*s)%arr[cords[1]*s].length()) == '#') {
                tree++;
            }
        }
        return tree;
    }

    static int result2(String[] arr) {
        int[][] cordsLst = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        int trees = 1;
        for (int[] cords : cordsLst) {
            int tree = 0;
            for (int s = 0; (cords[1]*s) < arr.length; s++) {
                if (arr[cords[1]*s].charAt((cords[0]*s)%arr[cords[1]*s].length()) == '#') {
                    tree++;
                }
            }
            trees *= tree;
        }
        return trees;
    }


}
