package com.b.alkhatib.retrofit_with_mvvm_pattern_examble.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.data.PostClient
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.pojo.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *  هذا الكلاس الذي سيرجع لنا ليست من البوستس من الريتروفيت ويخبرنا في الاكتيفيتي انه تم ارجاع البيانات فقط لا غير
 *
 * */
// *** 5
class PostViewModel:ViewModel() {


    val postMutableLiveData = MutableLiveData<List<PostModel>>() // التي ستبقي البيانات حية ومتجددة وتأخذ ليست من البوست مودل

    //الفانكشن التي ستأتي بالبيانات من ريتروفيت
    //بعد الانتهاء هنا نذهب للاكتيفيتي لنوضع الفيو مودل هناك


    fun getPosts(){
        // *** 8 : هنا نعد ال call back
        PostClient.getINSTANCE().getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                //نريد من الMutableLiveData التي أنشأناها تأخذ الResponse الذي رجع
                postMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {

            }

        })

    }
}