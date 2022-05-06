package nl.purpleheart.wiemoeterbierhalen

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addParticipantBtn = findViewById<Button>(R.id.addParticipant)

        addParticipantBtn.setOnClickListener {
            val addPDialog = newParticipantsDialogFragment()
            val fm = supportFragmentManager
            addPDialog.show(fm, "newParticipantsDialogFragment")
        }
    }
}