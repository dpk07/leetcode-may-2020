class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image.length == 0)
      return image;
    floodFill(image, sr, sc, newColor, image[sr][sc]);
    return image;
  }

  public void floodFill(int[][] image, int sr, int sc, int newColor, int startColor) {
    if (image[sr][sc] != startColor)
      return;
    if (image[sr][sc] == newColor)
      return;
    image[sr][sc] = newColor;
    if (sc > 0)
      floodFill(image, sr, sc - 1, newColor, startColor);
    if (sr > 0)
      floodFill(image, sr - 1, sc, newColor, startColor);
    if (sc < image[0].length - 1)
      floodFill(image, sr, sc + 1, newColor, startColor);
    if (sr < image.length - 1)
      floodFill(image, sr + 1, sc, newColor, startColor);

  }
}