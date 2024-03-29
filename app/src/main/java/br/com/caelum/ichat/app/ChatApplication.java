package br.com.caelum.ichat.app;

import android.app.Application;

import br.com.caelum.ichat.component.ChatComponent;
import br.com.caelum.ichat.component.DaggerChatComponent;

public class ChatApplication extends Application {

    private ChatComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerChatComponent.builder().build();
    }

    public ChatComponent getComponent () {
        return component;
    }
}
