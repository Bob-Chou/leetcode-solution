class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length <= 1)
            return logs;

        List<String> digs = new ArrayList<>();
        List<String> lets = new ArrayList<>();
        for (String s : logs) {
            int p = 0;
            while (s.charAt(p++) != ' ');
            if (s.charAt(p) <= '9' && s.charAt(p) >= '0') digs.add(s);
            else lets.add(s);
        }

        Comparator<String> letComparator = new Comparator<String> () {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == 0)
                    return -1;
                if (s2.length() == 0)
                    return 1;

                int p1 = 0, p2 = 0;
                int id1 = 0, id2 = 0;
                while (s1.charAt(p1++) != ' ');
                id1 = p1;
                while (s2.charAt(p2++) != ' ');
                id2 = p1;

                while (p1 < s1.length() && p2 < s2.length()) {
                    if (s1.charAt(p1) == ' ' && s2.charAt(p2) == ' ') {
                        ++p1;
                        ++p2;
                    }

                    if (s1.charAt(p1) == ' ' || s1.charAt(p1) < s2.charAt(p2)) {
                        return -1;
                    } else if (s2.charAt(p2) == ' '  || s1.charAt(p1) > s2.charAt(p2)) {
                        return 1;
                    } else {
                        ++p1;
                        ++p2;
                    }
                }

                if (p1 < s1.length())
                    return 1;

                if (p2 < s1.length())
                    return -1;
                // ties
                return s1.substring(0, id1).compareTo(s2.substring(0, id2));
            }
        };

        Collections.sort(lets, letComparator);
        lets.addAll(digs);

        String[] ans = new String[lets.size()];
        for (int i = 0; i < ans.length; ++i)
            ans[i] = lets.get(i);

        return ans;
    }
}
