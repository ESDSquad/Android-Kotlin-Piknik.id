package com.esdsquad.piknik

import android.app.Application
import com.esdsquad.piknik.data.viewmodel.factory.AuthenticationViewModelFactory
import com.esdsquad.piknik.data.viewmodel.factory.OnboardingViewModelFactory
import com.esdsquad.piknik.network.PiknikEndpoint
import com.esdsquad.piknik.network.PiknikRepository
import com.esdsquad.piknik.network.RetrofitClient
import com.esdsquad.piknik.storage.perferences.PiknikPreferences
import com.esdsquad.piknik.storage.persistence.PiknikDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class PiknikApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@PiknikApplication))

        bind<PiknikEndpoint>() with singleton { RetrofitClient.getClient() }
        bind() from singleton { PiknikPreferences(instance()) }
        bind() from singleton { PiknikDatabase(instance()) }
        bind() from singleton { PiknikRepository(instance(), instance(), instance()) }
        bind() from provider { OnboardingViewModelFactory(instance()) }
        bind() from provider { AuthenticationViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}