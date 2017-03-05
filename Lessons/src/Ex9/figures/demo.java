package Ex9.figures;

public class demo {
    public static void main(String[] args){
        FiguresCollection collection = new FiguresCollection();

        collection.add(new Triangle(new Red(3, 1.5), 15, 25));
        collection.add(new Circle(new Green(5, 2), 29));
        collection.add(new Rectangle(new Blue(7, 3), 19, 25));

        System.out.println("Figures:");
        System.out.println(collection);
        System.out.println("Total area: " + collection.area());
        System.out.println("Paint took: " + collection.paintAmount());
        System.out.println("Paint cost: " + collection.paintCost());
    }
}
