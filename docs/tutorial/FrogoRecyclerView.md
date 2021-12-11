## Tutorial How To Use FrogoRecyclerView
This is the procedure for using frogo-recycler-view

## Screen Shoot Apps

|           Main     |   No Adapter                 |  Empty View       |
|:------------------:|:----------------------------:|:-----------------:|
|<img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_main.png"> | <img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_no-adapter.png"> | <img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_empty.png"> |

## Usage (How to use this project)
Just following the step until finish
    
### Step 1. Create xml view
    
    <com.frogobox.recycler.widget.FrogoRecyclerView
        android:id="@+id/frogo_recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    
    	 	
### Step 2. Setup requirement (No Adapter)


#### Kotlin Injector (R class)

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object :
            IFrogoViewAdapter<ExampleModel> {
            override fun setupInitComponent(
                view: View,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.name
            }

            override fun onItemClicked(
                view: View,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // setup item clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                showToast(data.name)
            }

            override fun onItemLongClicked(
                view: View,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // setup item long clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                showToast(data.name)
            }
        }

        binding.frogoRecyclerView
            .injector<ExampleModel>()
            .addData(listData())
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

#### Kotlin Injector (ViewBinding) Can't use emptyView
    private fun setupFrogoRecyclerBinding() {

        val adapterCallback = object : IFrogoBindingAdapter<ExampleModel, FrogoRvListType1Binding> {
            override fun setupInitComponent(
                binding: FrogoRvListType1Binding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                binding.frogoRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): FrogoRvListType1Binding {
                return FrogoRvListType1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun onItemClicked(
                binding: FrogoRvListType1Binding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // setup item clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                showToast(data.name)
            }

            override fun onItemLongClicked(
                binding: FrogoRvListType1Binding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // setup item long clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                showToast(data.name)
            }
        }

        binding.frogoRecyclerView.injectorBinding<ExampleModel, FrogoRvListType1Binding>()
            .addData(listDataBinding())
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()

    }

#### Kotlin Builder (R class)
    private fun setupRvBuilder() {
        binding.frogoRecyclerView.builderBinding(object :
            IFrogoBuilderRvBinding<ExampleModel, FrogoRvListType1Binding> {
            override fun setupData(): List<ExampleModel> {
                // Setup data FrogoRecyclerView
                return dataBuilderBinding
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                // Setup Layout Manager of FrogoRecyclerView
                return FrogoLayoutManager.linearLayoutVertical(context)
            }

            override fun setupInitComponent(
                binding: FrogoRvListType1Binding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                binding.frogoRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): FrogoRvListType1Binding {
                return FrogoRvListType1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun onItemClicked(
                binding: FrogoRvListType1Binding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // setup item clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                showToast(data.name)
            }

            override fun onItemLongClicked(
                binding: FrogoRvListType1Binding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                // setup item long clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                showToast(data.name)
            }

        })

    }

## Sample Code
### No Adapter
- Kotlin - [KotlinNoAdapterActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/sample/kotlin/noadapter/simple/KotlinNoAdapterActivity.kt)
- Java - [JavaNoAdapterActivity.java](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/sample/java/noadapter/JavaNoAdapterActivity.java)

### With Adapter (Some function deprecated)
- Kotlin - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/sample/kotlin/usingadapter)
- Java - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/sample/java/usingadapter)