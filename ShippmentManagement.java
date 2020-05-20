import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;


public class ShippmentManagement {
	


	@Test
	public void test(){
		split();
		merge(1);
		increaseRootQuantity();
		decreaseRootQuantity();
	}

	public static void split() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the number of metrics tons of goods that need to be shipped:");
		int x = scanner.nextInt();
		 ArrayList<int[]> list = new  ArrayList<int[]>();
		 //counted every situation of this number
	        for (int[] ints : calculate(x)) {
	            Arrays.sort(ints);
	            list.add(ints);
	        }
	        //choose random one
	        System.out.println("please enter the number of situation:");
	        int n = scanner.nextInt();
	        int[] arr = list.get(n);
	       for (int i = 0; i < arr.length; i++) {
			if (i==0) {
				System.out.print("["+arr[i]*100);
			}else if (i==arr.length-1) {
				System.out.println(","+arr[i]*100+"]");
			}else {
				System.out.print(","+arr[i]*100);
			}
		}
	}
	
	
	
	
	

	public static void merge(int index) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the number of metrics tons of goods that need to be shipped:");
		int x = scanner.nextInt();
		Set<int[]> set = calculate(x);
		ArrayList<int[]> list = new  ArrayList<int[]>(set);
		int[] arr = list.get(index);
		int a=arr[arr.length-1]*100;
		int b=arr[arr.length-2]*100;
		System.out.println(a+b);
	}
	
	

	public static void increaseRootQuantity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the number of metrics tons of goods that need to be shipped:");
		int x = scanner.nextInt();
	        // 去掉重复的、排序
	        // 若要更改排序规则，去掉排序规则的参数即可
		 ArrayList<int[]> list = new  ArrayList<int[]>();
	        for (int[] ints : calculate(x*2)) {
	            // 将目标数组排序
	            Arrays.sort(ints);

	            // 将排序后的数组转化为字符串，放入 set
	            list.add(ints);
	        }
	        //choose random one
	        System.out.println("please enter the number of situation:");
	        int n = scanner.nextInt();
	        int[] arr = list.get(n);
	       for (int i = 0; i < arr.length; i++) {
			if (i==0) {
				System.out.print("["+arr[i]*100);
			}else if (i==arr.length-1) {
				System.out.println(","+arr[i]*100+"]");
			}else {
				System.out.print(","+arr[i]*100);
			}
		}
	}
	
	public static void decreaseRootQuantity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the number of metrics tons of goods that need to be shipped:");
		int x = scanner.nextInt();
		 ArrayList<int[]> list = new  ArrayList<int[]>();
	        for (int[] ints : calculate(x/2)) {
	            Arrays.sort(ints);
	            list.add(ints);
	        }
	        //choose random one
	        System.out.println("please enter the number of situation:");
	        int n = scanner.nextInt();
	        int[] arr = list.get(n);
	       for (int i = 0; i < arr.length; i++) {
			if (i==0) {
				System.out.print("["+arr[i]*50);
			}else if (i==arr.length-1) {
				System.out.println(","+arr[i]*50+"]");
			}else {
				System.out.print(","+arr[i]*50);
			}
		}
	}
	
	 public static Set<int[]> calculate(int num) {
	        Set<int[]> set = new HashSet<>();
	        if(num == 1){
	            set.add(new int[]{1});
	            return set;
	        }

	        if(num == 2){
	            set.add(new int[]{1,1});
	            return set;
	        }

	        // num is not 1 and not 2
	        for(int i = 1; i <= num / 2; i++){
	            set.add(new int[]{i, num - i});

	            if(i <= num - i){
	                Set<int[]> tempSet = calculate(num - i);
	                for (int[] ints : tempSet) {
	                    ints = Arrays.copyOf(ints, ints.length + 1);
	                    ints[ints.length - 1] = i;
	                    set.add(ints);
	                }
	            }
	        }
	        return set;
	    }
	
}
