/**
 * @Description TODO
 * @Date 2022/9/14 9:37
 * @Created by WeiFeng
 */
public class demo6 {

    public static void main(String[] args) {
        Animal animal = new Animal("大熊猫", 12);
        animal.show();
        System.out.println(animal.show1());
    }


    public static class Animal {
        public String name;
        public int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void show() {
            System.out.println("名字：" + name + ", 年龄：" + age);
        }

        public String show1() {
            return  "名字：" + name + ", 年龄：" + age;
        }

    }
}
