public class CocktailSort {

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

    int n = list.length;
    boolean swapped = true;
    int start = 0;
    int end = n - 1;

    while(swapped) {
      swapped = false;
      for(int i = start; i < end; i++) {
        if(list[i] > list[i + 1]) {
          swap(list, i, i + 1);
          swapped = true;
        }
      }

      if(!swapped) break;

      end = end - 1;

      for(int i = end - 1; i > start - 1; i--) {
        if(list[i] > list[i + 1]) {
          swap(list, i, i + 1);
          swapped = true;
        }
      }

      start = start + 1;

    }

    return list;
  }

  public static void main(String args[]) {
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    CocktailSort sorter = new CocktailSort();
    int[] sorted = sorter.sort(list);
    printList(sorted);
  }

}