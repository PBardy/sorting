public class ShellSort {
  
  public static void printList(int[] list) {
    for(int i = 0; i < list.length; i++) {
      System.out.printf("%d, ", list[i]);
    }
  }

  public int[] sort(int[] list) {

    int n = list.length;

    for(int gap = n / 2; gap > 0; gap /= 2) {
      for(int i = gap; i < n; i++) {
        int j;
        int temp = list[i];
        for(j = i; j >= gap && list[j - gap] > temp; j -= gap) {
          list[j] = list[j - gap];
        } 
        list[j] = temp;
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