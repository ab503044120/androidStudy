package com.huihui.common.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by 陈松辉
 * <p>
 * Date : 2016/5/18
 * Time : 9:59
 */
public abstract class BaseRecycleViewAdapter<T, VH extends BaseRecycleViewAdapter.BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public Context mContext;
    public List<T> mDatas;


    /**
     * click listener
     */
    protected OnItemClickListener mOnItemClickListener;
    /**
     * long click listener
     */
    protected OnItemLongClickListener mOnItemLongClickListener;
    /**
     * mainlooper handler
     */
    private Handler handler = new Handler(Looper.getMainLooper());
    /**
     * 主线程id
     */
    private long uiThreadId = Thread.currentThread().getId();

    public BaseRecycleViewAdapter(Context mContext, List<T> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    /**
     * inflate a view by viewgroup ,id ,etc
     *
     * @param viewGroup
     * @param layoutId
     * @return
     */
    protected View inflateItemView(ViewGroup viewGroup, @LayoutRes int layoutId) {
        return inflateItemView(viewGroup, layoutId, false);
    }

    /**
     * inflate a view by viewgroup ,id ,etc
     *
     * @param viewGroup
     * @param layoutId
     * @param attach
     * @return
     */
    protected View inflateItemView(ViewGroup viewGroup, @LayoutRes int layoutId, boolean attach) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, attach);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void onBindData(VH holder, int position);

    @CallSuper
    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        onBindData(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onClick(holder.itemView, position);
                }

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemLongClickListener != null) {
                    mOnItemLongClickListener.onLongClick(holder.itemView, position);
                    return true;
                }

                return false;
            }
        });

    }

    public abstract VH onBindView(ViewGroup parent, int viewType);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onBindView(parent, viewType);
    }

    public void replaceData(List<T> datas) {
        mDatas = datas;
        refresh();
    }

    /**
     * 保证在主线程刷新数据
     */
    public void refresh() {
        if (Thread.currentThread().getId() == uiThreadId) {
            notifyDataSetChanged();
            return;
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });

    }

    /**
     * set a long click listener
     *
     * @param onItemLongClickListener
     */
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * set a click listener
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onClick(View view, int position);
    }

    public interface OnItemLongClickListener<T> {
        void onLongClick(View view, int position);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
