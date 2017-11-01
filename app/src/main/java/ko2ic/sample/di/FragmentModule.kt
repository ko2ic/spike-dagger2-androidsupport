package ko2ic.sample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ko2ic.sample.ui.fragments.SecondFragment

@Module
abstract class FragmentModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeSecondFragment(): SecondFragment

}
