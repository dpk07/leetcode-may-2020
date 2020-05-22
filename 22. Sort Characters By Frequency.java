
//doesnt need to balance heap everytime(8ms)
class Solution {
  public String frequencySort(String s) {
    int[] chars = new int[256];
    for (char c : s.toCharArray()) {
      chars[c]++;
    }
    List<Letter> list = new ArrayList<Letter>();
    for (int i = 0; i < 256; i++) {
      if (chars[i] > 0) {
        list.add(new Letter((char) i, chars[i]));
      }
    }
    Collections.sort(list);
    StringBuilder sb = new StringBuilder();
    for (Letter current : list) {
      while (current.count-- > 0) {
        sb.append(current.character);
      }
    }
    return sb.toString();
  }
}

class Letter implements Comparable<Letter> {
  char character;
  int count;

  Letter(char a, int b) {
    character = a;
    count = b;
  }

  public int compareTo(Letter b) {
    if (b.count > this.count) {
      return 1;
    }
    return -1;
  }

}

// removes maximum and balances heap everytime
class Solution {
  public String frequencySort(String s) {
    int[] chars = new int[256];
    for (char c : s.toCharArray()) {
      chars[c]++;
    }
    Queue<letter> pq = new PriorityQueue<letter>();
    for (int i = 0; i < 256; i++) {
      if (chars[i] > 0) {
        pq.add(new letter((char) i, chars[i]));
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      letter current = pq.remove();
      while (current.count-- > 0) {
        sb.append(current.character);
      }
    }
    return sb.toString();
  }
}
