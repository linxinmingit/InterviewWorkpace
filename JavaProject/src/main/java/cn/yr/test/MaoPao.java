package cn.yr.test;

public class MaoPao {
	public static void main(String[] args) {
		int [] nums = {45,32,56,20,90};
        long startTime = System.currentTimeMillis();
         //���¾���ð������ĺ����㷨
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ð�����򹲺�ʱ:" + (endTime - startTime) + "����");
        //  ��ӡ���
        System.out.println("�����:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
	}
}
