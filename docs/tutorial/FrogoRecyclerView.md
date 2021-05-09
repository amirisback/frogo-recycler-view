# Tutorial How To Use FrogoRecyclerView
This is the procedure for using frogo-recycler-view

# Screen Shoot Apps

|           Main     |   No Adapter                 |   Multi View          | Empty View        |
|:------------------:|:----------------------------:|:---------------------:|:-----------------:|
|<span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_main.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_no-adapter.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_multi-view.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_empty.png"></span> |

# Usage (How to use this project)
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
    	
    	
### Step 3. Setup requirement (Multi Adapter)

#### List Value Option 
    const val OPTION_HOLDER_FIRST = 0
    const val OPTION_HOLDER_SECOND = 1

#### Kotlin (using injector singleton, with 2 custom view holder)

    private fun firstCallback(): IFrogoViewHolder<ExampleModel> {
        return object : IFrogoViewHolder<ExampleModel> {
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_1_tv_title).text = data.name
                Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(view.findViewById(R.id.frogo_rv_grid_type_1_iv_poster))
            }
        }
    }

    private fun secondCallback(): IFrogoViewHolder<ExampleModel> {
        return object : IFrogoViewHolder<ExampleModel>{
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_title).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_subtitle).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_desc).text = FrogoRvConstant.DUMMY_LOREM_IPSUM

                Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(view.findViewById<ImageView>(R.id.frogo_rv_grid_type_3_iv_poster))
            }
        }
    }

    private fun firstListenerType(): FrogoRecyclerViewListener<ExampleModel>{
        return object : FrogoRecyclerViewListener<ExampleModel>{
            override fun onItemClicked(data: ExampleModel) {
                showToast(data.name + " First")
            }

            override fun onItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 1")
            }
        }
    }

    private fun secondListenerType() : FrogoRecyclerViewListener<ExampleModel>{
        return object : FrogoRecyclerViewListener<ExampleModel>{
            override fun onItemClicked(data: ExampleModel) {
                showToast(data.name + " Second")
            }

            override fun onItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 2")
            }
        }
    }

    private fun data() : MutableList<FrogoHolder<ExampleModel>> {
        val data =  mutableListOf<FrogoHolder<ExampleModel>>()
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        return data
    }

    private fun setupFrogoRecyclerView() {
        activityFrogoRvGridBinding.frogoRecyclerView
            .injector<ExampleModel>()
            .addDataFH(data())
            .createLayoutStaggeredGrid(2)
            .build()
    }

#### Java (sample using ViewBinding)

    private static IFrogoViewHolder<ExampleModel> firstCallback() {
        return (view, data) -> {
            // Init component content item recyclerview
            TextView title = view.findViewById(R.id.frogo_rv_grid_type_1_tv_title);
            ImageView photo = view.findViewById(R.id.frogo_rv_grid_type_1_iv_poster);
            title.setText(data.getName());
            Glide.with(view.getContext()).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(photo);
        };
    }

    private static IFrogoViewHolder<ExampleModel> secondCallback() {
        return (view, data) -> {
            // Init component content item recyclerview
            TextView title = view.findViewById(R.id.frogo_rv_grid_type_3_tv_title);
            TextView subTitle = view.findViewById(R.id.frogo_rv_grid_type_3_tv_subtitle);
            TextView desc = view.findViewById(R.id.frogo_rv_grid_type_3_tv_desc);
            ImageView photo = view.findViewById(R.id.frogo_rv_grid_type_3_iv_poster);
            title.setText(data.getName());
            subTitle.setText(data.getName());
            desc.setText(FrogoRvConstant.DUMMY_LOREM_IPSUM);
            Glide.with(view.getContext()).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(photo);
        };
    }

    private FrogoRecyclerViewListener<ExampleModel> firstListenerType() {
        return new FrogoRecyclerViewListener<ExampleModel>() {
            @Override
            public void onItemLongClicked(ExampleModel data) {
                showToast(data.getName() + " First");
            }

            @Override
            public void onItemClicked(ExampleModel data) {
                showToast("LAYOUT TYPE 1");
            }
        };
    }

    private FrogoRecyclerViewListener<ExampleModel> secondListenerType() {
        return new FrogoRecyclerViewListener<ExampleModel>() {
            @Override
            public void onItemLongClicked(ExampleModel data) {
                showToast(data.getName() + " Second");
            }

            @Override
            public void onItemClicked(ExampleModel data) {
                showToast("LAYOUT TYPE 2");
            }
        };
    }

    private ArrayList<FrogoHolder<Object>> data() {
        ArrayList<FrogoHolder<Object>> data = new ArrayList<>();
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        return data;
    }

    private void setupFrogoRecyclerView() {
        activityFrogoRvGridBinding.frogoRecyclerView.injector()
                .addDataFH(data())
                .createLayoutStaggeredGrid(2)
                .build();
    }


# Sample Code 
## No Adapter
- Kotlin - [KotlinNoAdapterActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinNoAdapterActivity.kt)
- Java - [JavaNoAdapterActivity.java](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/javasample/JavaNoAdapterActivity.java)

## No Adapter (Multi-type-view)
- Kotlin - [KotlinNoAdapterMultiVewActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinNoAdapterMultiVewActivity.kt)
- Java - [JavaNoAdapterMultiViewActivity.java](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/javasample/JavaNoAdapterMultiViewActivity.java)

## With Adapter (Some function deprecated)
- Kotlin - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/kotlinsample/usingadapter)
- Java - [Using Adapter](https://github.com/amirisback/frogo-recycler-view/tree/master/app/src/main/java/com/frogobox/recycler/javasample/usingadapter)