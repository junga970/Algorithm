class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int maxTime = attacks[attacks.length-1][0];

        int beforeTime = 0;
        int bandageTime = 0;
        for (int[] attack : attacks) {
            bandageTime = attack[0] - beforeTime - 1;
            health = Math.min(maxHealth, health + (bandage[1] * bandageTime));
            if (bandageTime / bandage[0] > 0) {
                health = Math.min(maxHealth, health + bandage[2] * (bandageTime / bandage[0]));
            }

            health -= attack[1];
            beforeTime = attack[0];
            if (health <= 0) return -1;
        }

        return health;
    }
}