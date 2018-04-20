package com.example.saba.sampleKotlin.mvi.actions


abstract class NavigatorAction<out Navigator>(protected val navigator: Navigator): Action {

    abstract fun commitNavigatorAction()

}
