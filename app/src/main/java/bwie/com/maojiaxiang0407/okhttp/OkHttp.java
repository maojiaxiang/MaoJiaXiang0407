package bwie.com.maojiaxiang0407.okhttp;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.Callback;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 15:55:48
 * @Description: 描述信息
 */
public class OkHttp {

    private final OkHttpClient client;

    public static void doGet(String url, okhttp3.Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //拦截器
    private Interceptor getInterceptor(){
        Interceptor interceptor =new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i("++++","拦截前");
                Response response = chain.proceed(request);
                Log.i("++++","拦截器");
                return response;
            }
        };
        return interceptor;
    }
    //添加拦截器
    private OkHttp(){
        client =new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .connectTimeout(3000,TimeUnit.SECONDS)
                .writeTimeout(3000,TimeUnit.SECONDS)
                .readTimeout(3000,TimeUnit.SECONDS)
                .build();
    }
    public static void doPost(String url, String name, String pwd, okhttp3.Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody build = new FormBody.Builder().add("phone", name).add("pwd", pwd).build();
        Request request = new Request.Builder().url(url).post(build).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
