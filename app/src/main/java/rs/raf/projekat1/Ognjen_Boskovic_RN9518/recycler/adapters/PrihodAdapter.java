package rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.function.Function;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.viewholders.PrihodViewHolder;
import timber.log.Timber;

public class PrihodAdapter extends ListAdapter<Financija, PrihodViewHolder> {

    private final Function<Financija, Void> onDeleteClicked;
    private final Function<Financija, Void> onEditClicked;
    private final Function<Financija, Void> onItemClicked;

    public PrihodAdapter(@NonNull DiffUtil.ItemCallback<Financija> diffCallback, Function<Financija, Void> onDeleteClicked, Function<Financija, Void> onEditClicked, Function<Financija, Void> onItemClicked) {
        super(diffCallback);
        this.onDeleteClicked = onDeleteClicked;
        this.onEditClicked = onEditClicked;
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public PrihodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prihod_list_item, parent, false);
        return new PrihodViewHolder(view, parent.getContext(), position -> {
            Financija financija = getItem(position);
            onDeleteClicked.apply(financija);
            return null;
        }, position2 -> {
            Financija financija = getItem(position2);
            onEditClicked.apply(financija);
            return null;
        }, position3 -> {
            Financija financija = getItem(position3);
            onItemClicked.apply(financija);
            return null;
        });
    }

    @Override
    public void onBindViewHolder(@NonNull PrihodViewHolder holder, int position) {
        Financija financija = getItem(position);

        holder.bind(financija);
    }

}
