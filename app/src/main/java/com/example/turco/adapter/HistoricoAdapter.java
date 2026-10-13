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
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_adapter,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Jogador jogador = listaJogador.get(position);
        //
        //        if (jogador instanceof Capitao){
        //            holder.card.setBackground(ContextCompat.getDrawable(context,R.drawable.capitao_card));
        //        }
        //
        //        holder.posicao.setText(jogador.getPosicao());
        //        holder.num.setText(String.valueOf(jogador.getNumero()));
        //        holder.nome.setText(jogador.getNome());
        //
        //        Glide.with(holder.itemView)
        //                .load(jogador.getUrl())
        //                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listaHistorico.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    // TextView posicao;


        public MyViewHolder(View itemView){
            super(itemView);

            //nome = itemView.findViewById(R.id.nome);


        }
    }
}
