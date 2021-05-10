package com.saihtoo.tourismapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DestinationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DestinationFragment extends Fragment {
    public DestinationFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @param text Parameter 2.
     * @param image Parameter 3.
     * @return A new instance of fragment DestinationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DestinationFragment newInstance(String title, String text, int image) {
        DestinationFragment fragment = new DestinationFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("text", text);
        args.putInt("image", image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView image = view.findViewById(R.id.placeImageView);
        TextView title = view.findViewById(R.id.titleTextView);
        TextView text = view.findViewById(R.id.textTextView);
        assert getArguments() != null;
        image.setImageResource(getArguments().getInt("image"));
        title.setText(getArguments().getString("title"));
        text.setText(getArguments().getString("text"));
    }
}