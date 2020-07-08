package com.leopard.extension

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object RxHelper {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    fun <T> rxSchedulerHelper(): ObservableTransformer<T, T>? {    //compose简化线程
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        }
    }
}