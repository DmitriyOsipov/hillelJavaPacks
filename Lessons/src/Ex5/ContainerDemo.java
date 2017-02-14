package Ex5;

/**
 * Created by mtzadmin on 14.02.2017.
 */
public class ContainerDemo {
    public static void main(String[] args) throws Exception{
        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {6, 7, 8};

        System.out.println("Init with one number:");
        ContainerInt firstContainer = new ContainerInt(firstArray[0]);
        firstContainer.toString();

    }
}
