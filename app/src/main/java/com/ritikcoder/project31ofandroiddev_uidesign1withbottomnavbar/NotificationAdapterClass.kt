package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import de.hdodenhof.circleimageview.CircleImageView

class NotificationAdapterClass(private val notificationList: ArrayList<NotificationDataClass>) :
    RecyclerView.Adapter<NotificationAdapterClass.ViewHolderClass>() {

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notificationImageVariable: CircleImageView =
            itemView.findViewById(R.id.notificationImageView)
        val notificationTitleVariable: TextView =
            itemView.findViewById(R.id.textViewForNotificationTitle)
        val notificationSubjectVariable: TextView =
            itemView.findViewById(R.id.textViewForNotificationSubject)
        val notificationTimeVariable: TextView =
            itemView.findViewById(R.id.textViewForNotificationTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.each_notification_view, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        var currentNotification = notificationList[position]
        holder.notificationImageVariable.setImageResource(currentNotification.notificationImage)
        holder.notificationTitleVariable.text = currentNotification.notificationTitle
        holder.notificationSubjectVariable.text = currentNotification.notificationSubject
        holder.notificationTimeVariable.text = currentNotification.notificationTime
    }

}