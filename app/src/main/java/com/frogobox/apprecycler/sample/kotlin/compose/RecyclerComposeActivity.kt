package com.frogobox.apprecycler.sample.kotlin.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.frogobox.apprecycler.model.People
import com.frogobox.apprecycler.ui.theme.FrogoRecyclerViewTheme
import com.frogobox.recycler.compose.FrogoRecyclerCompose

class RecyclerComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DefaultPreview() {
    FrogoRecyclerViewTheme {
        FrogoRecyclerCompose(setupData()) { data ->
            ListMessage(data)
        }
    }
}


@Composable
fun ListMessage(data: People) {
    Column() {
        Text(text = data.name)
        Text(text = data.role)
    }
}

fun setupData(): MutableList<People> {
    val data = mutableListOf<People>()
    data.add(People("Amir", "Programmer"))
    data.add(People("Amir", "Programmer"))
    data.add(People("Amir", "Programmer"))
    data.add(People("Amir", "Programmer"))
    data.add(People("Amir", "Programmer"))
    return data
}