package com.gkreduction.cinemaapp.ui

import androidx.lifecycle.ViewModel
import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.usecase.cinema.GetListCinemaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var getListCinemaUseCase: GetListCinemaUseCase) :
    ViewModel() {

    private var getListDis: Disposable? = null


    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    private val disposables = CompositeDisposable()

    fun removeDisposable(disposable: Disposable) {
        disposables.remove(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun test() {
        if (getListDis != null)
            removeDisposable(getListDis!!)

        getListDis = getListCinemaUseCase
            .execute("")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Cinema>>() {
                override fun onSuccess(t: List<Cinema>) {
                    t.forEach {
                        println(it.name)
                        println(it.country)
                    }
                }


                override fun onError(e: Throwable) {
                }

            })
        addDisposable(getListDis!!)
    }
}