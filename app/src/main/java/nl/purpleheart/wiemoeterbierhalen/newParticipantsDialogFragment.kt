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

    private fun addNameToList(name: String) {//TODO all database stuff should really be moved to a seperate class
        val database = context?.openOrCreateDatabase("cNames.db", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING, null)

        if (database != null) {
            var sql = "CREATE TABLE IF NOT EXISTS names(_id INTEGER PRIMARY KEY NOT NULL, name TEXT)"
            database.execSQL(sql)


            val values = ContentValues().apply {
                put("name", name)
            }
            val generatedId = database?.insert("names", null, values)
            val query = database.rawQuery("SELECT * FROM names", null)

            query.use {
                while(it.moveToNext()){
                    //cycle through data in database
                    with(it){
                        val id = getLong(0)
                        val name = getString(1)
                        val result = "ID: $id name: $name"
                        Log.d("TEST", result)
                    }
                }
            }
            database.close()

            Log.d("TEST", "TEST " + generatedId)
        }

        dismiss()
    }
}