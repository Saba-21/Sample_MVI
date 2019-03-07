package com.example.saba.sampleMVI.base.structure.actions

abstract class NavigatorAction<out Navigator> constructor(protected val navigator: Navigator) : Action {
    abstract fun commitNavigatorAction()
}