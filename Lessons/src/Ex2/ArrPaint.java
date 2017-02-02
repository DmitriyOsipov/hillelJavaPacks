package Ex2;


public class ArrPaint {
    public char[][]getClearMatrix(int xDimension, int yDimension, char initElement)
    {
        char[][] clearMatrix = new char[xDimension][yDimension];

        for (int indexXDimension = 0; indexXDimension < xDimension; indexXDimension++){
            for (int indexYDimension = 0; indexYDimension < yDimension; indexYDimension++){
                clearMatrix[indexXDimension][indexYDimension] = initElement;
            }
        }

        return clearMatrix;
    }

    public char[][] paintPerimeter(int xDimension, int yDimension){
        char[][] matrix = new char[xDimension][yDimension];
        for (int indexX=0; indexX<xDimension; indexX=indexX+xDimension-1){
            for (int indexY=0; indexY<yDimension; indexY++){
                matrix[indexX][indexY]='*';
            }
        }
        for (int indexY=0; indexY<yDimension; indexY=indexY+yDimension-1) {
            for (int indexX = 0; indexX < xDimension; indexX++) {
                matrix[indexX][indexY] = '*';
            }
        }
        return matrix;
    }

    public void paintPerimeter(char[][] matrixToDraw){
        int xDimension = matrixToDraw.length;
        int yDimension = matrixToDraw[0].length;

        for (int indexX=0; indexX<xDimension; indexX=indexX+xDimension-1){
            for (int indexY=0; indexY<yDimension; indexY++){
                matrixToDraw[indexX][indexY]='*';
            }
        }
        for (int indexY=0; indexY<yDimension; indexY=indexY+yDimension-1) {
            for (int indexX = 0; indexX < xDimension; indexX++) {
                matrixToDraw[indexX][indexY] = '*';
            }
        }
    }

    public void showArray(char[][] arrayToShow)
    {
        int xDimension = arrayToShow.length;
        int yDimension = arrayToShow[0].length;

        for (int indexX =0; indexX<xDimension; indexX++) {
            for (int indexY = 0; indexY < yDimension; indexY++) {
                System.out.print(arrayToShow[indexX][indexY]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

