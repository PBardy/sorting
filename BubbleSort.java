public class BubbleSort {

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

  public int[] sort(int[] list) {

    boolean swapped;
    int n = list.length;

    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - 1; j++) {
        if(list[j] > list[j + 1]) {
          swap(list, j, j + 1);
          swapped = true;
        }
      }

      if(!swapped) break;
      
    }
   
    return list;
  }
  
  public static void main(String[] args) {
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    BubbleSort sorter = new BubbleSort();
    int[] sorted = sorter.sort(list);
    printList(sorted);
  }

}