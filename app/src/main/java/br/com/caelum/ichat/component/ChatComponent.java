package br.com.caelum.ichat.component;

import br.com.caelum.ichat.activity.MainActivity;
import br.com.caelum.ichat.module.ChatModule;
import dagger.Component;

@Component(modules = ChatModule.class)
public interface ChatComponent {

    void inject (MainActivity mainActivity);
}
