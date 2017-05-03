package com.lessons.Ex2_someRedone;

import com.lessons.utilClasses.UserConsoleReader;

public class LineBresenham{
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

            int[] mainDiagStart = {0, 0};
            int[] mainDiagEnd = {xDimension - 1, yDimension - 1};
            int[] secDiagStart = {0, yDimension - 1};
            int[] secDiagEnd = {xDimension - 1, 0};

            matrix = createLine(matrix, symbolElement, mainDiagStart, mainDiagEnd);
            matrix = createLine(matrix, symbolElement, secDiagStart, secDiagEnd);

            arrayPainting.showArray(matrix);
        }while (userConsoleReader.isRepeatYes());
    }

    public static char[][] createLine(char[][] array, char plotCharacter, int[] lineStart, int[] lineEnd){
        char[][] result = array;

        int x0 = lineStart[0], y0 = lineStart[1];
        int x1 = lineEnd[0], y1 = lineEnd[1];
        int dy = y1 - y0;
        int dx = x0 - x1;
        int sign, signDx, signDy;

        sign = (Math.abs(dy)>Math.abs(dx)) ? 1:-1;
        signDx = (dx<0) ? -1:1;
        signDy = (dy<0) ? -1:1;

        result[x0][y0] = plotCharacter;
        int x=x0, y=y0, fXY = 0;
        if (sign == -1){
            do{
                fXY +=dy*signDy;
                if (fXY>0){
                    fXY-=dx*signDx;
                    y+=signDy;
                }
                x-=signDx;
                result[x][y]=plotCharacter;
            }while (x!=x1||y!=y1);
        }
        else {
            do {
                fXY+=dx*signDx;
                if (fXY>0){
                    fXY-=signDy*dy;
                    x-=signDx;
                }
                y+=signDy;
                result[x][y]=plotCharacter;
            }while (x!=x1 || y!=y1);
        }

        return result;
    }

}
