package net.hafiznaufalr.roommvvm

import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import net.hafiznaufalr.roommvvm.databinding.ItemSubscriberBinding
import net.hafiznaufalr.roommvvm.db.Subscriber

class SubscriberAdapter(
    private val clickListener:(Subscriber)-> Unit):
    RecyclerView.Adapter<MyViewHolder>() {

    private val subscriberList = ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSubscriberBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_subscriber, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position], clickListener)
    }

    fun setList(subscribers: List<Subscriber>){
        subscriberList.clear()
        subscriberList.addAll(subscribers)
    }

    override fun getItemCount(): Int = subscriberList.size

//    companion object{
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Subscriber>(){
//            override fun areItemsTheSame(
//                oldItem: Subscriber,
//                newItem: Subscriber): Boolean = oldItem.id == newItem.id
//
//            override fun areContentsTheSame(
//                oldItem: Subscriber,
//                newItem: Subscriber): Boolean = oldItem == newItem
//
//        }
//    }
}

class MyViewHolder(private val binding: ItemSubscriberBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit){
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }
    }
}