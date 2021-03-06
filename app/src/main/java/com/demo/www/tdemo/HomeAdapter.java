package com.demo.www.tdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by admin on 2017/8/22.
 */

public class HomeAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<String> list;

    public HomeAdapter(Context mContext, List list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).textView.setText(list.get(position));
            Drawable drawable = mContext.getResources().getDrawable(R.mipmap.ic_launcher);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((ViewHolder) holder).textView.setCompoundDrawables(null,drawable,null,null);

            ((ViewHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (position) {
                        case 0:
                            mContext.startActivity(new Intent(mContext,CommonScanActivity.class));
                            Toast.makeText(mContext, "0", Toast.LENGTH_LONG).show();
                            break;
                        case 1:
                            Toast.makeText(mContext, "1", Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            Toast.makeText(mContext, "2", Toast.LENGTH_LONG).show();
                            break;
                    }

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
