package Ex9.figures;


public abstract class Figure {
    private final String name;
    private FigureColor color;

    public Figure(String name, FigureColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color.getName();
    }

    public abstract double area();

    public double paintingAmount(){
        double res;
        res = this.area() * color.getConsumption();
        return res;
    }

    public double paintingCost(){
        return  this.paintingAmount()*color.getPrice();
    }

    public abstract String toString();

}
