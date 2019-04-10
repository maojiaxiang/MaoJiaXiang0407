package bwie.com.maojiaxiang0407.presenter;

import java.lang.ref.Reference;

import bwie.com.maojiaxiang0407.LoginActivity;
import bwie.com.maojiaxiang0407.MainActivity;
import bwie.com.maojiaxiang0407.api.Api;
import bwie.com.maojiaxiang0407.model.IModel;
import bwie.com.maojiaxiang0407.model.Model;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 16:01:45
 * @Description: 描述信息
 */
public class Presenter<T> implements IPresenter{
    //内存泄露
    private Reference<T>tReference;
    MainActivity mainActivity;
    private final Model model;

    LoginActivity loginActivity;

    public Presenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        model = new Model();
    }

    public Presenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        model = new Model();
    }

    @Override
    public void getPre() {
        model.getShow(Api.show_url, new IModel.ShowCallback() {
            @Override
            public void onSuccess(String data) {
                mainActivity.getShow(data);
            }
        });
    }

    @Override
    public void getXBanner() {
        model.getXbanner(Api.banner_url, new IModel.XBannerCallback() {
            @Override
            public void onSuccess(String data) {
                mainActivity.getXbanner(data);
            }
        });
    }

    @Override
    public void getLogin(String name, String pwd) {
        model.getLogin(Api.login_url, name, pwd, new IModel.LoginCallBack() {
            @Override
            public void onSuccess(String data) {
                loginActivity.getLogin(data);
            }
        });
    }
    //内存泄露
    public void datchview(){
        if (tReference!=null){
            tReference.clear();
            tReference=null;
        }
    }
}
