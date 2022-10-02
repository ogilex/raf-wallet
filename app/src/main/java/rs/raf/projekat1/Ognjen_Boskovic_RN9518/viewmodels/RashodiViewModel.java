package rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Tip;

public class RashodiViewModel extends ViewModel {

    private final MutableLiveData<List<Financija>> rashodi = new MutableLiveData<>();
    private final ArrayList<Financija> listaRashoda = new ArrayList<>();

    public RashodiViewModel(){
        for(int i = 3 ; i <= 5 ; i++){
            Financija financija = new Financija(i, "Test", 200, Tip.RASHOD, "Laallalalalalal");
            listaRashoda.add(financija);
        }
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaRashoda);
        rashodi.setValue(listToSubmit);
    }

    public LiveData<List<Financija>> getRashode(){
        return rashodi;
    }

    public void addRashod(Financija reashod){
        listaRashoda.add(reashod);
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaRashoda);
        rashodi.setValue(listToSubmit);
    }

    public void removeRashod(Financija rashod){
        listaRashoda.remove(rashod);
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaRashoda);
        rashodi.setValue(listToSubmit);
    }

    public int sumRashod(){
        int sum = 0;
        for(Financija f : listaRashoda){
            sum += f.getKolicina();
        }
        return sum;
    }

    public void editRashod(int id, String naslov, int kolicina, String opis){
        for(Financija f : listaRashoda){
            if(f.getId() == id){
                Financija prihod = new Financija(id, naslov, kolicina, Tip.RASHOD, opis);
                listaRashoda.remove(f);
                listaRashoda.add(prihod);
            }
        }
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaRashoda);
        rashodi.setValue(listToSubmit);
    }

}
