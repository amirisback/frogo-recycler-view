# FrogoRecyclerViewAdapter by Amirisback
FrogoRecyclerViewAdapter Extends RecyclerViewAdapter
- v1.0.0 - Development

# About This Project
- Easy Adapter Base On RecyclerViewAdapter
- SImple RecyclerViewAdapter
- No longer requires variable declarations
- Just setupRequirement()

# Android Library Version (build.gradle)
- ext.kotlin_version = '1.3.61'
- classpath 'com.android.tools.build:gradle:3.5.3'
- compileSdkVersion 29
- buildToolsVersion "29.0.1"
- minSdkVersion 21

# Version Release
This Is Latest Release

    $version_release = 1.0.0


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
	        implementation 'com.github.amirisback:frogo-recycler-view-adapter:$version_release'
	}
	
	
<h3>Sample Code Adapter</h3>

    class ExampleViewAdapter : FrogoRecyclerViewAdapter<String>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): FrogoRecyclerViewHolder<String> {
            return ExampleViewHolder(viewLayout(parent))
        }
    
        inner class ExampleViewHolder(view: View) : FrogoRecyclerViewHolder<String>(view) {
    
            private val tvExampleItem = view.tv_example_item
    
            override fun initComponent(data: String) {
                super.initComponent(data)
    
                tvExampleItem.text = data

            }
        }
    }

<h3>Sample Code Activity</h3>

    class MainActivity : AppCompatActivity(), FrogoRecyclerViewListener<String> {
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            setupAdapter()
        }
    
        private fun listData(): MutableList<String> {
            val listString = mutableListOf<String>()
            listString.add("Example")
            listString.add("Example")
            listString.add("Example")
            listString.add("Example")
            return listString
        }
    
        private fun setupAdapter() {
            val adapter = ExampleViewAdapter()
            adapter.setupRequirement(this, listData(), R.layout.example_list_item)
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(this)
        }
    
        override fun onItemClicked(data: String) {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    
        override fun onItemLongClicked(data: String) {
            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }
    
    }
    
    
# Screen Shoot Apps
![ScreenShoot Apps](docs/ss_apps.jpg?raw=true)

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