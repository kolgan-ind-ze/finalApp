package com.example.finalapp.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.R;
import com.example.finalapp.database.DataBaseManager;

import org.w3c.dom.Text;

import java.util.List;

public class LabsAdapter extends RecyclerView.Adapter<LabsAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Labs> labs;
    DataBaseManager dbManager;

    public LabsAdapter(List<Labs> labs, Context context, DataBaseManager dbManager){
        this.labs = labs;
        this.inflater = LayoutInflater.from(context);
        this.dbManager = dbManager;
    }

    @NonNull
    @Override
    public LabsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabsAdapter.ViewHolder holder, int position) {
        dbManager = new DataBaseManager(holder.itemView.getContext());
        dbManager.openDB();
        Labs lab = labs.get(position);
        holder.id.setText(String.valueOf(lab.getId()));
        holder.name.setText(lab.getName());
        holder.link.setText(lab.getLink());
        boolean che;
        if (lab.getCheck().equals("+"))
            che = true;
        else
            che = false;
        holder.check.setChecked(che);
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = lab.getLink();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                view.getContext().startActivity(intent);
            }
        });
        holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (holder.check.isChecked()){
                    dbManager.openDB();
                    lab.setCheck("+");
                    dbManager.readyLab(lab);
                    dbManager.closeDB();
                }
                else{
                    dbManager.openDB();
                    lab.setCheck("-");
                    dbManager.readyLab(lab);
                    dbManager.closeDB();
                }
            }
        });
        dbManager.closeDB();
    }

    @Override
    public int getItemCount() {
        return labs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, link;
        CheckBox check;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.outputNumber);
            name = itemView.findViewById(R.id.outputName);
            link = itemView.findViewById(R.id.outputLink);
            check = itemView.findViewById(R.id.checkBoxReadyLab);
        }
    }
}
