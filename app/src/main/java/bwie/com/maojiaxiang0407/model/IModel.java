package bwie.com.maojiaxiang0407.model;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 16:00:04
 * @Description: 描述信息
 */
public interface IModel {
    void getShow(String url,ShowCallback showCallback);
    interface ShowCallback{
        void onSuccess(String data);
    }

    void getXbanner(String url,XBannerCallback XBannerCallback);
    interface XBannerCallback{
        void onSuccess(String data);
    }

   void getLogin(String url,String name,String pwd,LoginCallBack loginCallBack);
    interface LoginCallBack{
        void onSuccess(String data);
    }
}
