# Tutorial How To Use FrogoProgressRecyclerView
This is the procedure for using frogo-progress-recycler-view

# Screen Shoot Apps

|        Menu       |             Sample Progress  |
|:------------------:|:----------------------------:|
|<span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/ss_main.png"></span> | <span align="center"><img width="200px" height="360px" src="https://raw.githubusercontent.com/amirisback/frogo-recycler-view/master/docs/image/sample_progress.gif"></span> |

# Usage (How to use this project)
Just following the step until finish, for basic adapter using step 2, for multi adapter using step 3

### Step 1. Create xml view

    <com.frogobox.recycler.widget.FrogoProgressRecyclerView
        android:id="@+id/rv_progress"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:frvClipToPadding="false"
        app:frvPaddingTop="@dimen/frogo_dimen_16dp"
        app:frvPaddingRight="@dimen/frogo_dimen_16dp"
        app:frvPaddingBottom="@dimen/frogo_dimen_16dp"
        app:frvPaddingLeft="@dimen/frogo_dimen_16dp" />

### Step 2. Setup frogo-progress-recycler-view data
    private fun setupFrogoProgressRecyclerView(data: List<Article>) {

        val adapterCallback = object :
            IFrogoViewAdapter<Article> {
            override fun setupInitComponent(view: View, data: Article) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.title
            }

            override fun onItemClicked(data: Article) {
                // setup item clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(data: Article) {
                // setup item long clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }
        }

        activityKotlinProgressBinding.rvProgress.defineRecyclerView<Article>()
            .addData(data)
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

### Step 3. Setup doing progress
    private fun setupProgress(state: Boolean) {
        activityKotlinProgressBinding.apply {
            if (state) {
                rvProgress.showProgress()
            } else {
                rvProgress.hideProgress()
            }
        }
    }

# Sample Code
- Kotlin - [KotlinShimmerActivity.kt](https://github.com/amirisback/frogo-recycler-view/blob/master/app/src/main/java/com/frogobox/recycler/kotlinsample/KotlinProgressActivity.kt)
- Java - being developed