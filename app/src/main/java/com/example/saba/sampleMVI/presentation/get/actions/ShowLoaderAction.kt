package com.example.saba.sampleMVI.presentation.get.actions

import com.example.saba.sampleMVI.base.structure.actions.ViewStateAction
import com.example.saba.sampleMVI.custom.SHOW_LOADER_STATE
import com.example.saba.sampleMVI.presentation.get.ResultViewState

class ShowLoaderAction: ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = SHOW_LOADER_STATE)

}
