package com.example.saba.sampleKotlin.presentation.main.actions

import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.main.MAIN_VIEW_DRAW_RESULT_SCREEN_STATE
import com.example.saba.sampleKotlin.presentation.main.MainViewState


class DrawResultScreenAction: ViewStateAction<MainViewState>() {

    override fun newState(oldState: MainViewState):
            MainViewState = oldState.copy(state = MAIN_VIEW_DRAW_RESULT_SCREEN_STATE)

}
