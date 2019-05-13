package json.novin.com.myvolley.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import json.novin.com.myvolley.Model.Model;
import json.novin.com.myvolley.R;

/**
 * Created by USER on 5/12/2019.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Model> models;

    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recy,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Model model = models.get(position);
        holder.textName.setText(model.getName());
        holder.textEmail.setText(model.getEmail());
        holder.textPhone.setText(model.getPhone());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textName,textEmail,textPhone;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = (TextView)itemView.findViewById(R.id.textName);
            textEmail = (TextView)itemView.findViewById(R.id.textEmail);
            textPhone = (TextView)itemView.findViewById(R.id.textPhone);
        }
    }
}
