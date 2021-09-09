## FrogoComposeRecycler (Experimental)
RecyclerView Using Jetpack Compose

## Tutorial
### FrogoLazyColumn

    FrogoLazyColumn(setupData()) { data ->
        ListMessage(data)
    }

### FrogoLazyRow

    FrogoLazyRow(setupData()) { data ->
        ListMessage(data)
    }

### FrogoLazyGrid

    FrogoLazyGrid(2,setupData()) { data ->
        ListMessage(data)
    }