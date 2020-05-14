class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

class Trie {

  TrieNode head;

  /** Initialize your data structure here. */
  public Trie() {
    head = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode inner = head;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (inner.children[index] == null) {
        inner.children[index] = new TrieNode();
      }
      inner = inner.children[index];
    }
    inner.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if (head == null)
      return false;
    TrieNode inner = head;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (inner.children[index] == null) {
        return false;
      }
      inner = inner.children[index];
    }
    return inner.isEnd;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String word) {
    if (head == null)
      return false;
    TrieNode inner = head;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (inner.children[index] == null) {
        return false;
      }
      inner = inner.children[index];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */