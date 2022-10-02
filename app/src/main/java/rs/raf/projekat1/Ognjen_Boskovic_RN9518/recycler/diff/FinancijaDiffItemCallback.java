package rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.diff;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;

public class FinancijaDiffItemCallback extends DiffUtil.ItemCallback<Financija> {
    @Override
    public boolean areItemsTheSame(@NonNull Financija oldItem, @NonNull Financija newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Financija oldItem, @NonNull Financija newItem) {
        return oldItem.getNaslov().equals(newItem.getNaslov())
                && oldItem.getKolicina() == newItem.getKolicina()
                && oldItem.getTip().equals(newItem.getTip());
    }
}
