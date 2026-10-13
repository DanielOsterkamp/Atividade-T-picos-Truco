package com.example.turco.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.turco.Historico;
import com.example.turco.R;

import java.util.List;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.MyViewHolder> {

    private List<Historico> listaHistorico;
    private Context context;


    public HistoricoAdapter(List<Historico> lista, Context context){this.listaHistorico = lista; this.context = context; }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.historico_adapter,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         Historico historico = listaHistorico.get(position);

         holder.jogador1.setText(historico.getNome1());
         holder.jogador2.setText(historico.getNome2());
        holder.pontos1.setText(String.valueOf(historico.getPonto1()));
        holder.pontos2.setText(String.valueOf(historico.getPonto2()));
        holder.data.setText(historico.getData());
        holder.vencedor.setText("O vencedor é:" + historico.getVencedor());

    }

    @Override
    public int getItemCount() {
        return listaHistorico.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

         TextView jogador1;
        TextView jogador2;
        TextView pontos2;
        TextView pontos1;
        TextView data;
        TextView vencedor;


        public MyViewHolder(View itemView){
            super(itemView);

            jogador1 = itemView.findViewById(R.id.jogador1);
            jogador2 = itemView.findViewById(R.id.jogador2);
            pontos1 = itemView.findViewById(R.id.pontos1);
            pontos2 = itemView.findViewById(R.id.pontos2);
            data = itemView.findViewById(R.id.data);
            vencedor = itemView.findViewById(R.id.vencedor);


        }
    }
}
