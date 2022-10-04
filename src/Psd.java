/**
 * @Description 披萨店
 * @Date 2022/10/4 17:19
 * @Created by WeiFeng
 */
public class Psd extends Psgc{

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void show() {
        System.out.println("这个披萨" + this.getName() + this.getSize() + this.getPrice() + this.getDate());
    }
}
