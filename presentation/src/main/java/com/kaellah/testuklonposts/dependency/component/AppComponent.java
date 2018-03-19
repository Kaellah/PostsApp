package com.kaellah.testuklonposts.dependency.component;



import com.kaellah.testuklonposts.BaseApplication;
import com.kaellah.testuklonposts.dependency.module.ActivityModule;
import com.kaellah.testuklonposts.dependency.module.ApiModule;
import com.kaellah.testuklonposts.dependency.module.AppModule;
import com.kaellah.testuklonposts.dependency.module.DataModule;
import com.kaellah.testuklonposts.dependency.module.NetworkModule;
import com.kaellah.testuklonposts.dependency.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ApiModule.class,
        NetworkModule.class,
        DataModule.class,
        ViewModelModule.class,
        ActivityModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseApplication> {

        abstract Builder appModule(AppModule module);

        @Override
        public abstract AppComponent build();

        @Override
        public void seedInstance(BaseApplication instance) {
            appModule(new AppModule(instance));
        }
    }

}
