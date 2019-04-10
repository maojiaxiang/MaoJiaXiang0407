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

import bwie.com.maojiaxiang0407.R;
import bwie.com.maojiaxiang0407.bean.ShowBean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/7 16:13:47
 * @Description: 描述信息
 */
public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.ViewHolder> {
    Context context;
    List<ShowBean.ResultEntity.MlssEntity.CommodityListEntity> mlssBeans;

    public MlssAdapter(Context context, List<ShowBean.ResultEntity.MlssEntity.CommodityListEntity> mlssBeans) {
        this.context = context;
        this.mlssBeans = mlssBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(),R.layout.mlss_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mlssBeans.get(i).getCommodityName());
        viewHolder.price.setText(mlssBeans.get(i).getPrice()+"");
        Glide.with(context).load(mlssBeans.get(i).getMasterPic()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return mlssBeans.size();
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
