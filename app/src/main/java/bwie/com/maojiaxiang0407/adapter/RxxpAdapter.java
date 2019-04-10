package bwie.com.maojiaxiang0407.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

import bwie.com.maojiaxiang0407.R;
import bwie.com.maojiaxiang0407.bean.ShowBean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 16:03:10
 * @Description: 描述信息
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    Context context;
    List<ShowBean.ResultEntity.RxxpEntity.CommodityListEntity> list;

    public RxxpAdapter(Context context, List<ShowBean.ResultEntity.RxxpEntity.CommodityListEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(),R.layout.rxxp_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getCommodityName());
        viewHolder.price.setText(list.get(i).getPrice()+"");
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView price;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);
        }
    }
}
