package br.com.jvictororiz.startermvp.ext

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.setImageFromUrl(
    url: String?, @DrawableRes idImage: Int? = null,
    callbackSucess: (() -> Unit)? = null,
    callbackError: (() -> Unit)? = null,
    callbackFinish: (() -> Unit)? = null
) {
    Picasso.get()
        .load(url)
        .centerCrop()
        .fit()
        .apply { idImage?.let { placeholder(idImage).error(it) } }
        .fit()
        .into(this, object : Callback {
            override fun onSuccess() {
                callbackSucess?.invoke()
                callbackFinish?.invoke()
            }

            override fun onError(e: Exception?) {
                callbackError?.invoke()
                callbackFinish?.invoke()

            }
        })
}