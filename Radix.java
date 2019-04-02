public class Radix {
  public static void radixsort(int[]data){
    int fill = findMax(data) - 1;
    int count = 0;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> merged = new MyLinkedList();
    for (int i = 0; i < data.length; i++) {
      if (data[i] / Math.pow(10, count) < 1) int digit = 0;
      else int digit = data[i] / Math.pow(10, count);
      if (data[i] < 0) {
        buckets[9 - digit].add(data[i]);
      }
      else {
        buckets[digit + 10].add(data[i]);
      }
    }
    int index = 0;
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i].size() > 0) merged.extend(buckets[i]);
    }
    count++;

    return data;
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
