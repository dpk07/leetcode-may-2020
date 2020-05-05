class Solution {
  public int firstUniqChar(String s) {
    // Using Linked Hash Map as it preserves the order and it will give us the first
    // occuring non repeating character
    Map<Character, Node> hs = new LinkedHashMap<Character, Node>();
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (hs.containsKey(current)) {
        Node count = hs.get(current);
        count.index = i;
        count.count++;
        hs.put(current, count);
      } else {
        hs.put(current, new Node(1, i));
      }
    }
    if (!hs.isEmpty()) {
      for (Map.Entry<Character, Node> entry : hs.entrySet()) {
        if (entry.getValue().count == 1) {
          return entry.getValue().index;
        }
      }
    }
    return -1;

  }
}

// Storing the index with the count to avoid iterating through the string again.
class Node {
  int count;
  int index;

  public Node(int a, int b) {
    count = a;
    index = b;
  }
}