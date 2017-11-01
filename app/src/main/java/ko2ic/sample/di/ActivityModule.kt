package ko2ic.sample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ko2ic.sample.ui.activities.SecondActivity

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun contributeSecondActivity(): SecondActivity

}