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
    private boolean EOF;
    private int breakpoint;
    private int breakLength;
    private char[] prevRead;

    public Solution() {
        breakpoint = 4;
        breakLength = 4;
        prevRead = new char[4];
        EOF = false;
    }

    public int read(char[] buf, int n) {
        if (EOF || n <= 0)
            return 0;

        int p = 0;
        while (n > 0 && !EOF) {
            if (breakpoint < breakLength) {
                buf[p++] = prevRead[breakpoint++];
                --n;
            } else {
                breakLength = read4(prevRead);
                breakpoint = 0;
                if (breakLength == 0)
                    EOF = true;
            }
        }
        return p;
    }
}
