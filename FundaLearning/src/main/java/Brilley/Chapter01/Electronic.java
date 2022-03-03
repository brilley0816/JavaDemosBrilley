package Brilley.Chapter01;

public interface Electronic {
    //constant
    String LED="LED";

    //abstract method
    int getElectricityUse();

    //static method
    static boolean isEnergyEfficient(String electronicType) {
        return electronicType.equals("LED");
    }

    //default method
    default void printDescription() {
        System.out.println("电子");
    }

}
