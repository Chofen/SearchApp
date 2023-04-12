package com.example.searchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchapp.api.ApiClient
import com.example.searchapp.api.ImagesAPI
import com.example.searchapp.databinding.ActivityMainBinding
import com.example.searchapp.adapter.PhotoSearchAdapter
import com.example.searchapp.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val photoAdapter by lazy { PhotoSearchAdapter() }
    private val api by lazy {
        ApiClient().getClient().create(ImagesAPI:: class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {


            val searchText = findViewById<EditText>(R.id.searchText)
            val callPhotoApi = api.searchImages(searchText,1)
            callPhotoApi.enqueue(object : Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>,response: Response<SearchResponse>) {
                    when (response.code()) {
                        //successful response
                        in 200..299 -> {
                            Log.d("Response Code", " success messages : ${response.code()}")

                            //Recycler
                            rlPhoto.apply {
                                layoutManager = LinearLayoutManager(this@MainActivity)
                                adapter = photoAdapter
                            }
                        }
                    }

                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
       // fetchSearchResult().start()
    }

  /*  private fun fetchSearchResult(): Thread {
        return Thread {

            val url = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=fdfb6a972c967743310fd05ba08f9516&tags='cat'&format=json&nojsoncallback=1'")
           // val key: String = "fdfb6a972c967743310fd05ba08f9516"
            val connection = url.openConnection() as HttpURLConnection

            if (connection.responseCode == 200) {

                val inputSystem = connection.inputStream
                println(inputSystem.toString())
                val inputStreamReader = InputStreamReader(inputSystem, "UTF8")
                val request = Gson().fromJson(inputStreamReader, Photo::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()


            } else {
                binding.textView.text = "Failed conncetion"
            }

        }

    }

    private fun updateUI(photo: Photo){
        runOnUiThread {
            kotlin.run {
                binding.textView.text = String.format("Title ", photo.title)
            }
        }
}
*/
}