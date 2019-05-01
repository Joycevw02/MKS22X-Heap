public class MyHeap{
  //- size  is the number of elements in the data array.
  //- push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  //- precondition: index is between 0 and size-1 inclusive
  //- precondition: size is between 0 and data.length-1 inclusive.
  private static void pushDown(int[]data,int size,int index){
    //Stores the index of the left and right nodes
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    //If the left is in bound and greater than data or if right is in bound and greater than data...
    if ((left < size && data[index] < data[left]) || (right < size && data[index] < data[right])){
      //Swap with the larger child
      if (data[right] > data[left]){
        int temp = data[right];
        data[right] = data[index];
        data[index] = temp;
        //Call pushDown on the right branch and the next index
        pushDown(data, size, right);
        pushDown(data, size, index + 1);
      }
      else{
        int temp = data[left];
        data[left] = data[index];
        data[index] = temp;
        //Call pushDown on the left branch and the next index
        pushDown(data, size, left);
        pushDown(data, size, index + 1);
      }
    }
  }

  //- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  //- precondition: index is between 0 and data.length-1 inclusive.
  private static void pushUp(int[]data,int index){
    //Store the index of the parent node
    int parent = (index - 1) / 2;
    //If the current index is not zero and its value is greater than the
    //parent's value, swap the values and pushUp from the new index
    if (index > 0 && data[index] > data[parent]){
      int temp = data[parent];
      data[parent] = data[index];
      data[index] = temp;
      pushUp(data, parent);
    }
  }

  //- convert the array into a valid heap. [ should be O(n) ]
  public static void heapify(int[] data){

  }

  //- sort the array [ should be O(nlogn) ] :
  //converting it into a heap
  //removing the largest value n-1 times (remove places at end of the sub-array).
  public static void heapsort(int[] data){

  }

  public static void main(String[] args){
    int[] test = {12,16,13,13,7,14,40};
//    for (int i = test.length - 1; i >= 0; i --){
//      pushDown(test, test.length, i);
//    }
    for (int i = 0; i < test.length; i ++){
      pushUp(test, i);
    }
    for (int i : test){
      System.out.println(i + "");
    }
  }
}
