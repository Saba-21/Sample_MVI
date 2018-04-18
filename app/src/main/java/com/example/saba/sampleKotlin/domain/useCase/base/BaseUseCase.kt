package com.example.saba.sampleKotlin.domain.useCase.base

import com.example.saba.sampleKotlin.domain.repository.Repository
import io.reactivex.Observable

abstract class BaseUseCase<in A, B>(protected val repository: Repository){

        abstract fun createObservable(arg: A): Observable<B>

}