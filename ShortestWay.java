//Time Complexity : n log k
//Space Complexity : O(m)
class ShortestWay {
    public int shortestWay(String source, String target) {
        int result = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < source.length(); i++) {
            if(!map.containsKey(source.charAt(i))) {
                map.put(source.charAt(i), new ArrayList<>());
            }
            map.get(source.charAt(i)).add(i);
        }

        int targetPtr = 0, sourcePtr = 0;
        while(targetPtr < target.length()) {
            char tChar = target.charAt(targetPtr);
            if(!map.containsKey(tChar)) return -1;
            List<Integer> li = map.get(tChar);
            int k = Collections.binarySearch(li, sourcePtr);
            if(k < 0) {
                k = -k-1;
            }
            if(k == li.size()) {
                sourcePtr = li.get(0);
                result++;
            } else {
                sourcePtr = li.get(k);
            }
            sourcePtr++;
            targetPtr++;
            if(targetPtr == target.length()) {
                return result+1;
            }
        }
        return -1;
    }
}