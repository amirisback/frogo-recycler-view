## FrogoComposeRecycler (Experimental)
- RecyclerView Using Jetpack Compose
- Sample Use [Click Here](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/apprecycler/sample/kotlin/compose/RecyclerComposeActivity.kt)

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
