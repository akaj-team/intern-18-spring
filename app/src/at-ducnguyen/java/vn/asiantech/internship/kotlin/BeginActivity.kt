package vn.asiantech.internship.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import vn.asiantech.internship.R
import vn.asiantech.internship.kotlin.viewAndViewGroup.ViewGroupActivity

class BeginActivity : AppCompatActivity(), View.OnClickListener {
    val keyTitle = "KEY_TITLE"
    private lateinit var mBtnViewAndViewGroup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin_kotlin)
        initViews()
        initListener()
    }

    private fun initViews() {
        mBtnViewAndViewGroup = findViewById(R.id.btnViewAndViewGroup)
    }

    private fun initListener() {
        mBtnViewAndViewGroup.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.btnViewAndViewGroup -> {
                val title: String = mBtnViewAndViewGroup.text.toString()
                goTo(ViewGroupActivity::class.java, title)
            }
        }
    }

    private fun goTo(markClass: Class<*>, title: String = getString(R.string.app_name)) {
        val intent = Intent(this, markClass)
        intent.putExtra(keyTitle, title)
        startActivity(intent)
    }
}
