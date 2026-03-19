class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                if (Math.abs(a) > st.peek()) {
                    st.pop();                      
                } else if (Math.abs(a) == st.peek()) {
                    st.pop();                      
                    alive = false;
                    break;
                } else {
                    alive = false;              
                    break;
                }
            }

            if (alive) st.push(a);
        }

        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        return result;
    }
}