public class Radix {
  public static void radixsort(int[]data){
    int fill = findMax(data) - 1;
    int count = 0;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    for (int i = 0; i < buckets.length; i++) buckets[i] = new MyLinkedList<Integer>();
    for (int i : data) {
      int digit = Math.abs((int)(i/Math.pow(10, count)) % 10);
      if (i < 0) {
        buckets[9 - digit].add(i);
      }
      else {
        buckets[digit + 10].add(i);
      }
    }
    for (MyLinkedList<Integer> i : buckets) {
      merged.extend(i);
    }
    count++;
    while (fill > 0) {
      while (merged.size() > 0) {
        int i = merged.removeFront();
        int digit = Math.abs((int)(i/Math.pow(10, count)) % 10);
        if (i < 0) {
          buckets[9 - digit].add(i);
        }
        else {
          buckets[digit + 10].add(i);
        }
      }
      for (MyLinkedList<Integer> i : buckets) {
        merged.extend(i);
      }
      count++;
      fill--;
    }
    for (int i = 0; i < data.length; i++) {
      data[i] = merged.removeFront();
    }
  }
  public static int findMax(int[] data) {
    int max = 1;
    for (int i = 1; i < data.length; i++) {
      int count = 0;
      while (data[i] / Math.pow(10, count) >= 1) {
        count++;
      }
      if (max < count) max = count;
    }
    return max;
  }
}
