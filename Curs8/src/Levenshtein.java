public class Levenshtein {

    static int lev(String a, String b) {
        if (a.equals(b))
            return 0;

        if (a.length() == 0)
            return b.length();
        if (b.length() == 0)
            return a.length();

        final int NMAX = 1024;

        int[][] DP = new int[NMAX][NMAX];

        DP[0][0] = 0;
        for (int i = 1; i <= a.length(); i++) {
            DP[i][0] = DP[i - 1][0] + 1;
        }

        for(int j = 1; j <= b.length(); j++){
            DP[0][j] = DP[0][j - 1] + 1;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1];
                } else {
                    DP[i][j] = 1 + Math.min(Math.min(DP[i - 1][j - 1], DP[i - 1][j]), DP[i][j - 1]);
                }
            }
        }


        return DP[a.length()][b.length()];
    }

    public static void main(String[] args){
        System.out.println(lev("HONDA", "HYUNDAI"));
    }
}
