package vn.asiantech.internship.kotlin.viewAndViewGroup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import vn.asiantech.internship.R
import vn.asiantech.internship.kotlin.BeginActivity

class ViewGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val beginActivity = BeginActivity()
        val viewGroupFragment = ViewGroupFragment()
        val transaction = fragmentManager.beginTransaction()
        val bundle = intent.extras
        title = bundle.getString(beginActivity.keyTitle)
        transaction.replace(R.id.flFragment, viewGroupFragment)
        transaction.commit()
    }
}
