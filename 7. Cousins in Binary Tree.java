//Tree level based solution(best time and space)

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Level {
  TreeNode parent;
  int level;

  public Level(TreeNode t, int l) {
    parent = t;
    level = l;
  }
}

class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    Level xLevel = level(root, x, 0);
    Level yLevel = level(root, y, 0);
    if (xLevel != null && yLevel != null) {
      if (xLevel.level != yLevel.level)
        return false;
      else
        return (xLevel.parent.val != yLevel.parent.val);
    }
    return false;
  }

  public Level level(TreeNode root, int x, int level) {
    if (root.val == x)
      return new Level(null, level);
    if (root.left != null) {
      if (root.left.val == x) {
        return new Level(root, level + 1);
      } else {
        Level left = level(root.left, x, level + 1);
        if (left != null)
          return left;
      }
    }
    if (root.right != null) {
      if (root.right.val == x) {
        return new Level(root, level + 1);
      } else {
        Level right = level(root.right, x, level + 1);
        if (right != null)
          return right;
      }
    }
    return null;
  }
}

// HashMap based solution
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    queue.add(new TreeNode(-1));
    boolean flag = false;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();
      if (current.val == -1) {
        if (flag)
          return false;
        if (!queue.isEmpty())
          queue.add(new TreeNode(-1));
        hm = new HashMap<Integer, Integer>();
      } else {
        if (current.left != null) {
          if (current.left.val == x) {
            flag = true;
            if (hm.containsKey(y)) {
              if (current.val != hm.get(y)) {
                return true;
              }
            }
          }
          if (current.left.val == y) {
            flag = true;
            if (hm.containsKey(x)) {
              if (current.val != hm.get(x)) {
                return true;
              }
            }
          }
          hm.put(current.left.val, current.val);
          queue.add(current.left);
        }
        if (current.right != null) {
          if (current.right.val == x) {
            flag = true;
            if (hm.containsKey(y)) {
              if (current.val != hm.get(y)) {
                return true;
              }
            }
          }
          if (current.right.val == y) {
            flag = true;
            if (hm.containsKey(x)) {
              if (current.val != hm.get(x)) {
                return true;
              }
            }
          }
          hm.put(current.right.val, current.val);
          queue.add(current.right);
        }
      }
    }
    return false;
  }
}

// HashSet based solution

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    queue.add(new TreeNode(-1));
    boolean flag = false;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();
      if (current.val == -1) {
        if (flag)
          return false;
        if (!queue.isEmpty())
          queue.add(new TreeNode(-1));
        hm = new HashMap<Integer, Integer>();
      } else {
        if (current.left != null) {
          if (current.left.val == x) {
            flag = true;
            if (hm.containsKey(y)) {
              if (current.val != hm.get(y)) {
                return true;
              }
            }
          }
          if (current.left.val == y) {
            flag = true;
            if (hm.containsKey(x)) {
              if (current.val != hm.get(x)) {
                return true;
              }
            }
          }
          hm.put(current.left.val, current.val);
          queue.add(current.left);
        }
        if (current.right != null) {
          if (current.right.val == x) {
            flag = true;
            if (hm.containsKey(y)) {
              if (current.val != hm.get(y)) {
                return true;
              }
            }
          }
          if (current.right.val == y) {
            flag = true;
            if (hm.containsKey(x)) {
              if (current.val != hm.get(x)) {
                return true;
              }
            }
          }
          hm.put(current.right.val, current.val);
          queue.add(current.right);
        }
      }
    }
    return false;
  }
}
