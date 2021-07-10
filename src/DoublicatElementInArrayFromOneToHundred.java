//https://proglib.io/p/15-questions-for-programmers/

public class DoublicatElementInArrayFromOneToHundred {
    public static void main(String[] args) {
        int sum1 = 0;
        for (int i = 1; i < 101; i++) {
            sum1 += i;
        }

        int[] arr = new int[101];
        for (int i = 0; i <= 100; i++) {
            if (i == 30 ) {
                arr[i] = i;
                continue;
            }
            if (i < 30) {
                arr[i] = i + 1;
                continue;
            }
            arr[i] = i;
        }
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2 += arr[i];
        }

        int result = sum2 - sum1;
        System.out.println(sum1 + "-сумма чисел массива должна быть");
        System.out.println(sum2 + "-фактическая сумма");
        System.out.println(result + "-разность сумм равна дубликату");
    }
}
