package com.example.cloudmusicdemo.found;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cloudmusicdemo.R;
import com.example.cloudmusicdemo.adapter.PlayListHeadAdapter;
import com.example.cloudmusicdemo.bean.PlaylistReponse;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Call;
import okhttp3.Response;


/**
 * 推荐
 */

public class PlayListFragment extends Fragment {
    List<PlaylistReponse.ResultsBean> playList;
    RecyclerView rl;
    LinearLayout parent_view;
    private PlayListHeadAdapter homeAdapter;
    int spanCount=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist, container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        rl= (RecyclerView) view.findViewById(R.id.rl);
        parent_view= (LinearLayout) view.findViewById(R.id.parent_view);
        getData();

    }

    private void getData() {
        HashMap<String, Integer> params = new HashMap<>();
        params.put("limit",6);
        JSONObject jsonObject = new JSONObject(params);
        String url = "https://leancloud.cn:443/1.1/classes/PlayList";
        OkGo.get(url)
                .tag(this)
                .headers("X-LC-Id", "kCFRDdr9tqej8FRLoqopkuXl-gzGzoHsz")
                .headers("X-LC-Key", "bmEeEjcgvKIq0FRaPl8jV2Um")
                .headers("Content-Type", "application/json")
                .params("limit",10)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.i("s",s);
                        Gson gson=new Gson();
                        PlaylistReponse p=gson.fromJson(s,PlaylistReponse.class);
                        playList=new ArrayList<>();
                        playList.addAll(p.getResults());

                        homeAdapter = new PlayListHeadAdapter(playList);
                        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.item_playlist_head,parent_view,false);
                        homeAdapter.setHeadView(headView);
                        GridLayoutManager manager= new GridLayoutManager(getActivity(),2);
                        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {
                                return position==0?2:1;
                            }
                        });
                        rl.setLayoutManager(manager);
                        rl.setAdapter(homeAdapter);
                    }


                });
    }

}
