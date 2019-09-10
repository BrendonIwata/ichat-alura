package br.com.caelum.ichat.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.ichat.app.ChatApplication;
import br.com.caelum.ichat.adapter.MensagemAdapter;
import br.com.caelum.ichat.callback.OuvirMensagensCallback;
import br.com.caelum.ichat.component.ChatComponent;
import br.com.caelum.ichat.modelo.Mensagem;
import br.com.caelum.ichat.service.ChatService;
import caelum.com.br.ichat_alura.R;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private int idDoCliente = 1;
    private List<Mensagem> mensagens;
    private ListView listaDeMensagens;

    @Inject
    ChatService chatService;

    private ChatComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChatApplication app = (ChatApplication) getApplication();
        component = app.getComponent();
        component.inject(this);

        listaDeMensagens = (ListView) findViewById(R.id.mensagem);

        mensagens = new ArrayList<>();

        MensagemAdapter adapter = new MensagemAdapter(idDoCliente, mensagens, this);

        listaDeMensagens.setAdapter(adapter);

        final EditText editText = (EditText) findViewById(R.id.et_texto);

        Button button = (Button) findViewById(R.id.btn_enviar);

        ouvirMensagens();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatService.enviar(new Mensagem(idDoCliente, editText.getText().toString())).enqueue(new EnviarMensagensCallback());
            }
        });
    }

    public void colocaNaLista(Mensagem mensagem) {
        mensagens.add(mensagem);
        MensagemAdapter adapter = new MensagemAdapter(mensagem.getId(), mensagens, this);
        listaDeMensagens.setAdapter(adapter);
        ouvirMensagens();
    }

    public void ouvirMensagens() {
        Call<Mensagem> call = chatService.ouvirMensagens();
        call.enqueue(new OuvirMensagensCallback(this));
    }
}
