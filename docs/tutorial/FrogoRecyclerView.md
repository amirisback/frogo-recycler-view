## Tutorial How To Use FrogoRecyclerView
This is the procedure for using frogo-recycler-view

## Screen Shoot Apps

|           Main     |   No Adapter                 |  Empty View       |
|:------------------:|:----------------------------:|:-----------------:|
|<span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_main.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_no-adapter.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_empty.png"></span> |

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

        val adapterCallback = object : IFrogoViewAdapter<ExampleModel> {
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.tv_example_item).text = data.name
            }

            override fun onItemClicked(data: ExampleModel) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(data: ExampleModel) {
                // setup item long clicked on frogo recycler view
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
            override fun setupInitComponent(binding: FrogoRvListType1Binding, data: ExampleModel) {
                binding.frogoRvListType1TvTitle.text = data.name
                val context = binding.root.context
            }

            override fun setViewBinding(parent: ViewGroup): FrogoRvListType1Binding {
                return FrogoRvListType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
            }

            override fun onItemClicked(data: ExampleModel) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(data: ExampleModel) {
                // setup item long clicked on frogo recycler view
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
        binding.frogoRecyclerView.builder(object : FrogoBuilderRvListener<ExampleModel>{
            override fun setupData(): List<ExampleModel> {
                // Setup data FrogoRecyclerView
                return listData()
            }

            override fun setupCustomView(): Int {
                // Setup Custom View
                return R.layout.frogo_rv_list_type_1
            }

            override fun setupEmptyView(): Int? {
                // Setup Empty View
                return null
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                // Setup Layout Manager of FrogoRecyclerView
                return FrogoLayoutManager.linearLayoutVertical(context)
            }

            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.name
            }

            override fun onItemClicked(data: ExampleModel) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(data: ExampleModel) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }
        })
    }

## Sample Code
### No Adapter
- Kotlin - [KotlinNoAdapterActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinNoAdapterActivity.kt)
- Java - [JavaNoAdapterActivity.java](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/javasample/JavaNoAdapterActivity.java)

### With Adapter (Some function deprecated)
- Kotlin - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/kotlinsample/usingadapter)
- Java - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/javasample/usingadapter)