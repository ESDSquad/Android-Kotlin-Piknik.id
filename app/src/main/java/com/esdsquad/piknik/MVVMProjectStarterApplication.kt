package com.esdsquad.piknik

import android.app.Application
import com.esdsquad.piknik.data.viewmodel.factory.ExampleViewModelFactory
import com.esdsquad.piknik.network.ExampleEndpoint
import com.esdsquad.piknik.network.ExampleRepository
import com.esdsquad.piknik.network.RetrofitClient
import com.esdsquad.piknik.storage.perferences.ExamplePreferences
import com.esdsquad.piknik.storage.persistence.ExampleDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class MVVMProjectStarterApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMProjectStarterApplication))

        bind<ExampleEndpoint>() with singleton { RetrofitClient.getClient() }
        bind() from singleton { ExamplePreferences(instance()) }
        bind() from singleton { ExampleDatabase(instance()) }
        bind() from singleton { ExampleRepository(instance(), instance(), instance()) }
        bind() from provider { ExampleViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}