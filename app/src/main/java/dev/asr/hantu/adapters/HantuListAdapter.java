package dev.asr.hantu.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import dev.asr.hantu.R;
import dev.asr.hantu.models.Hantu;

public class HantuListAdapter extends RecyclerView.Adapter<HantuListAdapter.ListViewHolder> {

    public interface OnItemClickCallback {
        void onItemClicked(Hantu data);
    }
    private OnItemClickCallback onItemClickCallback;
    private ArrayList<Hantu> listHantu;

    public HantuListAdapter(ArrayList<Hantu> hantu) {
        this.listHantu = hantu;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hantu hantu = listHantu.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hantu.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(hantu.getName());
        holder.tvOrigin.setText(hantu.getOrigin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHantu.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHantu.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvOrigin;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvOrigin = itemView.findViewById(R.id.tv_item_origin);
        }
    }
}
