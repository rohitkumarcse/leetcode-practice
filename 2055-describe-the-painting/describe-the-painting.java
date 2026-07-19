class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        int n = segments.length;

        for (int i = 0; i < n; i++) {
            int st = segments[i][0];
            int ed = segments[i][1];
            int val = segments[i][2];

            map.put(st, map.getOrDefault(st, 0L) + val);
            map.put(ed, map.getOrDefault(ed, 0L) - val);
        }

        Integer[] vals = map.keySet().toArray(new Integer[0]);

        int st = vals[0];
        Long sum = map.get(st);

        List<List<Long>> ans = new ArrayList<>();

        for (int i = 1; i < vals.length; i++) {
            List<Long> list = new ArrayList<>();
            if(sum >0 ){
            list.add((long) st);
            list.add((long) vals[i]);
            list.add(sum);

            ans.add(list);
            }

            st = vals[i];
            sum += map.get(vals[i]);
        }

        return ans;
    }
}