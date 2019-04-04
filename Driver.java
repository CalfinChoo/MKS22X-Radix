public class Driver {
  public static void main(String[] args) {
    Radix r = new Radix();
    int[] test = {1, 64, -17, 19, 0, -4, -7, 8, 67, 54, -48, 100, 56, 7, -99, 50, 84, -25, -67};
    r.radixsort(test);
    for (int i : test) {
      System.out.println(i);
    }
  }
}
