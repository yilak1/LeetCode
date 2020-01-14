package oj40_59;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题1
 */
public class Lee_51_Self {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        search(result,cols, n);
        return result;
    }

    public ArrayList<String> drawBoard(ArrayList<Integer> cols){
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++){
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < cols.size(); j++){
                if (cols.get(i) == j){
                    str.append('Q');
                }else {
                    str.append('.');
                }
            }
            board.add(str.toString());
        }

        return board;
    }
    public boolean isValid(ArrayList<Integer> cols, int col){
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++){
            if (cols.get(i) == col){
                return false;
            }
            if (cols.get(i) - i == col - row){
                return false;
            }
            if (cols.get(i) + i == col + row){
                return false;
            }
        }
        return true;
    }
    public void search(ArrayList<List<String>> result,
                        ArrayList<Integer> cols,
                        int n){
        if (cols.size() == n){
            result.add(drawBoard(cols));
            return;
        }
        for (int col = 0; col < n; col ++){
            if (isValid(cols, col)){
                cols.add(col);
                search(result, cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Lee_51_Self self = new Lee_51_Self();
        int n = 4;
        System.out.println(self.solveNQueens(n));
    }
}
