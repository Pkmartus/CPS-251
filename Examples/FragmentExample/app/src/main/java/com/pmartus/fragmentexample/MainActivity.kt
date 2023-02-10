package com.pmartus.fragmentexample
import androidx.fragment.app.FragmentActivity
import android.os.Bundle


class MainActivity : FragmentActivity(),
    ToolbarFragment.ToolbarListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
//now the toolbar fragment will detect when the button is clicked and call a method on the activity passing through the content of the edit text field and the current setting of the seekbar
    override fun onButtonClick(position: Int, text: String) {
        //finds a reference to the other fragment in order to control it from here
        val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment) as TextFragment
        textFragment.changeTextProperties(position, text)
    }
}