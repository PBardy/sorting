public class RadixSort {
  
  public static void printList(int[] list) {
    for(int i = 0; i < list.length; i++) {
      System.out.printf("%d, ", list[i]);
    }
  }

  private int getMax(int[] list) {
    int maximum = list[0];
    for(int i = 1; i < list.length; i++) {
      if(list[i] > maximum) {
        maximum = list[i];
      }
    }

    return maximum;
  }

  private void countingSort(int[] list, int n, int exp) {
    
    int count[] = new int[10];
    int output[] = new int[n];
    
    for(int i = 0; i < count.length; i++) {
      count[i] = 0;
    }

    for(int i = 0; i < n; i++) {
      count[(list[i] / exp) % 10]++;
    }

    for(int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for(int i = n - 1; i >= 0; i--) {
      output[count[(list[i] / exp) % 10] - 1] = list[i];
      count[(list[i] / exp) % 10]--;
    }

    for(int i = 0; i < n; i++) {
      list[i] = output[i];
    }

  }

  public int[] sort(int[] list) {

    int m = getMax(list);
    int n = list.length;

    for(int exp = 1; m / exp > 0; exp *= 10) {
      countingSort(list, n, exp);
    }

    return list;
  }

  public static void main(String[] args) {
    RadixSort sorter = new RadixSort();
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    int[] sorted = sorter.sort(list);
    printList(sorted);
  }

}