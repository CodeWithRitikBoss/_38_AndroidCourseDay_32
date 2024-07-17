package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var productArrayList: ArrayList<ProductDataClass>
    private lateinit var adapter: MyAdapter

    lateinit var image: Array<Int>
    lateinit var name: Array<String>
    lateinit var description: Array<String>
    lateinit var price: Array<String>

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
        return inflater.inflate(R.layout.fragment_home, container, false)

        //
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        myRecyclerView = view.findViewById(R.id.recyclerView)
        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.setHasFixedSize(true)
        adapter= MyAdapter(productArrayList, this)
        myRecyclerView.adapter = adapter

        //Calling another activity by clicking View All.
        val textViewViewAll: TextView= view.findViewById(R.id.textViewForViewAll)
        textViewViewAll.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
            Toast.makeText(context, "Clicked on View All Items", Toast.LENGTH_SHORT).show()
        }

        //Calling another activity by clicking categories item.
        val menCategoryItems: ImageView= view.findViewById(R.id.imageViewForMensProductCategories)
        val womenCategoryItems: ImageView= view.findViewById(R.id.imageViewForWomensProductCategories)
        val kidCategoryItems: ImageView= view.findViewById(R.id.imageViewForKidsProductCategories)
        val laptopCategoryItems: ImageView= view.findViewById(R.id.imageViewForLaptopsProductCategories)
        val musicPlayerCategoryItems: ImageView= view.findViewById(R.id.imageViewForMusicPlayersProductCategories)
        val phoneCategoryItems: ImageView= view.findViewById(R.id.imageViewForPhonesProductCategories)
        val sunGlassesCategoryItems: ImageView= view.findViewById(R.id.imageViewForSunGlassesProductCategories)
        val watchCategoryItems: ImageView= view.findViewById(R.id.imageViewForWatchesProductCategories)
        val footWearsCategoryItems: ImageView= view.findViewById(R.id.imageViewForFootWearsProductCategories)

        menCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        womenCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        kidCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        laptopCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        musicPlayerCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        phoneCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        sunGlassesCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }
        watchCategoryItems.setOnClickListener {
            startActivity(Intent(context, WatchesCategory::class.java))
        }
        footWearsCategoryItems.setOnClickListener {
            startActivity(Intent(context, MainActivity3::class.java))
        }

        //Setting what action will be there perform after clicking the Recycler view each item.
        adapter.setOnItemClickListener(object: MyAdapter._onItemClickListener {
            override fun onItemClick(position: Int) {
                //On clicking each item, what action do you want to perform.
                //Toast.makeText(context, "Home Fragment Fine", Toast.LENGTH_SHORT).show()

                //Setting data to pass to MainActivity4 activity.
                val intentToOpenActivity4= Intent(context, MainActivity4::class.java)
                intentToOpenActivity4.putExtra("productImage", productArrayList[position].productImage)
                intentToOpenActivity4.putExtra("productName", productArrayList[position].productName)
                intentToOpenActivity4.putExtra("productDescription", productArrayList[position].productDescription)
                intentToOpenActivity4.putExtra("productPrice", productArrayList[position].productPrice)
                startActivity(intentToOpenActivity4)
            }
        })



    }

    private fun dataInitialize() {
        productArrayList = arrayListOf<ProductDataClass>()
        //Data Creating for Recycler View is here.
        val productImageArray = arrayOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_14,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_28,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_29,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13
        )

        val productNameArray = arrayOf(
            "DELL Inspiron 3520",
            "iphone 14 pro max",
            "Top for Women",
            "ASUS Vivobook S15 OLED",
            "Latest Watch for mens",
            "Laptop bag For boys",
            "Wifi Router for 5G",
            "Female Kid Shut",
            "Boat Ear buds 2023",
            "iphone 13 pro max",
            "New kid shut",
            "Boat ear buds",
            "New short top for women",
            "Female Kids dress",
            "New Dress for women",
            "Women dress new 2023"
        )

        val productDescriptionArray = arrayOf(
            "DELL Ryzen 3 Quad Core 5425U - (8 GB/512 GB SSD/Windows 11 Home) \nInspiron 3525\n Thin and Light Laptop  (15.6 Inch, Carbon Black, 1.68 Kg, With MS Office)",
            "APPLE iPhone 14 Pro Max (Deep Purple, 1 TB ) \n112MP Camera Retina XDR Display\n 6 Core Processor128 GB ROM\n" +
                    "17.02 cm (6.7 inch) Super Retina XDR Display\n" +
                    "48MP + 12MP + 12MP | 12MP Front Camera\n" +
                    "A16 Bionic Chip, 6 Core Processor Processor",
            "Casual Regular Sleeves Printed Women Black Top\nCasual Regular Sleeves Printed Women Multicolor TopCasual Regular Sleeves Printed Women Multicolor Top",
            "Intel Core Evo i5-12500H 12th Gen 32GB/1TB NvME M.2 Gen 4 15.6inch OLED RitikCoder is back\nASUS Core i7 12th Gen - (16 GB/512 GB SSD/Windows 11 Home) S3502ZA-L702WS Laptop  (15.6 inch, Indie Black, With MS Office)",
            "Trending Day & Date Functioning for Boys Analog Watch - For Men LCS-8188\nIt's verry good and I like it so much and it's loking like royal look it's so nice and amazing product Im satis.",
            "Large 32 L Laptop Backpack Anti Theft Backpack with USB Charging port 15.6 Inch Laptop- Bagpack Waterproof Casual Unisex Bag for School Collage Office Suitable for men Women (Grey & Black)  (Grey)",
            "TP-Link archer mr200 (EU) 750 Mbps 4G Router  (Black, Dual Band)4G Routers\n" +
                    "Model\n" +
                    "archer mr200 (EU)\n" +
                    "Controls\n" +
                    "WPS/RESET Button, Wi-Fi ON/OFF Button\n" +
                    "In The Box\n" +
                    "AC750 Wireless Dual Band 4G LTE Router Archer MR200, RJ45 Ethernet Cable, Power Adapter, Quick Installation Guide\n" +
                    "Series\n" +
                    "TP-Link",
            "Girls Maxi/Full Length Party Dress  (Pink, 3/4 Sleeve) Beautiful Shut for Female kidsDescription4Description4Description4Description4 Girls  (Pink, 3/4 Sleeve)",
            "boAt Airdopes 131 with upto 60 Hours and ASAP Charge Bluetooth Headset  (Active Black, True Wireless)With Mic:Yes\n" +
                    "Bluetooth version: 5.0 / 5.1\n" +
                    "Wireless range: 10 m\n" +
                    "Charging time: 2 Hours\n" +
                    "Playback Time: Upto 15 to 60 Hours Playback\n" +
                    "ASAP Charge: 5 Mins Charge= 90 Mins Playback\n" +
                    "13MM Drivers",
            "128 GB ROM\n" +
                    "15.49 cm (6.1 inch) Super Retina XDR Display\n" +
                    "12MP + 12MP | 12MP Front Camera\n" +
                    "A15 Bionic Chip, 6 Core Processor Processor",
            "Girls Maxi/Full Length Party Dress  (Pink, 3/4 Sleeve) Beautiful Shut for Female kidsDescription4Description4Description4Description4 Girls  (Pink, 3/4 Sleeve)",
            "boAt Airdopes 131 with upto 60 Hours and ASAP Charge Bluetooth Headset  (Active Black, True Wireless)With Mic:Yes\n" +
                    "Bluetooth version: 5.0 / 5.1\n" +
                    "Wireless range: 10 m\n" +
                    "Charging time: 2 Hours\n" +
                    "Playback Time: Upto 15 to 60 Hours Playback\n" +
                    "ASAP Charge: 5 Mins Charge= 90 Mins Playback\n" +
                    "13MM Drivers",
            "Description10Description4Description4Description4Description4",
            "Description11Description4Description4Description4Description4",
            "Description12Description4Description4Description4Description4",
            "Description13Description4Description4Description4Description4"
        )

        val productPriceArray = arrayOf(
            "Rs 99900",
            "Rs 170000",
            "Rs 5000",
            "Rs 120000",
            "Rs 2000",
            "Rs 2500",
            "Rs 5000",
            "Rs 3999",
            "Rs 2500",
            "Rs 150000",
            "Rs 3580",
            "Rs 3000",
            "Rs 2200",
            "Rs 4500",
            "Rs 5500",
            "Rs 4500"
        )

        for (index in productImageArray.indices) {
            val product = ProductDataClass(
                productImageArray[index], productNameArray[index], productDescriptionArray[index],
                productPriceArray[index]
            )
            productArrayList.add(product)
        }

    }
}