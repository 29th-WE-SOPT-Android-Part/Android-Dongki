package org.sopt.androidweek.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:image")
fun setImage(imageview: ImageView, drawable: Int) {
    imageview.setImageResource(drawable)
}