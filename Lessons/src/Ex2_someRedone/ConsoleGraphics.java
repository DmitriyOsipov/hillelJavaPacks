package Ex2_someRedone;

public class ConsoleGraphics
{
    public static void main(String[] args) throws Exception{
        int xDimension, yDimension;
        char nullElement = ' ', symbolElement = '*';

        UserConsoleReader userConsoleReader = new UserConsoleReader();
        ArrPaint arrayPainting = new ArrPaint();

        do {
            System.out.println("Input x-dimension please");
            xDimension = userConsoleReader.readInt(1);
            System.out.println("Input y-dimension please");
            yDimension = userConsoleReader.readInt(1);

            char[][] matrix = arrayPainting.getClearMatrix(xDimension, yDimension, nullElement);

            System.out.println("------------Part A\t\"Perimeter\"---------------");

            arrayPainting.paintPerimeter(matrix);
            arrayPainting.showArray(matrix);

            System.out.println("------------Part B\t\"The envelope\"--------------");

            int[] mainDiagFirstDot = {0,0};
            int[] mainDiagLastDot = {xDimension -1, yDimension -1};
            int[] secondaryDiagFirstDot = {0, yDimension - 1};
            int[] secondaryDiagLastDot = {xDimension - 1, 0};
            
            for (int indexX = 0; indexX < xDimension; indexX ++){
                for (int indexY = 0; indexY < yDimension; indexY++)
                {
                    boolean mainDiag = ( (((mainDiagLastDot[1] - mainDiagFirstDot[1])*indexX+(mainDiagLastDot[0]*mainDiagFirstDot[1]-mainDiagFirstDot[0]*mainDiagLastDot[1]))/(mainDiagLastDot[0]-mainDiagFirstDot[0]))== indexY );
                    boolean secondaryDiag = ( (((secondaryDiagLastDot[1] - secondaryDiagFirstDot[1])*indexX+(secondaryDiagLastDot[0]*secondaryDiagFirstDot[1]-secondaryDiagFirstDot[0]*secondaryDiagLastDot[1]))/(secondaryDiagLastDot[0]-secondaryDiagFirstDot[0]))== indexY );
                    if((mainDiag)||(secondaryDiag)){
                        matrix[indexX][indexY]=symbolElement;
                    }
                }
            }

            arrayPainting.showArray(matrix);
            System.out.println();

            System.out.println("------------Part C\t\"Chess board\"---------------");


            for (int indexXDimension = 0; indexXDimension < xDimension; indexXDimension++) {
                for (int indexYDimension = 0; indexYDimension < yDimension; indexYDimension++) {
                    matrix[indexXDimension][indexYDimension] = ((indexXDimension + indexYDimension) % 2 == 0) ? symbolElement : nullElement;
                }
            }
            arrayPainting.showArray(matrix);
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}
