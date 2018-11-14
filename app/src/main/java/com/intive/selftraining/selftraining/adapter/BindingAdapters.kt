package co.instil.databinding

import android.databinding.BindingAdapter
import android.widget.TextView

@BindingAdapter("someText")
fun TextView.textLengthWarning(someText: String?) {

    someText?.let {
        text = it
    }
}