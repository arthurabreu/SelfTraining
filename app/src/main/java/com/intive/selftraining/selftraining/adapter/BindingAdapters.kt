package co.instil.databinding

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.EditText
import android.widget.TextView

@BindingAdapter("someText")
fun TextView.textLengthWarning(someText: String?) {

    someText?.let {
        text = it
    }

}