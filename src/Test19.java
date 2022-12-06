import java.util.Arrays;

public class Test19 {

    public static void main(String[] args) {
        int[] arrays = new int[] { 20, 30, 17, 40, 45, 31, 52, 60, 49, 47 };
        // 希尔排序
        for (int gap = arrays.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrays.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arrays[j] > arrays[j + gap]) {
                        int temp = arrays[j];
                        arrays[j] = arrays[j + gap];
                        arrays[j + gap] = temp;
                    }
                }
            }
        }

        // 冒泡排序
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }

        // 插值排序
        for (int i = 1; i < arrays.length; i++) {
            int value = arrays[i];
            int index = i;
            while (index > 0 && arrays[index - 1] > value) {
                arrays[index] = arrays[index - 1];
                index--;
            }
            arrays[index] = value;
        }
        System.out.println(Arrays.toString(arrays));
    }
}