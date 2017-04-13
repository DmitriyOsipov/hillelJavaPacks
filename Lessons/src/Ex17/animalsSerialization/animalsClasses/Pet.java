package Ex17.animalsSerialization.animalsClasses;


public class Pet extends Animal {
    public static final long serialVersionUID = 2017041303L;
    private String name;
    private boolean isVacinated;

    public Pet() {}

    public Pet(int id, int age, double weight, String color, String name, boolean isVacinated) {
        super(id, age, weight, color);
        this.name = name;
        this.isVacinated = isVacinated;
    }

    public Pet(int id, int age, double weight, String color, String name) {
        super(id, age, weight, color);
        this.name = name;
        this.isVacinated = false;
    }

    public void setVacinated(boolean vacinated) {
        isVacinated = vacinated;
    }

    public String getName() {
        return name;
    }

    public boolean isVacinated() {
        return isVacinated;
    }

    public String makeVoice(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeVoice());
        if ((this.name!=null)&&(name.length()>0)){
            builder.append(" my name is ");
            builder.append(name);
        }
        return builder.toString();
    }
}
