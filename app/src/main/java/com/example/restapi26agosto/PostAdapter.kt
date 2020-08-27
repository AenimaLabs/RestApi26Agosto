package com.example.restapi26agosto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi26agosto.pojo.Post
import kotlinx.android.synthetic.main.users_list_item.view.*

class PostAdapter (private val myPostAdapter: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostText>() {


class PostText (itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mId : TextView = itemView.textId
    var mName: TextView = itemView.textName
    var mEmail: TextView = itemView.textEmail
    var mPhone: TextView = itemView.textPhone

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostText {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false)

        return PostText(view)
    }

    override fun getItemCount(): Int {
        return myPostAdapter.size
    }

    override fun onBindViewHolder(holder: PostText, position: Int) {
        val post = myPostAdapter[position]
        holder.mId.text = post.id.toString()
        holder.mName.text = post.name
        holder.mEmail.text = post.email
        holder.mPhone.text = post.phone



    }


}