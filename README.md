# FloatingMenu
 <img src="/sample.gif" width="50%"> 
 
 How to use
==================
step 1. In accordance with the order added view
```
<android.pixnet.net.sample.FloatingView
        android:id="@+id/FLV"
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:layout_alignParentBottom="true"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true">

        <ImageView
            android:id="@+id/buttonIM1"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:src="@drawable/add121" />

        <ImageView
            android:id="@+id/buttonIM2"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:src="@drawable/chat44" />

        <ImageView
            android:id="@+id/buttonIM3"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:src="@drawable/search67" />

        <ImageView
            android:id="@+id/buttonIM4"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:src="@drawable/placeholder14" />

        <ImageView
            android:id="@+id/buttonMenu"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:src="@drawable/menu33" />
</android.pixnet.net.sample.FloatingView>
 ```
 step 2. to set item click listener
 ```
  ((FloatingView) findViewById(R.id.FLV)).setOnItemClickListener(new FloatingView.OnItemClickListener() {
            @Override
            public void onClick(View v, int child) {
                Toast.makeText(MainActivity.this, "is click " + Integer.toString(child), Toast.LENGTH_SHORT).show();
            }
        });
 ```
 
