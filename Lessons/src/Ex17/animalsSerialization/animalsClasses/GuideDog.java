package Ex17.animalsSerialization.animalsClasses;


public class GuideDog extends Dog {
    public static final long serialVersionUID = 2017041309L;
    private boolean isTrained;

    public GuideDog() {
    }

    public GuideDog(int id, int age, double weight, String color, String name, boolean isVacinated, boolean isTrained) {
        super(id, age, weight, color, name, isVacinated);
        this.isTrained = isTrained;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        if (trained) {
            isTrained = trained;
        }
    }

    public void takeHome(){
        if (isTrained) {
            System.out.println("You are at home now");
        }
        else {
            System.out.println("I'm not trained. I cannot take you home");
        }
    }

    public String makeVoice(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeVoice());
        if (isTrained){
            builder.append("\nI can take you home.");
        }
        return builder.toString();
    }
}
