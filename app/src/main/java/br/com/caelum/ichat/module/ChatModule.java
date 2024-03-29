package br.com.caelum.ichat.module;

import br.com.caelum.ichat.service.ChatService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ChatModule {

    @Provides
    public ChatService getChatService () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.37:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatService chatService = retrofit.create(ChatService.class);
        return chatService;
    }
}
