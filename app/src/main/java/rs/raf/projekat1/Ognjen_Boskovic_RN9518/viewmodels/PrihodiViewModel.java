package rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Tip;

public class PrihodiViewModel extends ViewModel {

    private final MutableLiveData<List<Financija>> prihodi = new MutableLiveData<>();
    private final ArrayList<Financija> listaPrihoda = new ArrayList<>();
    public static int currIdx = 6;

    public PrihodiViewModel(){
        for(int i = 0 ; i <= 2 ; i++){
            Financija financija = new Financija(i, "Test", 500, Tip.PRIHOD, "Lalalalalalal");
            listaPrihoda.add(financija);
        }
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaPrihoda);
        prihodi.setValue(listToSubmit);


    }

    public int sumPrihod(){
        int sum = 0;
        for(Financija f : listaPrihoda){
            sum += f.getKolicina();
        }
        return sum;
    }

    public LiveData<List<Financija>> getPrihode(){
        return prihodi;
    }

    public void addPrihod(Financija prihod){
        listaPrihoda.add(prihod);
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaPrihoda);
        prihodi.setValue(listToSubmit);
    }

    public void removePrihod(Financija prihod){
        listaPrihoda.remove(prihod);
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaPrihoda);
        prihodi.setValue(listToSubmit);
    }

    public void editPrihod(int id, String naslov, int kolicina,String opis){
        for(Financija f : listaPrihoda){
            if(f.getId() == id){
                Financija prihod = new Financija(id, naslov, kolicina, Tip.PRIHOD, opis);
                listaPrihoda.remove(f);
                listaPrihoda.add(prihod);
            }
        }
        ArrayList<Financija> listToSubmit = new ArrayList<>(listaPrihoda);
        prihodi.setValue(listToSubmit);
    }


}
