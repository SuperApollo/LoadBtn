package com.apollo.loadingbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.apollo.loadbutton.LoadingButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LoadingButton btn_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_load = (LoadingButton) findViewById(R.id.btn_load);
        btn_load.setLoadLisener(new LoadingButton.LoadListner() {
            @Override
            public void onClick(boolean isSuccess) {
                if (isSuccess) {
                    Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "加载失败", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void needLoading() {
                Toast.makeText(MainActivity.this, "重新下载", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_reset).setOnClickListener(this);
        findViewById(R.id.btn_test_successed).setOnClickListener(this);
        findViewById(R.id.btn_test_error).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reset:
                btn_load.reset();
                break;
            case R.id.btn_test_error:
                btn_load.loadFailed();
                break;
            case R.id.btn_test_successed:
                btn_load.loadSucceed();
                break;
        }
    }
}
