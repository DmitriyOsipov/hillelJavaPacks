package Ex9.figures;


import java.util.ArrayList;

public class FiguresCollection {
    private ArrayList<Figure> figures = new ArrayList<>();

    public void add(Figure figure){
        this.figures.add(figure);
    }

    public Figure getFigure(int index){
        return this.figures.get(index);
    }

    public double area(){
        double total = 0;
        for(Figure figure : figures){
            total+=figure.area();
        }
        return total;
    }

    public double paintAmount(){
        double total = 0;
        for (Figure figure: figures){
            total+=figure.paintingAmount();
        }
        return total;
    }

    public double paintCost(){
        double total =0;
        for (Figure figure: figures){
            total+=figure.paintingCost();
        }
        return total;
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Figure figure:figures){
            builder.append(figure.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
