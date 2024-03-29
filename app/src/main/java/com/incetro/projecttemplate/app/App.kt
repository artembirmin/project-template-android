/*
 * ProjectTemplate
 *
 * Created by artembirmin on 3/11/2022.
 */

package com.incetro.projecttemplate.app

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import com.incetro.projecttemplate.BuildConfig
import com.incetro.projecttemplate.common.di.componentmanager.ComponentsManager
import com.incetro.projecttemplate.presentation.ui.theme.Theme
import com.incetro.projecttemplate.utils.FileLoggingTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        inject()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.plant(FileLoggingTree(this))
        }
    }

    private fun inject() {
        ComponentsManager.init(this)
        ComponentsManager.getInstance().applicationComponent.inject(this)
    }

    companion object {
        val theme = mutableStateOf(Theme.SYSTEM)
    }
}