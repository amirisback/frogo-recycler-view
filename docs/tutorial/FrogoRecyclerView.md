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
    
    	 	
### Step 2. Setup requirement (Basic Adapter)

#### Kotlin (sample using ViewBinding)

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

        activityFrogoRvSampleBinding.frogoRecyclerView
            .injector<ExampleModel>()
            .addData(listData())
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

#### Java (sample using ViewBinding)

    private void setupFrogoRecyclerView() {

        IFrogoViewAdapter frogoViewAdapterCallback = new IFrogoViewAdapter<ExampleModel>() {
            @Override
            public void setupInitComponent(@NotNull View view, ExampleModel data) {
                // Init component content item recyclerview
                TextView tvExample = view.findViewById(R.id.tv_example_item);
                tvExample.setText(data.getName());
            }

            @Override
            public void onItemClicked(ExampleModel data) {
                // setup item clicked on frogo recycler view
                showToast(data.getName());
            }

            @Override
            public void onItemLongClicked(ExampleModel data) {
                // setup item long clicked on frogo recycler view
                showToast(data.getName());
            }
        };

        activityFrogoRvSampleBinding.frogoRecyclerView
                .injector()
                .addData(listData())
                .addCustomView(R.layout.frogo_rv_list_type_1)
                .addEmptyView(null)
                .addCallback(frogoViewAdapterCallback)
                .createLayoutLinearVertical(false)
                .build();

    }

## Sample Code
### No Adapter
- Kotlin - [KotlinNoAdapterActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinNoAdapterActivity.kt)
- Java - [JavaNoAdapterActivity.java](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/javasample/JavaNoAdapterActivity.java)

### With Adapter (Some function deprecated)
- Kotlin - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/kotlinsample/usingadapter)
- Java - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/javasample/usingadapter)