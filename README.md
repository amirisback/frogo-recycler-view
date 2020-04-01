# FrogoRecyclerView by Amirisback
FrogoRecyclerView Extends RecyclerView
- v2.1.1 - Development
- Stable Version

# About This Project
- Easy Adapter Base On RecyclerViewAdapter
- Simple RecyclerViewAdapter
- No longer requires variable declarations
- Just setupRequirement()

# Special From This Custom View

    // Setup linear vertical recycler view
    fun isViewLinearVertical(dividerItem: Boolean) {}

    // Setup linear horizontal recycler view
    fun isViewLinearHorizontal(dividerItem: Boolean) {}

    // Setup staggered grid recycler view
    fun isViewStaggeredGrid(spanCount: Int) {}

    // Setup grid recycler view
    fun isViewGrid(spanCount: Int) {}

# Function Main From This Project

    FrogoRecyclerView - In XML file
    FrogoRecyclerViewAdapter<T> - Extend From RecyclerViewAdapter
    FrogoRecyclerViewHolder<T> - Extend From ReyclerView.ViewHolder
    FrogoRecyclerViewListener<T> - Interface for callback function from ViewHolder
    
# You can just use the adapter
only extending FrogoRecyclerViewAdapter<T> to your adapter and using RecyclerView ordinary

## Interface FrogoAdapterView

    // Setup adapter requirement
    fun setupRequirement(
        layoutItem: Int,
        dataList: List<T>?,
        viewListener: FrogoRecyclerViewListener<T>?
    )

    // Setup empty view for layout
    fun setupEmptyView(emptyView: Int?)

    // Setup view layout
    fun viewLayout(parent: ViewGroup): View

## Interface FrogoHolderView

    // bind item data
    fun bindItem(data: T?, listener: FrogoRecyclerViewListener<T>?)

    // setup on item view clicked
    fun onItemViewClicked(data: T?, listener: FrogoRecyclerViewListener<T>?)

    // Initiation all component
    fun initComponent(data: T)


# Android Library Version (build.gradle)
- ext.kotlin_version = '1.3.71'
- classpath 'com.android.tools.build:gradle:3.6.1'
- compileSdkVersion 29
- buildToolsVersion "29.0.3"
- minSdkVersion 21

# Version Release
This Is Latest Release

    $version_release = 2.1.1

What's New??

    * Bug Fixed *
    * Sorting parameters setupRequirement"


# How To Use This Project
<h3>Step 1. Add the JitPack repository to your build file</h3>

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
<h3>Step 2. Add the dependency</h3>

	dependencies {
	        // library google
	        implementation 'com.google.android.material:material:${latest_version_android}'
            implementation 'androidx.legacy:legacy-support-v4:${latest_version_android}'

            // library frogo-recycler-view
	        implementation 'com.github.amirisback:frogo-recycler-view:${version_release}'
	}
	
		
<h3>Step 3. Create xml view</h3>

    <com.frogobox.recycler.FrogoRecyclerView 
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
	
