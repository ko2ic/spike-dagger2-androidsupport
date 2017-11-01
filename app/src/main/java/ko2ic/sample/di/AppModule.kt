package ko2ic.sample.di

import dagger.Module
import dagger.Provides
import ko2ic.sample.App


@Module
class AppModule {

    @Provides
    fun provideContext(application: App) = application.applicationContext
}