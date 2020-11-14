// count map

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        
        // convert result
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
        
    }
}
