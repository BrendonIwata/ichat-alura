package br.com.caelum.ichat.activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class EnviarMensagensCallback implements Callback<Void> {

    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {

    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {

    }
}
