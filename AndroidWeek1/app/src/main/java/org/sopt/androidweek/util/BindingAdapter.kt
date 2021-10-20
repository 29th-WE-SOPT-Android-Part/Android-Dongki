package org.sopt.androidweek.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:image")
fun ImageView.setImage(drawable: Int) {
    setImageResource(drawable)
}