package com.project.shkproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.shkproject.R;
import com.project.shkproject.Response.HK11Response;

import java.util.ArrayList;

public class HK11Adapter extends RecyclerView.Adapter<HK11Adapter.Viewholder>{

    private ArrayList<HK11Response> items;
    private Context context;

    public HK11Adapter(ArrayList<HK11Response> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HK11Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hk11,parent,false);
        Log.e("EntriActivity", "data: Masuk view holder" );

        return new HK11Adapter.Viewholder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull HK11Adapter.Viewholder holder, int position) {
        HK11Response response = items.get(position);
        String hargaSeb = String.valueOf(response.getHargaSebelum());
        String hargaSud = String.valueOf(response.getHargaSekarang());

        Log.e("EntriActivity", "data: " + response.getKodeKualitas() );
        holder.kodeKualitas.setText(response.getKodeKualitas().toString());
        holder.komoditas.setText(response.getKomoditas().toString());
        holder.kualitas.setText(response.getKualitas().toString());
        holder.hargaSebelum.setText(hargaSeb);
        holder.hargaSekarang.setText(hargaSud);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView kodeKualitas, komoditas, kualitas, hargaSebelum, hargaSekarang;
        LinearLayout layout;

        public Viewholder (@NonNull View itemView){
            super(itemView);
            kodeKualitas = itemView.findViewById(R.id.kodeKualitasTxt);
            komoditas = itemView.findViewById(R.id.komoditasTxt);
            kualitas = itemView.findViewById(R.id.kualitasTxt);
            hargaSebelum = itemView.findViewById(R.id.hargaSebelumTxt);
            hargaSekarang = itemView.findViewById(R.id.hargaSekarangTxt);
        }

    }
}
