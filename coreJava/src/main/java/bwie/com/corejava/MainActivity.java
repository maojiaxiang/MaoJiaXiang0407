package bwie.com.corejava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            List<String> list =new ArrayList<>();
            list.add("一寸光阴一寸金");
            for (int i = 0; i <10; i++) {
                Log.i("aa",list.toString());
            }


    }

}
