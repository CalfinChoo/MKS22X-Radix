public class Radix {
  public static void radixsort(int[]data){
    int fill = findMax(data);
    int count = 0;
    while (fill > 0) {
      MyLinkedList[] bucket = new MyLinkedList[20];
      for (int i = 0; i < data.length; i++) {
        if (data[i] < 0) {
          int digit = data[i] % Math.pow(10, count);
          bucket[]
        }

      }
    }
  }
  public int findMax(int[] data) {
    int max = 1;
    for (int i = 1; i < data.length; i++) {
      int count = 0;
      while (data[i] / Math.pow(10, count) >= 1) {
        if (max < count) max = 1 + count;
      }
    }
    return max;
  }
}
