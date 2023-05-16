package com.trinity_wizard.app.di

import android.content.Context
import com.trinity_wizard.app.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * @author basyi
 * Created 5/16/2023 at 4:04 PM
 */

@Module
@InstallIn(ViewModelComponent::class, ServiceComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(@ApplicationContext context: Context) = MainRepository(context)
}