class InsertionSort {

  public static void printList(int[] list) {
    for(int i = 0; i < list.length; i++) {
      System.out.printf("%d, ", list[i]);
    }
  }

  public int[] sort(int[] list) {

    int holePosition;
    int valueToInsert;

    for(int i = 0; i < list.length; i++) {
      valueToInsert = list[i];
      holePosition = i;

      while(holePosition > 0 && list[holePosition - 1] > valueToInsert) {
        list[holePosition] = list[holePosition - 1];
        holePosition = holePosition - 1;
      }

      list[holePosition] = valueToInsert;

    }
   
    return list;
  }
  
  public static void main(String[] args) {
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    InsertionSort sorter = new InsertionSort();
    int[] sorted = sorter.sort(list);
    printList(sorted);
  }

}