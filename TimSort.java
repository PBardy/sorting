public class TimSort {

  private static final int RUN = 32;
  
  public static void printList(int[] list) {
    for(int i = 0; i < list.length; i++) {
      System.out.printf("%d, ", list[i]);
    }
  }

  private void insertionSort(int[] list, int left, int right) {

    for(int i = left + 1; i < right + 1; i++) {
      int temp = list[i];
      int j = i - 1;
      while(j >= left && list[j] > temp) {
        list[j + 1] = list[j];
        j -= 1;
      }
      list[j + 1] = temp;
    }

  }

  private void merge(int[] list, int l, int m, int r) {
    
    int len1 = m - l + 1;
    int len2 = r - m;

    int[] left = new int[len1];
    int[] right = new int[len2];

    for(int i = 0; i < len1; i++) 
      left[i] = list[l + i];

    for(int i = 0; i < len2; i++)
      right[i] = list[m + 1 + i];

    int i = 0;
    int j = 0;
    int k = l;

    while(i < len1 && j < len2) {
      if(left[i] <= right[j]) {
        list[k] = left[i];
        i += 1;
      } else {
        list[k] = right[j];
        j += 1;
      }

      k += 1;
    }

    while(i < len1) {
      list[k] = left[i];
      k += 1;
      j += 1;
    }

    while(j < len2) {
      list[k] = right[j];
      k += 1;
      j += 1;
    }

  }

  public int[] sort(int[] list) {

    int n = list.length;
    int size = TimSort.RUN;

    for(int i = 0; i < n; i += size) {
      insertionSort(list, i, Math.min(i + 31, n - 1));
    }

    while(size < n) {
      for(int left = 0; left < n; left += size * 2) {
        int mid = left + size - 1;
        int right = Math.min(left + 2 * size - 1, n - 1);
        merge(list, left, mid, right);
      }
    }

    return list;
  }

  public static void main(String[] args) {
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    ShellSort sorter = new ShellSort();
    int[] sorted = sorter.sort(list);
    printList(sorted);
  }

}