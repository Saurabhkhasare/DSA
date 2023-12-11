package question1;

public class StackWithConstantTime {
	private int arr[];
	private int top;
	private int max;
	private int min;

	public StackWithConstantTime(int size) {
		top = -1;
		arr = new int[size];
		max = -1;
		min = Integer.MAX_VALUE;
	}

	public int[] getArr() {
		return arr;
	}

	public int getTop() {
		return top;
	}

	void push(int val) {
		if (top == -1) {
			arr[++top] = val;
			max = val;
		} else if (top < arr.length) {
			if (max < val) {
				arr[++top] = 2*val - max;
				max = val;
			}
			else
			arr[++top] = val;
			 min = Math.min(min, val);
		} else
			//System.out.println("Stack is Full!!, cant be push");
			throw new StackException("stack is Full!!, can't be push ");
	}

	void pop() {
		if (top != -1) {
			if(arr[top]>=max) {
				System.out.println("Popped : " + max);
				max = 2*max - arr[top];
				top--;
			}else
				System.out.println("Popped : " + arr[top--]);
		}
		else
			//System.out.println("Stack is empty!!!, can't be pop");
			throw new StackException("Stack is empty!!!, can't be pop ");

	}

	void top() {
		if (top != -1) {
			if(arr[top]>max)
			System.out.println("Top element : " + max);
			else
				System.out.println("Top element : " + arr[top]);
		
		}
		else
			//System.out.println("Stack is empty!!!");
			throw new StackException("Stack is empty!!!");	
	}

	void getMax() {
		if(top!=-1)
		System.out.println("Maximum is: " + max);
		else
			//System.out.println("Stack is empty!!!");
			throw new StackException("Stack is empty!!!");	
			
	}
	void getMin() {
        if (top != -1) {
            System.out.println("Minimum is: " + min);
        } else {
            throw new StackException("Stack is empty!!!, can't get minimum");
        }
    }
}
