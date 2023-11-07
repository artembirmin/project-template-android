package ${packageName}

import androidx.lifecycle.SavedStateHandle
import com.incetro.projecttemplate.common.navigation.FlowRouter
import com.incetro.projecttemplate.presentation.base.messageshowing.SideEffect
import com.incetro.projecttemplate.presentation.base.mvvm.viewmodel.BaseViewModel
import com.incetro.projecttemplate.presentation.base.mvvm.viewmodel.BaseViewModelDependencies
import com.incetro.projecttemplate.presentation.base.mvvm.viewmodel.INITIAL_STATE_KEY
import com.incetro.projecttemplate.presentation.base.mvvm.viewmodel.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container

class ${fragmentName}ViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val router: FlowRouter,
    baseViewModelDependencies: BaseViewModelDependencies
) : BaseViewModel<${fragmentName}FragmentViewState, SideEffect>(baseViewModelDependencies) {

    override val container: Container<${fragmentName}FragmentViewState, SideEffect> =
        container(
            initialState = savedStateHandle.get<${fragmentName}FragmentViewState>(INITIAL_STATE_KEY)
                ?: ${fragmentName}FragmentViewState(),
            savedStateHandle = savedStateHandle,
            buildSettings = {
                exceptionHandler = coroutineExceptionHandler
            },
            onCreate = { }
        )

    override fun onBackPressed() {
        router.exit()
    }

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<${fragmentName}ViewModel> {
        override fun create(handle: SavedStateHandle): ${fragmentName}ViewModel
    }
}