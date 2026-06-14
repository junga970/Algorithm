class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int lcm = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            lcm = lcm(lcm, cycle);
        }

        for (int t = 1; t <= lcm; t++) {
            boolean ok = true;
            for (int[] s : signals) {
                int g = s[0], y = s[1], r = s[2];
                int cycle = g + y + r;
                int pos = (t - 1) % cycle;
                if (!(pos >= g && pos < g + y)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return t;
        }
        return -1;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}