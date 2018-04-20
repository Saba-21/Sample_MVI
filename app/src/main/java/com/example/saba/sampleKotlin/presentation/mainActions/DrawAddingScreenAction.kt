package com.example.saba.sampleKotlin.presentation.mainActions

import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.MAIN_VIEW_DRAW_ADDING_SCREEN_STATE
import com.example.saba.sampleKotlin.presentation.MainViewState


class DrawAddingScreenAction: ViewStateAction<MainViewState>() {

    override fun newState(oldState: MainViewState):
            MainViewState = oldState.copy(state = MAIN_VIEW_DRAW_ADDING_SCREEN_STATE)

}
