package com.vaca.tablayout

import android.view.View

object Ex {

    fun <T : View> T.singleClick(triggerDelay: Long = 400L, click: (view: T) -> Unit) {
        setOnClickListener {
            isClickable = false
            click(it as T)
            postDelayed({
                isClickable = true
            }, triggerDelay)
        }
    }


}