package com.example.ddaatapp.activity.techSupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.TicketAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityTechSupportTicketBinding

class TechSupportTicketActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityTechSupportTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechSupportTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ticket list
        val ticketList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.TicketDataModel>(
            com.example.ddaatapp.model.responseDatamodel.TicketDataModel(
                "Title of the Ticket",
                "(Open)",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …",
                "Created - 28th Feb 2023 at 12.00 PM"
            ),
            com.example.ddaatapp.model.responseDatamodel.TicketDataModel(
                "Title of the Ticket",
                "(Open)",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …",
                "Created - 28th Feb 2023 at 12.00 PM"
            ),
            com.example.ddaatapp.model.responseDatamodel.TicketDataModel(
                "Title of the Ticket",
                "(Open)",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …",
                "Created - 28th Feb 2023 at 12.00 PM"
            ),
            com.example.ddaatapp.model.responseDatamodel.TicketDataModel(
                "Title of the Ticket",
                "(Open)",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …",
                "Created - 28th Feb 2023 at 12.00 PM"
            ),
            )
        val ticketRecyclerView = binding.ticketRecycler
        val adapter = TicketAdapter(ticketList,this)
        ticketRecyclerView.adapter = adapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        ticketRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnAddTicket->{
                startActivity(Intent(this,CreateTicketActivity::class.java))
            }
        }
    }
}