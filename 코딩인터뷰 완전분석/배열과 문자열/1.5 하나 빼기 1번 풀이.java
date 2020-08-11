public class exam05_01 {
    static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean oneEditInsert(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < str2.length() && index1 < str1.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "ple";
        System.out.println(oneEditAway(str1, str2));
    }
}
