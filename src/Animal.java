public class Animal {
    private String name;
    private char sex;
    private String color;

    public Animal() {}

    public Animal(String name, char sex, String color) {

    }

    public void show() {
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}