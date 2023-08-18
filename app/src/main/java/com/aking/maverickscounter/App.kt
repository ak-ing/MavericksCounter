package com.aking.maverickscounter

import android.app.Application
import com.airbnb.mvrx.Mavericks

/**
 * Created by Rick on 2023-08-17  10:37.<p>
 *
 * Description:
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }

}