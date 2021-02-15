public class StringSolution {

    public int KMPPatternSearch(String text, String pattern) {
        int len1 = text.length(), len2 = pattern.length();
        int[] table = getPrefixTable(pattern);
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            // Printer.print(Integer.toString(i));

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j != len2) {
            return -1;
        }
        return i - len2;

    }

    public int[] getPrefixTable(String pattern) {
        int len = pattern.length();
        int[] prefixTable = new int[len];
        prefixTable[0] = 0; // prefixTable[0] is always 0
        int i = 0, j = 1;
        while (j < len) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                prefixTable[j] = i;
                j++;

            } else {
                if (i == 0) {
                    prefixTable[j] = 0;
                    j++;
                } else {
                    i = prefixTable[i - 1];
                }
            }
        }
        return prefixTable;

    }
}
