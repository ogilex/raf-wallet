package rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.function.Function;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;

public class PrihodViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private ImageView deleteIv;
    private ImageView editIv;

    public PrihodViewHolder(@NonNull View itemView, Context context, Function<Integer, Void> onDeleteClicked, Function<Integer, Void> onEditClicked, Function<Integer, Void> onItemClicked) {
        super(itemView);
        this.context = context;
        deleteIv = itemView.findViewById(R.id.removePrihodIv);
        editIv = itemView.findViewById(R.id.editPrihodIv);

        itemView.setOnClickListener(v -> {
            onItemClicked.apply(getAdapterPosition());
        });
        deleteIv.setOnClickListener(v -> {
            onDeleteClicked.apply(getAdapterPosition());
        });
        editIv.setOnClickListener(v -> {
            onEditClicked.apply(getAdapterPosition());
        });
    }

    public void bind(Financija financija){
        ((TextView) itemView.findViewById(R.id.naslovPrihodTv)).setText(financija.getNaslov());
        ((TextView) itemView.findViewById(R.id.kolicinaPrihodTv)).setText(financija.getKolicina()+"");
    }
}
