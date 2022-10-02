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
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.viewholders.RashodViewHolder;

public class RashodAdapter extends ListAdapter<Financija, RashodViewHolder> {

    private final Function<Financija, Void> onDeleteClicked;
    private final Function<Financija, Void> onEditClicked;
    private final Function<Financija, Void> onItemClicked;

    public RashodAdapter(@NonNull DiffUtil.ItemCallback<Financija> diffCallback, Function<Financija, Void> onDeleteClicked, Function<Financija, Void> onEditClicked, Function<Financija, Void> onItemClicked) {
        super(diffCallback);
        this.onDeleteClicked = onDeleteClicked;
        this.onEditClicked = onEditClicked;
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public RashodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rashod_list_item, parent, false);
        return new RashodViewHolder(view, parent.getContext(), position -> {
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
    public void onBindViewHolder(@NonNull RashodViewHolder holder, int position) {

        Financija financija = getItem(position);

        holder.bind(financija);

    }
}
