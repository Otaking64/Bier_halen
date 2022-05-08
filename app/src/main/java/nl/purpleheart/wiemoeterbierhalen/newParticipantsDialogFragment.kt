package nl.purpleheart.wiemoeterbierhalen

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class newParticipantsDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_participants, container, false)
        val participantName = view.findViewById<EditText>(R.id.addParticipantNameEditText)
        val cancelBtn = view.findViewById<Button>(R.id.AddPDialogCancel)
        val confirmBtn = view.findViewById<Button>(R.id.AddPDialogDialogConfirm)



        cancelBtn.setOnClickListener {
            dismiss()
        }

        confirmBtn.setOnClickListener {
            addNameToList(participantName.text.toString())
        }

        return view
    }

    private fun addNameToList(name: String) {
        val database = context?.openOrCreateDatabase("sqlite-cNames.db", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING, null)

        if (database != null) {
            var sql = "CREATE TABLE names(_id INTEGER PRIMARY KEY NOT NULL, name TEXT)"
            database.execSQL(sql)


            val values = ContentValues().apply {
                put("name", name)
            }
            val generatedId = database?.insert("sqlite-cNames.db", null, values)
            Log.d("TEST", "TEST" + generatedId)
        }

        dismiss()
    }
}