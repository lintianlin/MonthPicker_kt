[English](https://github.com/lintianlin/MonthPicker) | **中文版** </br>
MonthPicker
==========
    一个简单的月份选择控件
简介
============
可以很方便直观的选择某一年中的月份
  
截图
===========
<div align=center><img width="216" height="384" src="https://github.com/lintianlin/MonthPicker/blob/master/Gif/monthpicker2.gif"/></div>   


## Gradle 
		allprojects {
    		repositories {
        		maven { url 'https://jitpack.io' }
				...
    		}
		}
###
		dependencies{
			compile 'com.github.lintianlin:MonthPicker_kt:v1.0'
		 }
 
      
## 用法
      <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    	android:layout_width="match_parent"
    	android:layout_height="match_parent">

    	<com.sinfeeloo.monthpickerforkt.MonthPicker
        	android:id="@+id/monthPicker"
        	android:layout_width="match_parent"
        	android:layout_height="wrap_content" />

	</LinearLayout>

###
	import kotlinx.android.synthetic.main.activity_main.*

	class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        monthPicker.setOnMonthSelectEventListener(object : MonthPicker.OnMonthSelectEventListener {
            override fun onMonthSelected(year: String, month: String) {
                Toast.makeText(this@MainActivity, "$year 年 $month 月", Toast.LENGTH_SHORT).show()
            }

        })
     }
	}
  
    

 
 # License
    Copyright 2018 SinFeeLoo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
