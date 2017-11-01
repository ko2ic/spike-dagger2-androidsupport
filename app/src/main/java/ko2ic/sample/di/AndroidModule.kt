package ko2ic.sample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ko2ic.sample.ui.activities.MainActivity

@Module
abstract class AndroidModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}