<h3>Step 4. Create adapter</h3>

	(Kotlin) - class KotlinSampleViewAdapter : FrogoRecyclerViewAdapter<ExampleModel>() {
	(Java) - public class JavaSampleViewAdapter extends FrogoRecyclerViewAdapter<ExampleModel> {

<h3>Step 5. Create Activity Or Fragment</h3>

	(Kotlin) - class KotlinSampleActivity : AppCompatActivity(), FrogoRecyclerViewListener<ExampleModel> {
	(Java) - public class JavaSampleActivity extends AppCompatActivity implements FrogoRecyclerViewListener<ExampleModel> {
	
<h3>FrogoRecyclerViewAdapter Special Use Function</h3>

    // Setup adapter requirement
    fun setupRequirement(
        layoutItem: Int,
        dataList: List<T>?,
        viewListener: FrogoRecyclerViewListener<T>?
    )

    // Setup empty view for layout
    fun setupEmptyView(emptyView: Int?)
    
# Sample Code Kotlin and Java

## Kotlin
<h3>Sample Code Adapter (Kotlin)</h3>

    class KotlinSampleViewAdapter : FrogoRecyclerViewAdapter<ExampleModel>() {
    
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): FrogoRecyclerViewHolder<ExampleModel> {
            return KotlinSampleViewHolder(viewLayout(parent))
        }
    
        inner class KotlinSampleViewHolder(view: View) : FrogoRecyclerViewHolder<ExampleModel>(view) {
    
            private val tvExampleItem = view.tv_example_item
    
            override fun initComponent(data: ExampleModel) {
                super.initComponent(data)
    
                tvExampleItem.text = data.name
    
            }
        }
    
    }
    
    
<h3>Sample Code Activity (Kotlin)</h3>

    class KotlinSampleActivity : AppCompatActivity() {
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_frogo_rv_sample)
            setupAdapter()
        }
    
        private fun listData(): MutableList<ExampleModel> {
            val listString = mutableListOf<ExampleModel>()
            listString.add(ExampleModel(Constant.FULL_NAME))
            listString.add(ExampleModel(Constant.FULL_NAME))
            listString.add(ExampleModel(Constant.FULL_NAME))
            listString.add(ExampleModel(Constant.FULL_NAME))
            return listString
        }
    
        private fun setupAdapter() {
            val adapter =
                KotlinSampleViewAdapter()
            adapter.setupRequirement(
                R.layout.example_list_item,
                listData(),
                object : FrogoRecyclerViewListener<ExampleModel> {
                    override fun onItemClicked(data: ExampleModel) {
                        Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                    }
    
                    override fun onItemLongClicked(data: ExampleModel) {
                        Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                    }
                }
            )
            adapter.setupEmptyView(R.layout.example_empty_view) // With Custom View
            frogo_recycler_view.adapter = adapter
            frogo_recycler_view.isViewLinearVertical(false)
        }
    
    }
    
## Java    
<h3>Sample Code Adapter (Java)</h3>

    public class JavaSampleViewAdapter extends FrogoRecyclerViewAdapter<ExampleModel> {
        @NonNull
        @Override
        public FrogoRecyclerViewHolder<ExampleModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new JavaSampleViewHolder(viewLayout(parent));
        }
    
        static class JavaSampleViewHolder extends FrogoRecyclerViewHolder<ExampleModel> {
    
            private TextView tvExample = itemView.findViewById(R.id.tv_example_item);
    
            JavaSampleViewHolder(@NotNull View view) {
                super(view);
            }
    
            @Override
            public void initComponent(ExampleModel data) {
                super.initComponent(data);
    
                tvExample.setText(data.getName());
    
            }
        }
    
    }

<h3>Sample Code Activity (Java)</h3>

    public class JavaSampleActivity extends AppCompatActivity {
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_frogo_rv_sample);
            setupAdapter();
        }
    
        private ArrayList<ExampleModel> listData() {
            ArrayList<ExampleModel> exampleModels = new ArrayList<>();
            exampleModels.add(new ExampleModel(Constant.NICK_NAME));
            exampleModels.add(new ExampleModel(Constant.NICK_NAME));
            exampleModels.add(new ExampleModel(Constant.NICK_NAME));
            exampleModels.add(new ExampleModel(Constant.NICK_NAME));
            return exampleModels;
        }
    
        private void setupAdapter() {
            JavaSampleViewAdapter adapter = new JavaSampleViewAdapter();
            adapter.setupRequirement(R.layout.example_list_item, listData(), new FrogoRecyclerViewListener<ExampleModel>() {
                @Override
                public void onItemClicked(ExampleModel data) {
                    Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
                }
    
                @Override
                public void onItemLongClicked(ExampleModel data) {
                    Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_LONG).show();
                }
            });
            adapter.setupEmptyView(null); // Without Custom View
            FrogoRecyclerView recyclerView = findViewById(R.id.frogo_recycler_view);
            recyclerView.setAdapter(adapter);
            recyclerView.isViewLinearVertical(false);
        }
    
    }

    
# Extension Resource

## drawable
    frogo_rv_bg_card.xml
    
## values
### dimens
### colors
### strings
## layout

    
# Screen Shoot Apps
<span align="center"><img width="200px" height="360px" src="docs/ss_apps.jpg"></span>
<span align="center"><img width="200px" height="360px" src="docs/ss_empty_view_sample.jpg"></span>
<span align="center"><img width="200px" height="360px" src="docs/ss_empty_view_custom.jpg"></span>

# Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

# Attention !!!
Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account