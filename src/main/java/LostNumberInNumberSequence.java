import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class LostNumberInNumberSequence {
    public static void main(String[] args) {
        System.out.println(findDeletedNumber4(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{5, 7, 6, 9, 4, 8, 1, 2, 3}));
    }

    public static int findDeletedNumber(int[] arr, int[] mixedArr) {
        Arrays.sort(mixedArr);
        if (Arrays.equals(arr, mixedArr)) {
            return 0;
        } else {
            for (int i : arr) {
                for (int j : mixedArr) {
                    if (i == j) {
                        arr = ArrayUtils.removeElement(arr, i);
                    }
                }
            }
            return arr[0];
        }
    }

    public static int findDeletedNumber2(int[] arr, int[] mixedArr) {
        Arrays.sort(mixedArr);
        for (int i : arr) {
            for (int j : mixedArr) {
                if (i == j) {
                    arr = ArrayUtils.removeElement(arr, i);
                }
            }
        }
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0];
        }
    }

    public static int findDeletedNumber3(int[] arr, int[] mixedArr) {
        Arrays.sort(mixedArr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != mixedArr[i]) {
                return arr[i];
            }
        }
        return 0;
    }

    public static int findDeletedNumber4(int[] arr, int[] mixedArr) {
        Arrays.sort(mixedArr);
        return Arrays.stream(arr)
                .filter(i -> arr[i] != mixedArr[i])
                .map(i -> arr[i])
                .findFirst()
                .orElse(0);
    }

    public static int findDeletedNumber6(int[] arr, int[] mixedArr) {
        return Arrays.stream(arr)
                .sum() - Arrays.stream(mixedArr)
                .sum();
    }

    public static int findDeletedNumber7(int[] arr, int[] mixedArr) {
        Arrays.sort(mixedArr);
        return Arrays.stream(arr)
                .filter(i -> Arrays.stream(mixedArr).noneMatch(j -> j == i))
                .findFirst()
                .orElse(0);
    }
}

