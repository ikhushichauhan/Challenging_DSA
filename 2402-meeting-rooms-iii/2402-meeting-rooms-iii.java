class Solution {

    public int mostBooked(int n, int[][] meetings) {

        int[] meetingCount = new int[n];
        java.util.PriorityQueue<long[]> usedRooms =
            new java.util.PriorityQueue<>(
                (a, b) -> a[0] == b[0]
                        ? Long.compare(a[1], b[1])
                        : Long.compare(a[0], b[0])
            );
        java.util.PriorityQueue<Integer> unusedRooms =
            new java.util.PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            unusedRooms.add(i);
        }
        java.util.Arrays.sort(meetings,
            (a, b) -> Integer.compare(a[0], b[0])
        );
        for (int[] meeting : meetings) {

            int start = meeting[0];
            int end = meeting[1];

            while (!usedRooms.isEmpty()
                    && usedRooms.peek()[0] <= start) {

                unusedRooms.add((int) usedRooms.poll()[1]);
            }
            if (!unusedRooms.isEmpty()) {

                int room = unusedRooms.poll();
                usedRooms.add(new long[]{end, room});
                meetingCount[room]++;

            } else {

                long[] top = usedRooms.poll();
                long time = top[0];
                int room = (int) top[1];

                usedRooms.add(
                    new long[]{time + end - start, room}
                );
                meetingCount[room]++;
            }
        }
        int max = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > max) {
                max = meetingCount[i];
                ans = i;
            }
        }
        return ans;
    }
}
