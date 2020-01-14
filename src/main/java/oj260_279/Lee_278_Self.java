package oj260_279;

/**
 * 发现第一个坏的版本，
 * 设计一个算法使调用isbadVersion次数最少
 * 一看就是二分查找找第一个位置的题
 */
public class Lee_278_Self {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        if (isBadVersion(start)){
            return start;
        }
        if (isBadVersion(end)){
            return end;
        }
        return 0;
    }
    boolean isBadVersion(int version){
        switch (version){
            case 1: return false;
            case 2: return false;
            case 3: return false;
            case 4: return true;
            case 5: return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lee_278_Self self = new Lee_278_Self();
        System.out.println(self.firstBadVersion(5));
    }
}
