package nl.purpleheart.wiemoeterbierhalen

import android.os.Bundle
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
        //get list from cache
        //add name to list
        //save list to cache

        dismiss()
    }
}