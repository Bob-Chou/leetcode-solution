class Solution {
    public String rearrangeString(String s, int k) {
        Scheduler helper = new Scheduler(s.length(), k);
        for (int i = 0; i < s.length(); ++i) {
            helper.offer(s.charAt(i)-'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            helper.ensureHead(i);
            if (helper.peek() > i)
                return "";
            sb.append((char)(helper.poll()+'a'));
        }
        return sb.toString();
    }

    class Scheduler {
        Scheduler(int n, int k) {
            skip = k;
            end = 0;
            value = new int[n][3];
            ref = new int[n];
            Arrays.fill(ref, -1);
        }

        public void offer(int ch) {
            int[] e;
            if (ref[ch] == -1) {
                e = new int[] {0, 1, ch};
                ref[ch] = end;
                value[end++] = e;
            } else {
                e = value[ref[ch]];
                ++e[1];
            }
            bubbleUp(ref[e[2]]);
        }

        public int peek() {
            return value[0][0];
        }

        public int poll() {
            int rtn = value[0][2];
            value[0][0] += skip;
            if (--value[0][1] == 0) {
                swap(0, end-1);
                --end;
            }
            bubbleDown(0);
            return rtn;
        }

        public void ensureHead(int i) {
            while (value[0][0] < i) {
                value[0][0] = i;
                bubbleDown(0);
            }
        }

        private void swap(int i, int j) {
            int[] tmp = value[i];
            value[i] = value[j];
            value[j] = tmp;
            ref[value[i][2]] = i;
            ref[value[j][2]] = j;
        }

        private boolean compare(int i, int j) {
            return value[i][0] < value[j][0] || value[i][0] == value[j][0] && value[i][1] > value[j][1];
        }

        private void bubbleUp(int i) {
            while (i > 0) {
                int j = (i-1) / 2;
                if (compare(i, j))
                    swap(i, j);
                else
                    break;
                i = j;
            }
        }

        private void bubbleDown(int i) {
            while (2*i + 1 < end) {
                int j1 = 2*i + 1;
                int j2 = 2*i + 2;
                int j = j1;
                if (j2 < end && compare(j2, j1))
                    j = j2;
                if (compare(j, i))
                    swap(j, i);
                else
                    break;
                i = j;
            }
        }

        public void print() {
            for (int i = 0; i < end; ++i) {
                System.out.print(String.format("%s {%d, %d}, ", (char)(value[i][2]+'a'), value[i][0], value[i][1]));
            }
            System.out.println();
        }
        private int skip;
        private int end;
        private int[] ref;
        private int[][] value;
    }
}
