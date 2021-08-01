package com.example.blooddonation;


import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Fragment1 extends Fragment {

    FloatingActionButton add_receiver;

    public RecyclerView receiverList;
    public FirebaseFirestore fStore;
    public FirestoreRecyclerAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_layout,container,false);
        return view;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        add_receiver = getActivity().findViewById(R.id.receiver_request);
        receiverList = getActivity().findViewById(R.id.receiver_list);




        // Query
        Query query = FirebaseFirestore.getInstance().collection("Receiver");


        // Recycler Option
        FirestoreRecyclerOptions<DemoModel> options = new FirestoreRecyclerOptions.Builder<DemoModel>()
                .setQuery(query, DemoModel.class)
                .build();


        // RecyclerAdapter
        adapter = new FirestoreRecyclerAdapter<DemoModel, ReceiverViewHolder>(options) {

            @NonNull
            @Override
            public ReceiverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_receiver, parent,false);*/
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_receiver,parent,false);
                return new ReceiverViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ReceiverViewHolder holder, int i, @NonNull DemoModel demoModel) {

                holder.list_name.setText(" Name : "+demoModel.getFull_Name());
                holder.list_blood.setText(" Blood : "+demoModel.getBlood_Grp());
                holder.list_phone.setText(demoModel.getPhone());
                holder.list_reason.setText(" Reason : "+demoModel.getReason());
                holder.list_city.setText(" City : "+demoModel.getCity());
                holder.list_locality.setText(" Locality : "+demoModel.getLocality());
            }
        };

         receiverList.setHasFixedSize(true);

         receiverList.setLayoutManager(new LinearLayoutManager(getContext()));

         receiverList.setAdapter(adapter);

    }

    // View Holder Class
    public class ReceiverViewHolder extends RecyclerView.ViewHolder{

        public TextView list_name;
        public TextView list_blood;
        public TextView list_phone;
        public TextView list_reason;
        public TextView list_city;
        public TextView list_locality;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.r_list_name);
            list_blood = itemView.findViewById(R.id.r_list_blood_grp);
            list_phone = itemView.findViewById(R.id.r_list_phone_no);
            list_reason = itemView.findViewById(R.id.r_list_reason);
            list_city = itemView.findViewById(R.id.r_list_city);
            list_locality = itemView.findViewById(R.id.r_list_locality);

        }
    }



    @Override
    public void onStart() {
        super.onStart();

        adapter.startListening();

        // Add Receiver Floating Button
        add_receiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Add_Receiver.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }



    /*public void OnCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.search_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView)menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processSearch(s);
                return false;
            }
        });



    }

    private void processSearch(String s) {

        // Query
        Query q = FirebaseFirestore.getInstance().collection("Receiver").orderBy("Blood_Grp").startAt(s).endAt(s+"\uf8ff");


        // Recycler Option
        FirestoreRecyclerOptions<DemoModel> options = new FirestoreRecyclerOptions.Builder<DemoModel>()
                .setQuery(q, DemoModel.class)
                .build();



        // RecyclerAdapter
        adapter = new FirestoreRecyclerAdapter<DemoModel, ReceiverViewHolder>(options) {

            @NonNull
            @Override
            public ReceiverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                *//*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_receiver, parent,false);*//*
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_receiver,parent,false);
                return new ReceiverViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ReceiverViewHolder holder, int i, @NonNull DemoModel demoModel) {

                holder.list_name.setText(" Name : "+demoModel.getFull_Name());
                holder.list_blood.setText(" Blood : "+demoModel.getBlood_Grp());
                holder.list_phone.setText(demoModel.getPhone());
                holder.list_reason.setText(" Reason : "+demoModel.getReason());
                holder.list_city.setText(" City : "+demoModel.getCity());
                holder.list_locality.setText(" Locality : "+demoModel.getLocality());
            }
        };

        adapter.startListening();

        receiverList.setAdapter(adapter);

    }*/

}
