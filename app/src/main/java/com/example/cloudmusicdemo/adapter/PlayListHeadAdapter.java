package com.example.cloudmusicdemo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cloudmusicdemo.PlayListActivity;
import com.example.cloudmusicdemo.R;
import com.example.cloudmusicdemo.bean.Home;
import com.example.cloudmusicdemo.bean.HomeResponse;
import com.example.cloudmusicdemo.bean.PlaylistReponse;

import java.util.ArrayList;
import java.util.List;

import image.SmartImageView;

/**
 * 固定头尾Adapter
 */
public class PlayListHeadAdapter extends RecyclerView.Adapter {
    private static final int TYPE_HEAD = 0;//头布局
    private static final int TYPE_FOOTER = 1;//尾布局
    private static final int TYPE_NORMAL = 2;//默认的布局


    List<PlaylistReponse.ResultsBean> playList;

    private View mHeadView;
    private View mFooterView;

    public PlayListHeadAdapter(List<PlaylistReponse.ResultsBean> playList) {
        this.playList = playList;
    }

    /**
     * 设置头部的View
     *
     * @param view 想要显示的View
     */
    public void setHeadView(View view) {
        mHeadView = view;
    }

    /**
     * 设置尾部的View
     *
     * @param view 想要显示的View
     */
    public void setFooterView(View view) {
        mFooterView = view;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeadView != null && position == 0) {
            return TYPE_HEAD;
        }
        if (mFooterView != null && position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //判断当前是否应该设置头布局
        if (viewType == TYPE_HEAD) {
            return new HeadViewHolder(mHeadView);
        }
        if (viewType == TYPE_FOOTER) {
            return new FooterViewHolder(mFooterView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist_child,parent,false);
        MyItemViewHolder itemViewHolder = new MyItemViewHolder(view);
        return itemViewHolder;
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


    class HeadViewHolder extends RecyclerView.ViewHolder {

        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }
    class MyItemViewHolder extends RecyclerView.ViewHolder{
            SmartImageView siv;
            TextView tv_album;
            public MyItemViewHolder(View itemView) {
                super(itemView);
                siv = (SmartImageView) itemView.findViewById(R.id.siv);
                tv_album = (TextView) itemView.findViewById(R.id.tv_album);

            }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //position   ==   0  mHeadView    HeadViewHolder

        //判断当前是否是头布局，如果是头布局，那么直接return
        if (isHead(position)) {
            return;
        }

        if (isFooter(position)) {
            return;
        }

        //这里需要注意，取值应该是从position-1 开始，因为position ==0 已经被mHeadView占用了
        if (mHeadView != null) {
            position = position - 1;
        }
        MyItemViewHolder itemViewHolder = (MyItemViewHolder) holder;
        final PlaylistReponse.ResultsBean playListBean = playList.get(position);
        String picUrl = playListBean.getPicUrl().getUrl();
        itemViewHolder.siv.setImageUrl(picUrl);
        itemViewHolder.tv_album.setText(playListBean.getName());

    }
    private boolean isHead(int position) {
        return mHeadView != null && position == 0;
    }

    private boolean isFooter(int position) {
        //getItemCount 获取item的个数
        return mFooterView != null && position == getItemCount() - 1;
    }

    @Override
    public int getItemCount() {
        return playList.size() + (mHeadView != null ? 1 : 0) + (mFooterView != null ? 1 : 0);
    }
}