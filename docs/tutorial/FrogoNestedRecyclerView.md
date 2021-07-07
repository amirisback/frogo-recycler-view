## Tutorial How To Use FrogoNestedRecyclerView
This is the procedure for using frogo-nested-recycler-view

## Screen Shoot Apps

|           Menu     |   Nested Simple              |   Sample Nested 1     | Sample Nested 2   |
|:------------------:|:----------------------------:|:---------------------:|:-----------------:|
|<span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_nested_menu.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_nested_simple.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/sample_nested_1.gif"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/sample_nested_2.gif"></span> |

## Usage (How to use this project)
Just following the step until finish
    
### Step 1. Create xml view
    
    <com.frogobox.recycler.widget.FrogoRecyclerView
        android:id="@+id/frogo_recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    
    	 	
### Step 2. Setup Data

    private fun setupData(): MutableList<Int> {
       val subList1 = mutableListOf<Int>()
       for (i in 0..10) {
           subList1.add(i)
       }
       return subList1
    }

    private fun setupDataNested(): MutableList<MutableList<Int>> {
       val list = mutableListOf<MutableList<Int>>()
       for (i in 0..5) {
           list.add(setupData())
       }
       return list
    }

### Step 3. Setup RecyclerView

    private fun setupRecyclerView() {

        val mLinearLayoutManager = LinearLayoutManager(this)
        val mAdapter = FrogoNestedAdapter<Int>()
        mAdapter.setCallback(object : IFrogoNestedHolder<Int> {
            override fun nestedCustomView(): Int {
                return R.layout.cell_nested_list
            }

            override fun nestedListener(): FrogoRecyclerViewListener<Int> {
                return object : FrogoRecyclerViewListener<Int> {
                    override fun onItemClicked(data: Int) {
                        showToast("Click : $data")
                    }

                    override fun onItemLongClicked(data: Int) {
                        showToast("Long Click : $data")
                    }
                }
            }

            override fun nestedCallback(): IFrogoViewHolder<Int> {
                return object : IFrogoViewHolder<Int> {
                    override fun setupInitComponent(view: View, data: Int) {
                        Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB)
                            .into(view.findViewById(R.id.image))
                    }
                }
            }
        })
        mAdapter.setupNestedView()
        mAdapter.setupDataNested(setupDataNested())
        biinding.frogoRecyclerView.apply {
            layoutManager = mLinearLayoutManager
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }


## Sample Code
- Kotlin - [KotlinNestedActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/usingadapter/KotlinNestedActivity.kt)
- Kotlin - [KotlinSimpleNestedActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/usingadapter/KotlinSimpleNestedActivity.kt)
