package demo;

public class HuiYuan {
    /**
     * 会员编号
     */
    public String bh;
    /**
     * 会员积分
     */
    public int jf;

    /**
     * 所有会员
     */
    public HuiYuan[] list;

    public HuiYuan() {
    }

    public HuiYuan(String bh, int jf) {
        this.bh = bh;
        this.jf = jf;
    }

    /**
     * 添加会员
     * @param bh
     * @param jf
     * @return
     */
    public HuiYuan add(String bh, int jf) {
        if(list == null) {
            list = new HuiYuan[1];
            list[0] = new HuiYuan(bh, jf);
        } else {
            // 判断会员是否存在
            for (HuiYuan hy : list) {
                if(hy.bh.equals(bh)) {
                    System.out.println("该会员已存在！");
                    query(bh);
                    return this;
                }
            }
            HuiYuan[] newList = new HuiYuan[list.length + 1];
            for (int i = 0; i < newList.length; i++) {
                newList[i] = (i == list.length) ? new HuiYuan(bh, jf): list[i];
            }
            list = newList;
        }
        return this;
    }

    /**
     * 查询会员
     * @param cx
     */
    public void query(String cx) {
        for (HuiYuan hy : list) {
            if(hy.bh.equals(cx)) {
                System.out.println("该会员的积分为：" + hy.jf);
                return;
            }
        }
        System.out.println("没有查询到该会员");
    }

    /**
     * 显示会员
     */
    public void show() {
        System.out.println("*******会员列表*******");
        System.out.println("编号\t\t积分");
        for (HuiYuan hy : list) {
            System.out.println(hy.bh + "\t\t" + hy.jf);
        }
    }
}
