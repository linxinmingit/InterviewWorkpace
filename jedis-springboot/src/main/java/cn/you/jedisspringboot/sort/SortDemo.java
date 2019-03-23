package cn.you.jedisspringboot.sort;

public class SortDemo {
    public static void main(String[] args) {
//        final int N = 100;  //常量
//        int[] nums = new int[N];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int) (Math.random() * 100000);
//
//        }
        int [] nums = {45,32,56,20,90};
//        long startTime = System.currentTimeMillis();
         //以下就是冒号排序的核心算法
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("冒号排序共耗时:" + (endTime - startTime) + "毫秒");
        //  打印结果
        System.out.println("排序后:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" , ");
//            if ((i + 1) % 10 == 0) {
//                System.out.println();
//            } else {
//                System.out.print(", ");
//            }
        }
    }
}