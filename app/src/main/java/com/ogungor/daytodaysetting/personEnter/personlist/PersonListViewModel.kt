package com.ogungor.daytodaysetting.personEnter.personlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ogungor.retrofit.RetroServiceInterface
import com.ogungor.retrofit.RetrofitInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import kotlin.concurrent.thread

class PersonListViewModel(val fileDir: File) : ViewModel() {

    private var pdfFileName: File
    private var dirPath: String
    private var fileName: String
    var isFileReadyObserver = MutableLiveData<Boolean>()


    init {
        dirPath = "${fileDir}/myfolder/pdffiles"
        val dirFile = File(dirPath)
        if (!dirFile.exists()) {
            dirFile.mkdirs()
        }
        fileName = "Demo.pdf"
        val file = "${dirPath}/${fileName}"

        pdfFileName = File(file)

        if (pdfFileName.exists()) {
            pdfFileName.delete()
        }
    }

    fun getPdfFileUri():File=pdfFileName

    fun downloadPdfFile(pdfUrl: String) {
        thread {
            val retroServiceInterface =
                RetrofitInstance.getRetroInstance().create(RetroServiceInterface::class.java)
            retroServiceInterface.downloadPdfFile(pdfUrl).enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    isFileReadyObserver.postValue(false)
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    if (response.isSuccessful) {
                         val result=response.body()?.byteStream()
                        result?.let {
                            writeToFile(it)
                        }?:kotlin.run {
                            isFileReadyObserver.postValue(false)
                        }
                    } else {

                        isFileReadyObserver.postValue(false)
                    }
                }
            })
        }
    }

    private fun writeToFile(inputStream:InputStream){
        try {


            val fileReader = ByteArray(4096)
            var fileSizeDownload = 0
            val fos: OutputStream = FileOutputStream(pdfFileName)
            do {
                val read = inputStream.read(fileReader)
                if (read != -1) {
                    fos.write(fileReader, 0, read)
                    fileSizeDownload += read
                }
            } while (read != -1)
            fos.flush()
            fos.close()
            isFileReadyObserver.postValue(true)
        }
        catch (e:IOException)
        {
            isFileReadyObserver.postValue(false)

        }
    }
}