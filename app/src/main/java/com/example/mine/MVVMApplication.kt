package com.example.mine

import android.app.Application
import com.example.mine.data.db.entities.AppDatabase
import com.example.mine.data.network.MyApi
import com.example.mine.data.network.NetworkConnectionInterceptor
import com.example.mine.data.preferencis.PreferenceProvider
import com.example.mine.data.repository.QuotesRepository
import com.example.mine.data.repository.UserRepository
import com.example.mine.ui.AuthViewModelFactory
import com.example.mine.ui.profile.ProfileViewModelFactory
import com.example.mine.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider{ QuotesViewModelFactory(instance()) }



    }

}