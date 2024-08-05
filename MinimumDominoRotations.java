//Time Complexity : O(2n) ~ O(n)
//Space Complexity : O(n)
class MinimumDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = tops.length;
        int target = -1;

        for(int i = 0; i < len; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
            if(map.get(tops[i]) >= len) {
                target = tops[i];
                break;
            }
        }
        for(int i = 0; i < len; i++) {
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);
            if(map.get(bottoms[i]) >= len) {
                target = bottoms[i];
                break;
            }
        }
        if(target == -1) return -1;
        int topRot = 0, botRot = 0;
        for(int i = 0; i < len; i++) {
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) topRot++;
            if(bottoms[i] != target) botRot++;
        }
        return Math.min(topRot, botRot);

    }
}