public class User {
    /**
     * 用户名
     */
    public String name;
    /**
     * 用户密码
     */
    public String password;

    public User() {
        System.out.println("***欢迎进入xxx系统***");
        System.out.println("\n*********注册********\n");
    }

    /**
     * 注册
     * 
     * @param name
     * @param password
     */
    public boolean register(String name, String password) {
        if (verify(name, password)) {
            this.name = name;
            this.password = password;
            System.out.println("注册成功！");
            return true;
        }
        System.out.println("注册失败！");
        return false;
    }

    /**
     * 登录
     * 
     * @param name
     * @param password
     * @return
     */
    public boolean login(String name, String password) {
        if (this.name == null || this.password == null) {
            System.out.println("请先注册！");
            return false;
        }
        return verify(name, password)
                // 校验用户名和密码是否合法
                && this.name.equalsIgnoreCase(name)
                // 判断用户名
                && this.password.equals(password);
        // 判断密码
    }

    /**
     * 校验
     * 
     * @param name
     * @param password
     * @return
     */
    public boolean verify(String name, String password) {
        if (name.length() < 3) {
            System.out.println("用户名长度应大于3！");
            return false;
        }
        if (password.length() < 6) {
            System.out.println("密码长度应大于6！");
            return false;
        }
        if(password.contains(name)) {
            System.out.println("密码不应包含用户名！");
            return false;
        }
        return true;
    }
}