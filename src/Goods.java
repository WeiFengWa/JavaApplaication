public class Goods {
    public String user = "user";
    public String psw = "psw";
    // public String[][] sp = {
    // { "电风扇", "124.23" },
    // { "洗衣机", "4500.0" },
    // { "电视机", "8800.9" },
    // { "冰箱", "5000.88" },
    // { "空调", "4456.0" } };
    public String[] sp = { "电风扇", "洗衣机", "电视机", "冰箱", "空调" };
    public double[] jg = { 124.23, 4500.0, 8800.9, 5000.88, 4456.0 };

    public boolean login(String u, String p) {
        return user.equals(u) && psw.equals(p);
    }

    public void show() {
        System.out.println("***欢迎加入商品批发城***");
        System.out.println("编号\t商品\t价格");
        for (int i = 0; i < sp.length; i++) {
            System.out.print(i + "\t" + sp[i] + "\t" + change(jg[i]));
            System.out.println();
        }
        System.out.println("*********************");
    }

    public String change(Double jg) {
        String s = jg.toString();
        int index = s.indexOf(".");
        String qian = s.substring(0, index);
        String hou = s.substring(index);
        StringBuffer buffer = new StringBuffer(qian);
        for (int i = qian.length() - 3; i > 0; i -= 3) {
            buffer.insert(i, ",");
        }
        return buffer.append(hou).toString();
    }

    public void buy(int bh, int pfl) {
        String fk = change(jg[bh] * pfl);
        System.out.println("你需要付款：" + fk);
    }

    // public static void main(String[] args) {
    // change("213121233.3");
    // }
}