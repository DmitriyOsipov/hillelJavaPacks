package Ex2_someRedone;

public class ConsoleGraphicsBerth
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
            arrayPainting.paintPerimeter(matrix);
            //arrayPainting.showArray(matrix);
//*
            System.out.println("------------Part B\t\"The envelope\" with Bresenham's line algorithm-----------");

            int x0 = 0;
            int y0 = 0;
            int x1 = xDimension - 1;
            int y1 = yDimension - 1;
            double error = 0;
            int deltaX = Math.abs(x1-x0);
            int deltaY = Math.abs(y1-y0);
            int s1 = (x1-x0)/deltaX;
            int s2 = (y1-y0)/deltaY;
            double deltaError = 2*deltaY - deltaX;
            boolean change = false;

            int y = y0;
            if (deltaY < deltaX){
                int tmp = deltaX;
                deltaX = deltaY;
                deltaY = tmp;
                change = true;
            }
            else {
                change = false;
            }

            for (int x = x0; x <= deltaX; x++){
                matrix[x][y] = symbolElement;
                while (error>=0){
                    if (change){
                        x+=s1;
                    }
                    else {
                        y+=s2;
                    }
                    error = error - 2*deltaX;
                }

                if (change){
                    y+=s2;
                }
                else {
                    x += s1;
                }
                error = error + 2*deltaY;
            }
            arrayPainting.showArray(matrix);
            /*
            int[] mainDiag0 = {0,0};
            int[] mainDiag1 = {xDimension -1, yDimension -1};
            int[] secondaryDiag0 = {0, yDimension - 1};
            int[] secondaryDiag1 = {xDimension - 1, 0};
            double sMain = (mainDiag1[1]-mainDiag0[1])/(mainDiag1[0]-mainDiag0[0]);
            double sSecondary = (secondaryDiag1[1]-secondaryDiag0[1])/(secondaryDiag1[0]-secondaryDiag0[0]);

            int deltaXMain = Math.abs(mainDiag1[0]-mainDiag0[0]);
            int deltaYMain = Math.abs(mainDiag1[1]-mainDiag0[1]);
            int error = 0;
            int deltaErr = deltaYMain;
            int y = mainDiag1[1];
            for (int x = mainDiag0[0]; x<=mainDiag1[1]; x++){
                matrix[x][y] = '*';
                error +=deltaErr;
                if ((2*error)>=deltaXMain){
                    y--;
                    error = error - deltaXMain;
                }
            }

            arrayPainting.showArray(matrix);//*/

        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }


}
