class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return build(bottom, map);
    }

    private boolean build(String row, Map<String, List<Character>> map) {
        if (row.length() == 1) return true;
        return nextRow(row, 0, new StringBuilder(), map);
    }

    private boolean nextRow(String row, int idx, StringBuilder sb, Map<String, List<Character>> map) {
        if (idx == row.length() - 1) {
            return build(sb.toString(), map);
        }

        String key = row.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;

        for (char c : map.get(key)) {
            sb.append(c);
            if (nextRow(row, idx + 1, sb, map)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }
}