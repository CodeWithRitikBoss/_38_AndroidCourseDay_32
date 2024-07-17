package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var notificationRecyclerView1: RecyclerView
    private lateinit var notificationDataList: ArrayList<NotificationDataClass>
    private lateinit var notificationAdapterClass: NotificationAdapterClass


    lateinit var notificationImageList: Array<Int>
    lateinit var notificationTitleList: Array<String>
    lateinit var notificationSubjectList: Array<String>
    lateinit var notificationTimeList: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Data creation to show Notification Frame.
        notificationImageList = arrayOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10
        )

        notificationTitleList = arrayOf(
            "Message-1",
            "Message-2",
            "Message-3",
            "Message-4",
            "Message-5",
            "Message-6",
            "Message-7",
            "Message-8",
            "Message-9",
            "Message-10"
        )

        notificationSubjectList = arrayOf(
            "Notification subject-1",
            "Notification subject-2",
            "Notification subject-3",
            "Notification subject-4",
            "Notification subject-5",
            "Notification subject-6",
            "Notification subject-7",
            "Notification subject-8",
            "Notification subject-9",
            "Notification subject-10"
        )

        notificationTimeList = arrayOf(
            "time-1",
            "time-2",
            "time-3",
            "time-4",
            "time-5",
            "time-6",
            "time-7",
            "time-8",
            "time-9",
            "time-10"
        )
        //Ending of Notification Data Creation.

        //Setting and Initializing notificationRecyclerView.
        notificationRecyclerView1 = view.findViewById(R.id.notificationRecyclerView)
        notificationRecyclerView1.layoutManager = LinearLayoutManager(context)
        notificationRecyclerView1.setHasFixedSize(true)
        notificationDataList = arrayListOf<NotificationDataClass>()

        //Calling getNotificationData() Method is here.
        getNotificationData()

    }

    private fun getNotificationData() {

        //Initializing NotificationDataClass Data and initializing notificationRecyclerView adapter here.
        for (index in notificationImageList.indices) {
            val notificationDataClass =
                NotificationDataClass(
                    notificationImageList[index],
                    notificationTitleList[index],
                    notificationSubjectList[index],
                    notificationTimeList[index]
                )
            notificationDataList.add(notificationDataClass)
        }
        notificationRecyclerView1.adapter = NotificationAdapterClass(notificationDataList)
    }
}