import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class PasswordPhilosophy {

    public static void main(String[] args) throws Exception {
        File file = new File("./input.txt"); 
        Scanner sc = new Scanner(file); 

        String[][] passLst = new String[0][];
        while (sc.hasNextLine()) 
            passLst = append(passLst, sc.nextLine().split(": ")); 

        System.out.println(result1(passLst));
        System.out.println(result2(passLst));
    }

    static int result1(String[][] arr) {
        int valid = 0;
        for (String[] e : arr) {
            char let = e[0].charAt(e[0].length()-1);
            int min = Integer.parseInt(e[0].substring(0, e[0].indexOf('-')));
            int max = Integer.parseInt(e[0].substring(e[0].indexOf('-')+1, e[0].indexOf(' ')));
            int find = 0;
            for (int i = 0; i < e[1].length(); i++) {
                if (e[1].charAt(i) == let) {
                    find++;
                }
            } if (min <= find && find <= max) {
                valid++;
            }
        }
        return valid;
    }

    static int result2(String[][] arr) {
        int valid = 0;
        for (String[] e : arr) {
            char let = e[0].charAt(e[0].length()-1);
            int index1 = Integer.parseInt(e[0].substring(0, e[0].indexOf('-')))-1;
            int index2 = Integer.parseInt(e[0].substring(e[0].indexOf('-')+1, e[0].indexOf(' ')))-1;
            if ((e[1].charAt(index1) == let || e[1].charAt(index2) == let) && !(e[1].charAt(index1) == let && e[1].charAt(index2) == let)) {
                valid++;
            }
        }
        return valid;
    }

    static String[][] append(String[][] arr, String[] e) {
        String[][] narr = new String[arr.length+1][];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        narr[narr.length-1] = e;
        return narr;
    }
}
