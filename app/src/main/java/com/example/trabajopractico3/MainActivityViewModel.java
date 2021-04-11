package com.example.trabajopractico3;

import android.app.assist.AssistStructure;
import android.view.View;
import android.widget.RadioButton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> convertidor;
    private MutableLiveData<Boolean> estadoETE;
    private MutableLiveData<Boolean> estadoETD;



    public LiveData<Boolean> getEstadoETE(){
        if(estadoETE==null){
            estadoETE=new MutableLiveData<>();
        }
        return estadoETE;
    }

    public LiveData<Boolean> getEstadoETD() {
        if (estadoETD == null) {
            estadoETD = new MutableLiveData<>();
        }
    return estadoETD;
    }

    public LiveData<String> getConvertidor(){
        if(convertidor==null){
            convertidor=new MutableLiveData<>();
        }
        return convertidor;
    }

    public void cambiarEstadoET(int idView, int rbDolar, int rbEuros){
      if(idView==rbDolar){
          estadoETD.setValue(true);
          estadoETE.setValue(false);
      }else {
          estadoETE.setValue(true);
          estadoETD.setValue(false);
      }
      }

    public void convertidor(Boolean rbDolar, String etDolar, String etEuros){

        if(rbDolar){
         Double dolar = Double.parseDouble(etDolar);
         Double resultado1= (dolar*91.41);
         convertidor.setValue(resultado1+" dolares");
        }else {
        Double euros = Double.parseDouble(etEuros);
        Double resultado= (euros*107.97);
        convertidor.setValue(resultado+" euros");
        }
        }

    }


