package id.co.mondo.basicstatecodelab.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import id.co.mondo.basicstatecodelab.StatefulCounter
import id.co.mondo.basicstatecodelab.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnewssViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = wellnewssViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnewssViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnewssViewModel.remove(task)})

    }
}




