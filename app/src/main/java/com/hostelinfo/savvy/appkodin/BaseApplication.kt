package com.hostelinfo.savvy.appkodin

import android.app.Application
import com.hostelinfo.savvy.data.network.NetworkConnectionInterceptor
import com.hostelinfo.savvy.data.sharedpreference.PreferenceProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


class BaseApplication() : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@BaseApplication))
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { NetworkConnectionInterceptor(instance(), instance()) }
    }
}