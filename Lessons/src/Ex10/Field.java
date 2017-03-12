package Ex10;

public class Field {
    private final int FIELD_SIZE = 3;
    private int[][] field = new int[FIELD_SIZE][FIELD_SIZE];

    public boolean validateMove(int fieldID){
        boolean result = false;
        if (!isIdValid(fieldID)){
            return false;
        }
        if (this.get(fieldID)==0){
            result = true;
        }

        return result;
    }

    public boolean makeMove(int fieldId, int value){
        boolean result = false;

        if (validateMove(fieldId)) {
            int[] coords = this.getCoords(fieldId);
            if (coords!=null) {
                field[coords[0]][coords[1]] = value;
            }
            result = true;
        }

        return result;
    }

    public boolean checkFinal(int fieldId){
        boolean result = false;

        return result;
    }

    private boolean isIdValid(int fieldID){
        return ((fieldID>=0)&&(fieldID<FIELD_SIZE*FIELD_SIZE));
    }

    private int[] getCoords(int fieldId){
        int[] coords = null;

        int count = 0;
        for (int i=0; i<FIELD_SIZE; i++){
            for (int j=0; j<FIELD_SIZE; j++){
                if (count==fieldId){
                    coords = new int[2];
                    coords[0] = i;
                    coords[1] = j;
                    return coords;
                }
                count++;
            }
        }

        return coords;
    }

    private int get(int fieldId){
        int res = -1;

        int[] coords = this.getCoords(fieldId);
        if (coords!=null){
            res = field[coords[0]][coords[1]];
        }

        return res;
    }
}
