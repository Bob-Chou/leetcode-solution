class Solution {
    public String simplifyPath(String path) {
        Stack<Character> pathStack = new Stack<>();
        // to avoid empty error
        pathStack.push('/');
        for (int i = 0; i < path.length(); ++i)
            addPathCharacter(pathStack, path.charAt(i));

        addPathCharacter(pathStack, '/');

        if (pathStack.size() > 1 && pathStack.peek() == '/')
            pathStack.pop();

        int length = pathStack.size();
        char[] pathSimplified = new char[length];
        for (int i = length - 1; i >= 0; --i) {
            pathSimplified[i] = pathStack.pop();
        }

        return String.valueOf(pathSimplified);
    }

    private void addPathCharacter(Stack<Character> pathStack, char s) {
        char top = pathStack.peek();
        if (s == '/') {
            if (top == '.') {
                int dotCount = 0;
                while (top == '.') {
                    ++dotCount;
                    pathStack.pop();
                    top = pathStack.peek();
                }
                if (top != '/' || dotCount > 2) {
                    for (; dotCount > 0; --dotCount)
                        pathStack.push('.');
                } else if (dotCount == 2) {
                    pathStack.pop();
                    while (!pathStack.empty() && pathStack.pop() != '/');
                    pathStack.push('/');
                }
            }
        }

        if (top != '/' || s != '/') {
            pathStack.push(s);
        }
    }
}
