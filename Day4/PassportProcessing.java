import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;

class PassportProcessing {

    public static void main(String[] args) throws Exception {
        File file = new File("./input.txt");
        Scanner sc = new Scanner(file);

        String[][] passports = new String[0][];
        String[] passport = new String[0];
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() > 0) {
                passport = append(passport, line.split(" "));
            } else {
                passports = append(passports, passport);
                passport = new String[0];
            }
        }
        if (passport.length > 0) {
                passports = append(passports, passport);
        }

        System.out.println(result1(passports));
        // System.out.println(result2(passports));
    }

    static String[][] append(String[][] arr, String[] e) {
        String[][] narr = new String[arr.length+1][];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        narr[narr.length-1] = e;
        return narr;
    }

    static String[] append(String[] arr, String[] e) {
        String[] narr = new String[arr.length+e.length];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        for (int i = 0; i < e.length; i++) {
            narr[arr.length+i] = e[i];
        }
        return narr;
    }

    static int result1(String[][] arr) {
        int valid = 0;
        for (String[] e : arr) {
            int req = 0;
            boolean v = true;
            for (String p : e) {
                if (v) {
                    if (p.substring(0, p.indexOf(':')).equals("cid")) {
                        req++;
                    } else if (p.substring(0, p.indexOf(':')).equals("byr")) {
                        v = (1920 <= Integer.parseInt(p.substring(p.indexOf(':')+1, p.length())) && Integer.parseInt(p.substring(p.indexOf(':')+1, p.length())) <= 2002);
                    } else if (p.substring(0, p.indexOf(':')).equals("iyr")) {
                        v = (2010 <= Integer.parseInt(p.substring(p.indexOf(':')+1, p.length())) && Integer.parseInt(p.substring(p.indexOf(':')+1, p.length())) <= 2020);
                    } else if (p.substring(0, p.indexOf(':')).equals("eyr")) {
                        v = (2020 <= Integer.parseInt(p.substring(p.indexOf(':')+1, p.length())) && Integer.parseInt(p.substring(p.indexOf(':')+1, p.length())) <= 2030);
                    } else if (p.substring(0, p.indexOf(':')).equals("hgt")) {
                        if (p.substring(p.length()-2, p.length()).equals("cm")) {
                            v = (150 <= Integer.parseInt(p.substring(p.indexOf(':')+1, p.length()-2)) && Integer.parseInt(p.substring(p.indexOf(':')+1, p.length()-2)) <= 193);
                        } else if (p.substring(p.length()-2, p.length()).equals("in")) {
                            v = (59 <= Integer.parseInt(p.substring(p.indexOf(':')+1, p.length()-2)) && Integer.parseInt(p.substring(p.indexOf(':')+1, p.length()-2)) <= 76);
                        } else {
                            v = false;
                        }
                    } else if (p.substring(0, p.indexOf(':')).equals("hcl")) {
                        try {
                            Integer.decode(p.substring(p.indexOf(':')+1, p.length()));
                        } catch (NumberFormatException x) {
                            v = false;
                        }
                    } else if (p.substring(0, p.indexOf(':')).equals("ecl")) {
                        v = false;
                        String[] colors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                        for (String c : colors) {
                            if (p.substring(p.indexOf(':')+1, p.length()).equals(c)) {
                                v = true;
                            }
                        }
                    } else if (p.substring(0, p.indexOf(':')).equals("pid")) {
                        if (p.substring(p.indexOf(':')+1, p.length()).length() == 9) {
                            try {
                                Integer.parseInt(p.substring(p.indexOf(':')+1, p.length()));
                            } catch (NumberFormatException x) {
                                v = false;
                            }
                        } else {
                            v = false;
                        }
                    }
                }
            }
            valid += (e.length-req == 7 && v) ? 1 : 0;
        }
        return valid;
    }
}
