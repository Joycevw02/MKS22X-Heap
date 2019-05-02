public class MyHeap{
  //- size  is the number of elements in the data array.
  //- push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  //- precondition: index is between 0 and size-1 inclusive
  //- precondition: size is between 0 and data.length-1 inclusive.
  private static void pushDown(int[]data,int size,int index){
    while(true){
      //Stores the index of the left and right children
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      //This means that it reached the end of the heap
      if( left >= size){
        break;
      }
      //If right is in bound...
      if (right < size){
        //And right value is greater than the parent value...
        if(data[right] > data[index]){
          //And the left value is greater than the right value, the swap
          if (data[left] > data[right]){
            int temp = data[left];
          	data[left] = data[index];
          	data[index] = temp;
            index = left;
          }
          //Else (meaning the right value is greater), swap the right value
          else{
            int temp = data[right];
            data[right] = data[index];
            data[index] = temp;
            index = right;
          }
        }
        //This means it is out of bounds
        else{
          break;
        }
      }
      //Check the unchecked side
      else if (data[left] > data[index]){
        int temp = data[left];
        data[left] = data[index];
        data[index] = temp;
        index = left;
      }
      else{
        break;
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
    //Push every node to its correct place
    for (int i = data.length; i >= 0; i --){
      pushDown(data, data.length, i);
    }
  }

  //- sort the array [ should be O(nlogn) ] :
  //converting it into a heap
  //removing the largest value n-1 times (remove places at end of the sub-array).
  public static void heapsort(int[] data){
    //Heapify the data
    heapify(data);
    //Keep track of the end of the unsorted array
    int end = data.length - 1;
    //Loop through the array...
    for (int i = 0; i < data.length; i ++){
      //Swap the end value with the first value in the unsorted array
      int temp = data[end];
      data[end] = data[0];
      data[0] = temp;
      //Move end up
      end --;
      //Push down the new start to the correct place
      pushDown(data, end, 0);
    }
  }

  public static void main(String[] args){
    int[] test1 = {12,16,13,13,7,14,40};
    int[] test2 = {2,55,88,86,99,100};
    int[] test3 = {1,235,60,3,34,5,123,4,134};
    int[] test4 = {1,2,5,13,34,1,3,8,21,89};
    int[] test5 = {36693,30279,79398,43983,26694,79007,93565,41959,13573};
    int[] test6 = {800,2306,413,4183,2250};
    int[] test7 = {61,268,96};
    int[] test8 = {48,68,1,6};
    int[] test9 = {1,1,1,1,2,2,3,4,5,6,6,7,8,9,9,12};
    int[] test10 = {56,7,3,123,654,1235,784,1,672};

    heapify(test1);
    heapify(test2);
    heapify(test3);
    heapify(test4);
    heapify(test5);
    heapify(test6);
    heapify(test7);
    heapify(test8);
    heapify(test9);
    heapify(test10);

    System.out.println("Test 1");
    for (int i : test1){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 2");
    for (int i : test2){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 3");
    for (int i : test3){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 4");
    for (int i : test4){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 5");
    for (int i : test5){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 6");
    for (int i : test6){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 7");
    for (int i : test7){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 8");
    for (int i : test8){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 9");
    for (int i : test9){
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Test 10");
    for (int i : test10){
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
