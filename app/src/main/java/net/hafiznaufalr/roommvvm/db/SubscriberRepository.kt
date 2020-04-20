package net.hafiznaufalr.roommvvm.db

import androidx.paging.Config
import androidx.paging.toLiveData

class SubscriberRepository(private val dao: SubscriberDAO) {
    val subscribers = dao.getAllSubscribers()
//    val pagedSubscribers = dao.getAllPagedSubscribers().toLiveData(
//        Config(
//            pageSize = 20,
//            enablePlaceholders = true,
//            maxSize = 200
//        )
//    )

    suspend fun insert(subscriber: Subscriber): Long{
        return dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber): Int{
        return dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber): Int{
        return dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(): Int{
        return dao.deleteAll()
    }
}