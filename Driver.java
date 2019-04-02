public class Driver {
  public static void main(String[] args) {
    Radix r = new Radix();
    int[] test = {1, 64, -17, 19, 0, -4, -7, 8, 67, 54, -48};
    r.radixsort(test);
    for (int i : test) {
      System.out.println(i);
    }
  }
}
