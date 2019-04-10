package bwie.com.maojiaxiang0407;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import bwie.com.maojiaxiang0407.adapter.MlssAdapter;
import bwie.com.maojiaxiang0407.adapter.PzshAdapter;
import bwie.com.maojiaxiang0407.adapter.RxxpAdapter;
import bwie.com.maojiaxiang0407.bean.ShowBean;
import bwie.com.maojiaxiang0407.bean.XbannerBean;
import bwie.com.maojiaxiang0407.presenter.Presenter;
/*
* 毛佳翔
* 2019-04-07
* 多条目展示
* */
public class MainActivity extends AppCompatActivity {
    private Button login;
    private XBanner xBanner;
    private RecyclerView recy_view1;
    private RecyclerView recy_view2;
    private RecyclerView recy_view3;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_view1 = findViewById(R.id.rec_view1);
        recy_view2 = findViewById(R.id.rec_view2);
        recy_view3 = findViewById(R.id.rec_view3);
        xBanner = findViewById(R.id.xbanner);
        login = findViewById(R.id.login);
        //登录跳转
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //实例化P层
        presenter = new Presenter(this);
        presenter.getPre();
        recy_view1.setLayoutManager(new LinearLayoutManager(this));
        recy_view2.setLayoutManager(new LinearLayoutManager(this));
        recy_view3.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getShow(final String data) {
        runOnUiThread(new Runnable() {

            private List<ShowBean.ResultEntity.PzshEntity.CommodityListEntity> commodityList3;
            private List<ShowBean.ResultEntity.MlssEntity.CommodityListEntity> commodityList2;
            private List<ShowBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList1;

            @Override
            public void run() {
                Gson gson =new Gson();
                ShowBean showBean = gson.fromJson(data, ShowBean.class);
                commodityList1 = showBean.getResult().getRxxp().getCommodityList();
                RxxpAdapter rxxpAdapter = new RxxpAdapter(MainActivity.this,commodityList1);
                recy_view1.setAdapter(rxxpAdapter);

                commodityList2 = showBean.getResult().getMlss().getCommodityList();
                MlssAdapter mlssAdapter = new MlssAdapter(MainActivity.this,commodityList2);
                recy_view2.setAdapter(mlssAdapter);

                commodityList3 = showBean.getResult().getPzsh().getCommodityList();
                PzshAdapter pzshAdapter =new PzshAdapter(MainActivity.this,commodityList3);
                recy_view3.setAdapter(pzshAdapter);
            }
        });
    }

    public void getXbanner(final String data) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson =new Gson();
                final List<String> list =new ArrayList<>();
                XbannerBean xbannerBean = gson.fromJson(data, XbannerBean.class);
                List<XbannerBean.ResultEntity> result = xbannerBean.getResult();
                for (int i = 0; i < result.size(); i++) {
                    list.add(result.get(i).getImageUrl());
                }
                xBanner.setData(list,null);
                xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, View view, int position) {
                        Glide.with(MainActivity.this).load(list.get(position)).into((ImageView) view);
                    }
                });
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.datchview();
    }
}
