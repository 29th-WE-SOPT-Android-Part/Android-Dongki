package org.sopt.androidweek.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:image")
fun ImageView.setImage(imageview: ImageView, drawable: Int) {
    setImageResource(drawable)
}