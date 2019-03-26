package Code.Advanced;

import java.util.*;

/**
 * /**
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

public class FlattenNestedListIterator {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            if(nestedList==null)
                return;
            for(int i=nestedList.size()-1;i>=0;i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public boolean hasNext() {
            return stack.isEmpty()? false:true;
        }
        @Override
        public Integer next() {
            while (!stack.isEmpty()) {
                NestedInteger top = stack.pop();
                if(top.isInteger())
                    return top.getInteger();
                List<NestedInteger> nestedList = top.getList();
                for(int i=nestedList.size()-1;i>=0;i--) {
                    stack.push(nestedList.get(i));
                }
            }
            return null;
        }
    }
}
