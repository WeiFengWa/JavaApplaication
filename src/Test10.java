public class Test10 {

    public static void main(String[] args) {

        Week week = Week.Saturday;
        String msg = "今天是";
        switch (week) {
            case Monday:
                msg += "星期一，心情郁闷";
                break;
            case Tuesday:
                msg += "星期二，心情不错";
                break;
            case Wednesday:
                msg += "星期三，心情好";
                break;
            case Thursday:
                msg += "星期四，心情非常好";
                break;
            case Friday:
                msg += "星期五，高兴得飞起来";
                break;
            case Saturday:
                msg += "星期六，心情异常兴奋";
                break;
            case Sunday:
                msg += "星期日，心情又开始郁闷";
                break;
        }
        System.out.println(msg);
    }
}
