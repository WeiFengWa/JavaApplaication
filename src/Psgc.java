/**
 * @Description 披萨工厂
 * @Date 2022/10/4 17:15
 * @Created by WeiFeng
 */
public abstract class Psgc {

    private String name;
    private String size;
    private String price;

    public abstract void show();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
