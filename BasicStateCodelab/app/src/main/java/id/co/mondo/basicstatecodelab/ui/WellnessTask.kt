package id.co.mondo.basicstatecodelab.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class WellnessTask(val id: Int, val label: String,  initialCecked: Boolean = false){
    var checked by mutableStateOf(initialCecked)
}


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    list: List<WellnessTask>
){
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ){ task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = {
                    onCloseTask(task)
                },
                checked = task.checked,
                onCheckedChange = { checked ->
                    onCheckedTask(task, checked)
                }
            )
        }
    }
}