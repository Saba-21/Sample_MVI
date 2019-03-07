package com.example.saba.sampleMVI.presentation.main.actions

import com.example.saba.sampleMVI.base.structure.actions.ViewStateAction
import com.example.saba.sampleMVI.presentation.main.MAIN_VIEW_DRAW_ADDING_SCREEN_STATE
import com.example.saba.sampleMVI.presentation.main.MainViewState

class DrawAddingScreenAction: ViewStateAction<MainViewState>() {

    override fun newState(oldState: MainViewState):
            MainViewState = oldState.copy(state = MAIN_VIEW_DRAW_ADDING_SCREEN_STATE)

}
