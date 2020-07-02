package br.com.jvictororiz.startermvp.ui.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.jvictororiz.startermvp.R
import br.com.jvictororiz.startermvp.data.entities.User
import br.com.jvictororiz.startermvp.ext.setImageFromUrl
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User) {
        itemView.name.text = user.name
        itemView.username.text = user.username
        itemView.progressBar.visibility = View.VISIBLE
        itemView.picture.setImageFromUrl(
            user.img,
            R.drawable.ic_round_account_circle,
            callbackFinish = {
                itemView.progressBar.visibility = View.GONE
            })
    }
}