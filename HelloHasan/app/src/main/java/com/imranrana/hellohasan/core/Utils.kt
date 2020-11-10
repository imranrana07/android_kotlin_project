package com.imranrana.hellohasan.core

import android.text.Html
import androidx.core.text.HtmlCompat
import java.text.SimpleDateFormat

class Utils {
    companion object{
        const val BASE_URL = "https://hellohasan.com/wp-json/wp/v2/"
        const val AUTHOR = "Hasan Abdullah"
        const val VISIBLE = 0 // View.VISIBLE = 0
        const val GONE = 8 // View.GONE = 8

        fun dateFormat(originalDate: String): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            var convertedDate = sdf.parse(originalDate)
            return SimpleDateFormat("dd MMMM, yyyy").format(convertedDate)
        }

        fun dateFormatWithTime(originalDate: String): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            var convertedDate = sdf.parse(originalDate)
            return SimpleDateFormat("dd MMMM, yyyy HH:mm:ss").format(convertedDate)
        }


        fun htmlToString(title: String): String {
            return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                HtmlCompat.fromHtml( title, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            }else{
                Html.fromHtml(title).toString()
            }
        }

    }


}