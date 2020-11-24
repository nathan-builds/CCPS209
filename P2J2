import java.util.LinkedList;


class P2J2 {

    public static void main(String[] args) {
        //boolean[][] rooks = new boolean[4][4];

    }

    public static String removeDuplicates(String text) {

        char[] answer = new char[text.length()];
        answer[0] = text.charAt(0);
        int j = 0;
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.valueOf(c).equals(answer[j])) {
            } else {
                answer[j + 1] = c;
                j++;
            }
        }
        String finalAnswer = "";
        for (Character c : answer) {
            finalAnswer += Character.toString(c);
        }
        return finalAnswer;

    }

    public static String uniqueCharacters(String text) {

        HashSet<Character> seen = new HashSet();
        String uniqueString = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!seen.contains(c)) {
                seen.add(c);
                uniqueString += Character.toString(c);
            }
        }
        return uniqueString;
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {

        LinkedList<Integer> columns = new LinkedList();
        LinkedList<Integer> rows = new LinkedList();
        int count = 0;

        while (count < n) {
            columns.add(count);
            rows.add(count);
            count += 1;
        }

        for (int i = 0; i < rooks.length; i++) {
            for (int j = 0; j < rooks.length; j++) {
                if (rooks[i][j]) {
                    if (rows.contains(i)) {
                        rows.remove(i);
                    }
                    if (columns.contains(j)) {
                        columns.remove(j);
                    }
                }
            }
        }
        return columns.size() * rows.size();

    }

    public static int recaman(int n) {
        int[] recamanSequence = new int[n * 10];
        boolean[] checkValue = new boolean[10 * n];

        recamanSequence[0] = 0;
        checkValue[0] = true;
        for (int k = 1; k <= n; k++) {
            int negativeValue = recamanSequence[k - 1] - k;
            int positiveValue = recamanSequence[k - 1] + k;
            if ((negativeValue > 0) && (!checkValue[negativeValue])) {
                recamanSequence[k] = negativeValue;
                checkValue[negativeValue] = true;
            } else {
                recamanSequence[k] = positiveValue;
                checkValue[positiveValue] = true;
            }
        }
        return recamanSequence[n];
    }
}
