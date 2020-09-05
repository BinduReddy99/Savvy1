package com.hostelinfo.savvy.appkodin

import android.app.Application
import com.hostelinfo.savvy.data.network.NetworkConnectionInterceptor
import com.hostelinfo.savvy.data.sharedpreference.PreferenceProvider
import com.hostelinfo.savvy.ui.fragment.login.LoginViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.BuildConfig
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber


class BaseApplication() : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(applicationContext as BaseApplication))

        //override val kodein by lazy { (applicationContext as App).kodein }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { NetworkConnectionInterceptor(instance(), instance()) }
        bind() from singleton { LoginViewModelFactory() }
    }

   override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}