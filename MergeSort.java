class MergeSort {

  public static void printList(int[] list) {
    for(int i = 0; i < list.length; i++) {
      System.out.printf("%d, ", list[i]);
    }
  }

  private void merge(int[] list, int l, int m, int r) {

    int n1 = m - l + 1;
    int n2 = r - m;
    int L[] = new int[n1];
    int R[] = new int[n2];

    for(int i = 0; i < n1; ++i) 
      L[i] = list[l + i];

    for(int j = 0; j < n2; ++j)
      R[j] = list[m + 1 + j];

    int i = 0;
    int j = 0;
    int k = l;

    while(i < n1 && j < n2) {
      if(L[i] <= R[j]) {
        list[k] = L[i];
        i++;
      } else {
        list[k] = R[j];
        j++;
      }
      k++;
    }

    while(i < n1) {
      list[k] = L[i];
      i++;
      k++;
    }

    while(j < n2) {
      list[k] = R[j];
      j++;
      k++;
    }
    
  }
  
  public int[] sort(int[] list, int l, int r) {
    if(l < r) {
      int m = (l + r) / 2;
      sort(list, l, m);
      sort(list, m + 1, r);
      merge(list, l, m, r);
    }

    return list;
  }
  
  public static void main(String[] args) {
    int[] list = { 4, 9, 1, 5, 7, 2, 4, 0, 2 };
    MergeSort sorter = new MergeSort();
    int[] sorted = sorter.sort(list, 0, list.length - 1);
    printList(sorted);
  }

}