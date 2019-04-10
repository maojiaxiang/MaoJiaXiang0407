package bwie.com.maojiaxiang0407.model;

import android.widget.LinearLayout;

import java.io.IOException;

import bwie.com.maojiaxiang0407.okhttp.OkHttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 16:00:48
 * @Description: 描述信息
 */
public class Model implements IModel{
    @Override
    public void getShow(String url, final ShowCallback showCallback) {
        OkHttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                showCallback.onSuccess(response.body().string());
            }
        });
    }

    @Override
    public void getXbanner(String url, final XBannerCallback XBannerCallback) {
        OkHttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                XBannerCallback.onSuccess(response.body().string());
            }
        });
    }

    @Override
    public void getLogin(String url, String name, String pwd, final LoginCallBack loginCallBack) {
            OkHttp.doPost(url, name, pwd, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    loginCallBack.onSuccess(response.body().string());
                }
            });
    }
}
