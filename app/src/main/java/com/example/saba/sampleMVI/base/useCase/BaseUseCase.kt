package com.example.saba.sampleMVI.base.useCase

import com.example.saba.sampleMVI.domain.repository.Repository
import io.reactivex.Observable

abstract class BaseUseCase<in A, B>(protected val repository: Repository){

        abstract fun createObservable(arg: A): Observable<B>

}