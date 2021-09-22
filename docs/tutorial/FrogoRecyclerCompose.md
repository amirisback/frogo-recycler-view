## FrogoComposeRecycler (Experimental)
- RecyclerView Using Jetpack Compose
- Sample Use [Click Here](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/apprecycler/sample/kotlin/compose/RecyclerComposeActivity.kt)

## Tutorial
### FrogoLazyColumn
```kotlin
FrogoLazyColumn(setupData()) { data ->
    ListMessage(data)
}
```

### FrogoLazyRow
```kotlin
FrogoLazyRow(setupData()) { data ->
    ListMessage(data)
}
```

### FrogoLazyFixedGrid
```kotlin
FrogoLazyFixedGrid(2, setupData()) { data ->
    ListMessage(data)
}
```

### FrogoLazyAdaptiveGrid
```kotlin
FrogoLazyAdaptiveGrid(10.dp, setupData()) { data ->
    ListMessage(data)}
```