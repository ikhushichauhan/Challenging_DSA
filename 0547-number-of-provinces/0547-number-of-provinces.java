class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int city = q.poll();

                    for (int j = 0; j < n; j++) {
                        if (isConnected[city][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }

        return provinces;
    }
}
