/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private Queue<Character> buffer;

    public Solution() {
        buffer = new LinkedList<>();
    }

    public int read(char[] buf, int n) {
        int p = -1;
        char[] enQueueBuff = new char[4];
        while (n > 0) {
            while (!buffer.isEmpty()) {
                buf[++p] = buffer.poll();
                if (--n == 0)
                    break;
            }
            int next = read4(enQueueBuff);
            if (next == 0)
                break;
            for (int j = 0; j < next; ++j)
                buffer.offer(enQueueBuff[j]);
        }
        return p + 1;
    }
}
