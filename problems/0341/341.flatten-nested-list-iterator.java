/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        items = nestedList;
        ptr = 0;
        dirty = true;
        ptrStack = new Stack<>();
        itemStack = new Stack<>();
    }

    @Override
    public Integer next() {
        if (dirty)
            update();
        Integer rtn = null;
        if (ptr < items.size()) {
            rtn = items.get(ptr).getInteger();
            ++ptr;
            dirty = true;
        }
        return rtn;
    }

    @Override
    public boolean hasNext() {
        if (dirty)
            update();
        return ptr < items.size();
    }

    private void update() {
        while (true) {
            // set pointer to next integer, or overflows
            while (ptr < items.size() && !check(items, ptr)) {
                // if point to null integer, move forward
                if (empty(items, ptr)) {
                    ++ptr;
                    continue;
                }
                // if point to a list
                List<NestedInteger> nextItems = items.get(ptr).getList();
                ptrStack.push(ptr+1);
                itemStack.push(items);
                ptr = 0;
                items = nextItems;
            }

            if (ptr < items.size() && check(items, ptr) || ptrStack.empty())
                break;

            ptr = ptrStack.pop();
            items = itemStack.pop();
        }
        dirty = false;
    }

    private boolean check(List<NestedInteger> l, int p) {
        if (l == null)
            return false;
        NestedInteger n = l.get(p);
        return n != null && n.isInteger() && n.getInteger() != null;
    }

    private boolean empty(List<NestedInteger> l, int p) {
        if (l == null)
            return true;
        NestedInteger n = l.get(p);
        return n == null || n.getInteger() == null && n.getList() == null || !n.isInteger() && n.getList().size() == 0;
    }

    private int ptr;
    private boolean dirty;
    private List<NestedInteger> items;
    private Stack<Integer> ptrStack;
    private Stack<List<NestedInteger>> itemStack;
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
