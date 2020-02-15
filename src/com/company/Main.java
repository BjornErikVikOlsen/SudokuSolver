package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int [][] arr = {{0,0,6,9,5,0,0,4,0}, {0,0,3,0,0,0,5,1,0}, {0,0,0,0,0,3,0,0,0},
                {0,8,0,3,0,0,1,9,0}, {0,0,5,4,0,7,6,0,0}, {0,2,1,0,0,9,0,3,0},
                {0,0,0,8,0,0,0,0,0}, {0,6,8,0,0,0,2,0,0}, {0,5,0,0,7,4,9,0,0}};

        Main g = new Main();
        g.solve(arr);
    }

    public boolean possibleSolutions(int y, int x, int n, int[][] arr){
        for(int i = 0; i < 9; i++){
            if (arr[y][i] == n){
                //System.out.println("F1");
                return false;
            }
        }

        for (int j = 0; j < 9; j++){
            if (arr[j][x] == n){
                //System.out.println("F2");
                return false;
            }
        }
        int x0 = (x/3)*3;
        int y0 = (y/3)*3;
        for (int k = 0; k < 3; k++){
            for (int l = 0; l < 3; l++){
                if (arr[y0+k][x0+l] == n){
                    //System.out.println("F3");
                    return false;
                }
            }
        }
        //System.out.println("T");
        return true;

    }

    public void solve(int[][] arr){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (arr[i][j] == 0){
                    for (int k = 1; k < 10; k ++){
                        if(possibleSolutions(i,j,k,arr)){
                            arr[i][j] = k;
                            solve(arr);
                            arr[i][j] = 0;
                        }
                    }
                    return;
                }

            }

        }
        printMatrix(arr);
        System.out.println("More");

    }

    public void printMatrix(int [][] arr){
        // Loop through all rows
        for (int[] row : arr)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
