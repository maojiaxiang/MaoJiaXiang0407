package bwie.com.maojiaxiang0407.bean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 17:09:13
 * @Description: 描述信息
 */
public class LoginBean {

    /**
     * message : 注册成功
     * status : 0000
     */
    private String message;
    private String status;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
