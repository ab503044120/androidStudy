package com.huihui.common.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

/**
 * Created by YangZhenshan on 2016/5/5.
 */
public abstract class BaseActivity extends AppCompatActivity implements UIConvention {
    private View contentView;
    private View errorPage;
    private View emptyPage;
//    private LoadingDialog mLoadingDialog;
    /**
     * hanlder
     */
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    /**
     * 主线程id
     */
    public long UiThreadId = Thread.currentThread().getId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiThreadId = Thread.currentThread().getId();
        initBaseView();
        ButterKnife.bind(this);
        Bmob.initialize(this, "8ad1ef052449ddc4ed1e816201b4932b");
        initVariable();
        initView();
        initData();
    }


    private void initBaseView() {
//        setContentView(R.layout.common_super_layout);
//        contentView = View.inflate(this, getLayoutResId(), null);
//        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        ((RelativeLayout) findViewById(R.id.rly_root)).addView(contentView);
//        mLoadingDialog = new LoadingDialog(this);
//        mLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                onLoadingCancel();
//            }
//        });
        setContentView(getLayoutResId());
    }


    /**
     * 显示网络错误的界面
     */
    protected void showErrorPage() {
        contentView.setVisibility(View.GONE);
        if (emptyPage != null) {
            emptyPage.setVisibility(View.GONE);
        }
        if (errorPage == null) {
//            errorPage = ((ViewStub) findViewById(R.id.vs_error)).inflate();
        }
        errorPage.setVisibility(View.VISIBLE);

    }

    /**
     * 显示获取的数据为空的界面
     */
    protected void showEmptyPage() {
        contentView.setVisibility(View.GONE);
        if (errorPage != null) {
            errorPage.setVisibility(View.GONE);
        }
        if (emptyPage == null) {
//            emptyPage = ((ViewStub) findViewById(R.id.vs_empty)).inflate();
        }
        emptyPage.setVisibility(View.VISIBLE);
    }

    /**
     * 显示正常的界面
     */
    protected void hideEmptyOrErrorPage() {
        contentView.setVisibility(View.VISIBLE);
        if (errorPage != null) {
            errorPage.setVisibility(View.GONE);
        }
        if (emptyPage != null) {
            emptyPage.setVisibility(View.GONE);
        }
    }

    /**
     * 显示进度弹窗
     */
    public void showLoadingDialog() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
//                mLoadingDialog.show();
            }
        });
    }

    /**
     * 隐藏进度弹窗
     */
    public void hindLoadingDialog() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
//                mLoadingDialog.hide();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ButterKnife.unbind(this);
    }

    /**
     * 加载进度条被取消时会被调用
     */
    protected void onLoadingCancel(){}
}
