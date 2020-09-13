package binarysearch;

public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
    public double mySort(int x) {
        if (x == 0 || x == 1) return x;
        double start = 0;
        double end = x / 2 + 1;
        double res = 0;
        double mid = 0;
        double square = 0;
        while (end - start < 0.001) {
            mid = (end - start) / 2 + 1;
            square = mid * mid;

        }
        return res;
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        int left = 2;
        int right = num/2;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int square = mid * mid;
            if (square == num) {
                return true;
            }
            if (square > num){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
