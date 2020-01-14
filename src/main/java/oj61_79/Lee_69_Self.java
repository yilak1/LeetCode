package oj61_79;

public class Lee_69_Self {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x <= 1){
            return 1;
        }
        int start = 1;
        int end = x;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (mid == x / mid){
                return mid;
            }else if (mid > x / mid){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (end > x / end){
            return start;
        }
        return end;
    }
}
