# Tutorial How To Use FrogoRecyclerView
This is the procedure for using frogo-shimmer-recycler-view

# Screen Shoot Apps
<span align="center"><img width="200px" height="360px" src="docs/image/ss_main.png"></span>
<span align="center"><img width="200px" height="360px" src="docs/image/ss_no-adapter.png"></span>
<span align="center"><img width="200px" height="360px" src="docs/image/ss_multi-view.png"></span>
<span align="center"><img width="200px" height="360px" src="docs/image/ss_empty.png"></span>

# Usage (How to use this project)
Just following the step until finish
    
### Step 1. Create xml view
    
    <com.frogobox.recycler.widget.FrogoShimmerRecyclerView
        android:id="@+id/rv_shimmer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:frvClipToPadding="false"
        app:frvPaddingTop="@dimen/frogo_rv_dimen_16dp" 
        app:frvPaddingRight="@dimen/frogo_rv_dimen_16dp" 
        app:frvPaddingBottom="@dimen/frogo_rv_dimen_16dp"
        app:frvPaddingLeft="@dimen/frogo_rv_dimen_16dp" />
    	 	
    	 	
### Step 2. Setup requirement (Basic Adapter)

#### Kotlin (sample using ViewBinding)

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object :
            FrogoViewAdapterCallback<ExampleModel> {
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

        FrogoViewAdapterCallback frogoViewAdapterCallback = new FrogoViewAdapterCallback<ExampleModel>() {
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
    	
    	
### Step 3. Setup requirement (Multi Adapter)

#### List Value Option 
    const val OPTION_HOLDER_FIRST = 0
    const val OPTION_HOLDER_SECOND = 1

#### Kotlin (using injector singleton - sample using ViewBinding)

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object : FrogoViewAdapterMultiCallback<ExampleModel> {
            override fun setupFirstInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.tv_example_item).text = data.name
            }

            override fun setupSecondInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.tv_example_item).text = data.name
            }

            override fun onFirstItemClicked(data: ExampleModel) {
                showToast(data.name + " First")
            }

            override fun onFirstItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 1")
            }

            override fun onSecondItemClicked(data: ExampleModel) {
                showToast(data.name + " Second")
            }

            override fun onSecondItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 2")
            }
        }

        activityFrogoRvSampleBinding.frogoRecyclerView
            .injectorMulti<ExampleModel>()
            .addData(listData())
            .addCustomView(listLayout())
            .addOptionHolder(listOption())
            .addCallback(adapterCallback)
            .addEmptyView(null)
            .createLayoutLinearVertical(false)
            .build()
    }

#### Java (sample using ViewBinding)

    private void setupFrogoRecyclerView() {
        FrogoRecyclerView frogoRecyclerView = activityFrogoRvSampleBinding.frogoRecyclerView;

        frogoRecyclerView.injectAdapterMultiType(
                listData(),
                listLayout(),
                listOption(),
                null,
                new FrogoViewAdapterMultiCallback<ExampleModel>() {

                    @Override
                    public void setupFirstInitComponent(@NotNull View view, ExampleModel data) {
                        TextView tvExampleItem = findViewById(R.id.tv_example_item);
                        tvExampleItem.setText(data.getName());
                    }

                    @Override
                    public void onFirstItemClicked(ExampleModel data) {
                        showToast(data.getName() + " 1");
                    }

                    @Override
                    public void onFirstItemLongClicked(ExampleModel data) {
                        showToast(data.getName() + " First");
                    }

                    @Override
                    public void setupSecondInitComponent(@NotNull View view, ExampleModel data) {
                        TextView tvExampleItem = findViewById(R.id.tv_example_item);
                        tvExampleItem.setText(data.getName());
                    }

                    @Override
                    public void onSecondItemClicked(ExampleModel data) {
                        showToast(data.getName() + " 2");
                    }

                    @Override
                    public void onSecondItemLongClicked(ExampleModel data) {
                        showToast(data.getName() + " Second");
                    }
                }
        );
        frogoRecyclerView.isViewLinearVertical(false);

    }

# Sample Code 
## No Adapter
- Kotlin - https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinNoAdapterActivity.kt
- Java - https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/javasample/JavaNoAdapterActivity.java

## No Adapter (Multi-type-view)
- Kotlin - https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinNoAdapterMultiVewActivity.kt
- Java - https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/javasample/JavaNoAdapterMultiViewActivity.java

## With Adapter (Some function deprecated)
- Kotlin - https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/kotlinsample/usingadapter
- Java - https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/javasample/usingadapter