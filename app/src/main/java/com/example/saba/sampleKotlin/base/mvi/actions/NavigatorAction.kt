package com.example.saba.sampleKotlin.base.mvi.actions

abstract class NavigatorAction<out Navigator> constructor(protected val navigator: Navigator) : Action {
    abstract fun commitNavigatorAction()
}