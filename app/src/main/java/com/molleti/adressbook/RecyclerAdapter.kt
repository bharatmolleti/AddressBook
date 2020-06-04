package com.molleti.adressbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.molleti.adressbook.model.Person
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val personsList: List<Person>) :
    RecyclerView.Adapter<RecyclerAdapter.PersonListViewHolder>() {

    class PersonListViewHolder(personView: View) : RecyclerView.ViewHolder(personView) {
        private val userNameTextView = personView.findViewById<TextView>(R.id.name)
        private val userPhoneNoTextView = personView.findViewById<TextView>(R.id.phone_number)
        private val userEmailIdTextView = personView.findViewById<TextView>(R.id.email_id)
        private val userAvatarImageView = personView.findViewById<ImageView>(R.id.avatar_view)

        fun bind(person: Person) {
            userNameTextView.findViewById<TextView>(R.id.name).text = person.name
            userPhoneNoTextView.text = person.phoneNo
            userEmailIdTextView.text = person.emailId
            Picasso.get().load(person.avatar).into(userAvatarImageView);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonListViewHolder {
        return PersonListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_contact, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    override fun onBindViewHolder(holder: PersonListViewHolder, position: Int) {
        holder.bind(personsList[position])
    }
}

