package com.frogobox.apprecycler.sample.kotlin.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frogobox.apprecycler.model.People
import com.frogobox.apprecycler.sample.kotlin.noadapter.shimmer.KotlinShimmerActivity
import com.frogobox.apprecycler.ui.theme.FrogoRecyclerViewTheme
import com.frogobox.recycler.compose.FrogoLazyColumn
import com.frogobox.uikit.theme.dimen_8dp

class RecyclerComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    FrogoRecyclerViewTheme {
        FrogoLazyColumn(modifier = Modifier.padding(10.dp), data = setupData()) { data ->
            ListMessage(data)
        }
    }
}

@Composable
fun ListMessage(data: People) {
    val context = LocalContext.current
    Column(
        Modifier
            .padding(dimen_8dp)
            .clickable {
                context.startActivity(Intent(context, KotlinShimmerActivity::class.java))
            }) {
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