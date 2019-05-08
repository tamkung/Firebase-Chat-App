package com.tamkung.mychat.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tamkung.mychat.GroupChatActivity;
import com.tamkung.mychat.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupFragment extends Fragment {

    private View groupView;
    private ListView group_view;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list_group = new ArrayList<>();

    private DatabaseReference groupRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        groupView = inflater.inflate(R.layout.fragment_group, container, false);

        groupRef = FirebaseDatabase.getInstance().getReference().child("Groups");

        IntiaizeFieds();

        DisplayGroup();

        group_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String currentGroupName = adapterView.getItemAtPosition(position).toString();

                Intent gruupChat = new Intent(getContext(), GroupChatActivity.class);
                gruupChat.putExtra("GroupName", currentGroupName);
                startActivity(gruupChat);
            }
        });

        return groupView;
    }

    private void IntiaizeFieds() {

        group_view = (ListView) groupView.findViewById(R.id.group_view);
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list_group);
        group_view.setAdapter(arrayAdapter);
    }

    private void DisplayGroup() {
        groupRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Set<String> set = new HashSet<>();
                Iterator iterator = dataSnapshot.getChildren().iterator();

                while (iterator.hasNext()){;
                    set.add(((DataSnapshot)iterator.next()).getKey());
                }

                list_group.clear();
                list_group.addAll(set);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
