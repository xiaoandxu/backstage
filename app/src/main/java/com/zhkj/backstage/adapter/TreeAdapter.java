package com.zhkj.backstage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.ParentEntity;

import java.util.List;


public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.MyViewHolder>{
    Context context;
    List list;
    Integer layout;
    int[] to;

    public TreeAdapter(Context context, List<Object> list, Integer layout, int[] to){
        this.context = context;
        this.list = list;
        this.layout = layout;
        this.to = to;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickLitener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    @Override
    public TreeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater
                .from(context).inflate(layout, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(final TreeAdapter.MyViewHolder holder, int position) {
        if (list.get(position) instanceof ParentEntity){
            holder.child_name.setVisibility(View.GONE);
            holder.parent_name.setVisibility(View.VISIBLE);
            holder.iv_logo.setVisibility(View.VISIBLE);
            holder.iv_right.setVisibility(View.VISIBLE);
            ParentEntity parent = (ParentEntity) list.get(position);
            holder.parent_name.setText(parent.getName());
            if (parent.isSelect()){
                holder.iv_right.setImageResource(R.mipmap.down);
            }else {
                holder.iv_right.setImageResource(R.mipmap.zuo);
            }
        }else {
            holder.parent_name.setVisibility(View.GONE);
            holder.iv_logo.setVisibility(View.GONE);
            holder.iv_right.setVisibility(View.GONE);
            holder.child_name.setVisibility(View.VISIBLE);
            ParentEntity.ChildEntity child = (ParentEntity.ChildEntity) list.get(position);
            holder.child_name.setText(child.getName());
        }

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView parent_name;
        private TextView child_name;
        private ImageView iv_logo;
        private ImageView iv_right;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent_name = (TextView) itemView.findViewById(to[0]);
            child_name = (TextView) itemView.findViewById(to[1]);
            iv_logo = (ImageView) itemView.findViewById(to[2]);
            iv_right = (ImageView) itemView.findViewById(to[3]);

        }
    }

    /**
     * 添加所有child
     * @param lists
     * @param position
     */
    public void addAllChild(List<?> lists, int position) {
        list.addAll(position, lists);
        notifyItemRangeInserted(position, lists.size());
    }

    /**
     * 删除所有child
     * @param position
     * @param itemnum
     */
    public void deleteAllChild(int position, int itemnum) {
        for (int i = 0; i < itemnum; i++) {
            list.remove(position);
        }
        notifyItemRangeRemoved(position, itemnum);
    }
}
