package com.example.sumsang_rookie.mytab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OperateAdapter extends RecyclerView.Adapter<OperateAdapter.ViewHolder> {
    private List<OperateItem> mOperateItems;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView operateImage;
        TextView operateName;

        public ViewHolder(View view) {
            super(view);
            operateImage = (ImageView) view.findViewById(R.id.operate_image);
            operateName = (TextView) view.findViewById(R.id.operate_name);

        }
    }

    public OperateAdapter(List<OperateItem> operateItems) {
        mOperateItems = operateItems;
    }

    @Override
    public OperateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.operate_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OperateItem operateItem = mOperateItems.get(position);
        holder.operateImage.setImageResource(operateItem.getImageId());
        holder.operateName.setText(operateItem.getOperateName());
    }

    @Override
    public int getItemCount() {
        return mOperateItems.size();
    }
}
