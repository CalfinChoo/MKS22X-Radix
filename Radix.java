public class Radix {
  public static void radixsort(int[]data){
    int fill = findMax(data) - 1;
    int count = 0;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> merged = new MyLinkedList();
    for (int i = 0; i < buckets.length; i++) buckets[i] = new MyLinkedList();
    for (int i : data) {
      System.out.println("Hi");
      int digit = Math.abs((int)(i/Math.pow(10, count)) % 10);
      System.out.println(digit + "");
      if (i < 0) {
        buckets[9 - digit].add(i);
      }
      else {
        buckets[digit + 10].add(i);
      }
    }
    for (MyLinkedList i : buckets) {
      if (i.size() > 0) merged.extend(i);
      i.clear();
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
      for (MyLinkedList i : buckets) {
        if (i.size() > 0) merged.extend(i);
        i.clear();
      }
      count++;
      fill--;
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
