package com.ogungor.daytodaysetting.personEnter.personlist

import android.Manifest

import android.content.Context
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import com.ogungor.daytodaysetting.R
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class PersonListFragment(val personList: ArrayList<String>) : DialogFragment(),
    PersonListFragmentContract.View {
    private lateinit var personListFragmentPresenter: PersonListFragmentContract.Presenter
    private val STORAGE_CODE = 100
    private lateinit var viewModel: PersonListViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        personListFragmentPresenter = PersonListFragmentPresenter().apply {
            setView(this@PersonListFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.person_list_fragment, container, false)
        val outLinearLayout = view.findViewById<LinearLayout>(R.id.fragment_out_linearLayout)
        val pdfSaveBtn = Button(context)
        pdfSaveBtn.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        var personRandomList = personList.shuffled()

        for (i in 1..personList.size) {
            val editLinearLayout = LinearLayout(context)
            val textViewCount = TextView(context)
            val textViewName = TextView(context)


            editLinearLayout.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textViewName.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textViewCount.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )


            pdfSaveBtn.setPadding(4, 0, 4, 0)
            pdfSaveBtn.text = "Listeyi Kaydet"
            textViewName.setPadding(5, 5, 5, 5)
            textViewCount.setPadding(4, 4, 4, 4)
            textViewCount.text = i.toString()
            textViewName.text = personRandomList.get(i - 1)
            editLinearLayout.addView(textViewCount)
            editLinearLayout.addView(textViewName)

            outLinearLayout.addView(editLinearLayout)


        }
        outLinearLayout.addView(pdfSaveBtn)

        pdfSaveBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_DENIED
                ) {
                    val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permissions, STORAGE_CODE)
                } else {
                    pdfSaveList()
                }
            } else {
                pdfSaveList()
            }
        }
        return view


    }

    override fun initUi() {

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            STORAGE_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pdfSaveList()
                } else {
                    Toast.makeText(context, "Permission Denied..!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun initViewModel() {

    }

    fun pdfSaveList() {
        val pdfDosyam = Document()
        val mFileName = SimpleDateFormat(
            "yyyyMMdd_HHmmss",
            Locale.getDefault()
        ).format(System.currentTimeMillis())
        val mFilePath =
            Environment.getExternalStorageDirectory().toString() + "/" + mFileName + ".pdf"
        try {
            PdfWriter.getInstance(pdfDosyam,FileOutputStream(mFilePath))
            pdfDosyam.open()

            for (i in 1..personList.size) {
                var personName = personList.get(i)
                pdfDosyam.addAuthor("Ozilus")
                pdfDosyam.add(Paragraph(personName))
            }
            pdfDosyam.close()

            Toast.makeText(context, "$mFileName.pdf\nis saved to \n$mFilePath", Toast.LENGTH_LONG)
                .show()


        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }


}