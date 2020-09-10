class SelectionSort {

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

    for(int i = 0; i < list.length - 1; i++) {
      int min = i;
      for(int j = i + 1; j < list.length; j++) {
        if(list[j] < list[min]) {
          min = j;
        }
      }

      swap(list, min, i);
    } 
   
    return list;
  }
  
  public static void main(String[] args) {
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    SelectionSort sorter = new SelectionSort();
    int[] sorted = sorter.sort(list);
    printList(sorted);
  }

}