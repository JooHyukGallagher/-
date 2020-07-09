class MinStack {
    int min;
    int[] arr;
    int size;
    /** initialize your data structure here. */
    public MinStack() {
        size = 0;
        min = Integer.MAX_VALUE;
        arr = new int[1];
    }
    
    public void push(int x) {
        if(size >= arr.length) {
            int[] newArr = new int[size * 2];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        arr[size] = x;
        size++;
        if(min > x){
            min = x;
        }
    }
    
    public void pop() {
        if(top() == min) {
            size--;
            min = Integer.MAX_VALUE;
            for(int i=0; i<size; i++) {
               if(min > arr[i]) {
                   min = arr[i];
               }
            }
        } else {
            size--;
        }
    }
    
    public int top() {
        return arr[size-1];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */