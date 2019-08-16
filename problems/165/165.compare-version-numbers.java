class Solution {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        version1 = "." + version1;
        version2 = "." + version2;
        while (p1 < version1.length() && p2 < version2.length()) {
            char v1 = version1.charAt(p1);
            char v2 = version2.charAt(p2);
            if (v1 == v2) {
                do {
                    ++p1;
                } while (v1 == '.' && p1 < version1.length() && version1.charAt(p1) == '0');
                do {
                    ++p2;
                } while (v2 == '.' && p2 < version2.length() && version2.charAt(p2) == '0');
            } else if (v1 == '.') {
                return -1;
            } else if (v2 == '.') {
                return 1;
            } else if (p1 + 1 < version1.length() && version1.charAt(p1+1) != '.') {
                return 1;
            } else if (p2 + 1 < version2.length() && version2.charAt(p2+1) != '.') {
                return -1;
            } else {
                return v1 > v2 ? 1 : -1;
            }
        }
        if (p1 < version1.length() && version1.charAt(p1) != '.')
            return 1;
        if (p2 < version2.length() && version2.charAt(p2) != '.')
            return -1;
        while (p1 < version1.length()) {
            if (version1.charAt(p1) != '.' && version1.charAt(p1) != '0')
                return 1;
            ++p1;
        }
        while (p2 < version2.length()) {
            if (version2.charAt(p2) != '.' && version2.charAt(p2) != '0')
                return -1;
            ++p2;
        }
        return 0;
    }
}
