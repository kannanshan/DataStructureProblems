package com.hackerrank.easy.problems;

public class Solutions {
	
	public static void main(String args[] ) throws Exception {
        int[][] matrixA ={{1,0,0},{0,1,0},{0,0,1}};
        //int[][] matrixB = {{1,3,4},{2,1,1},{2,3,1}};
        
        int[][] matrixB = {{1,2,2},{3,1,3},{4,1,1}};
        
        int[][] result = multiplyMatrix(matrixA,matrixB);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        System.out.println(multiplyMatrix(matrixA,matrixB));
    }
    
    public static int[][] multiplyMatrix(int[][] matrixA,int[][] matrixB)
    {
        if(matrixA == null && matrixB==null)
            return null;
        if(matrixA==null)
            return matrixB;
        if(matrixB==null)
            return matrixB;
        int row=matrixA.length;
        if(row==0)
            return matrixB;
        int col=matrixA[0].length;
        int[][] result = new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                result[i][j]=0;
                for(int k=0;k<row;k++)
                {
                    result[i][j]=result[i][j]+(matrixA[i][k]*matrixB[k][j]);
                }
            }
        }
       return result; 
    }

}
