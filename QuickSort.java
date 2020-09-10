public class QuickSort {

  public static void printList(int[] list) {
    for(int i = 0; i < list.length; i++) {
      System.out.printf("%d, ", list[i]);
    }
  }

  private void swap(int[] list, int a, int b) {
    int temp1 = list[a];
    int temp2 = list[b];
    list[b] = temp1;
    list[a] = temp2;
  }

  private int partition(int[] list, int low, int high) {

    int pivot = list[high];
    int i = low;

    for(int j = low; j < high; j++) {
      if(list[j] < pivot) {
        swap(list, i, j);
        i = i + 1;
      }
    }
    swap(list, i, high);

    return i;
  }
  
  public int[] sort(int[] list, int low, int high) {

    if(low < high) {
      int p = partition(list, low, high);
      sort(list, low, p - 1);
      sort(list, p + 1, high);
    }

    return list;
  }
  
  public static void main(String[] args) {
    QuickSort sorter = new QuickSort();
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    int[] sorted = sorter.sort(list, 0, list.length - 1);
    printList(sorted);
  }

}