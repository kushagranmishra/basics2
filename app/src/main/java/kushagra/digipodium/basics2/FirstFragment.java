package kushagra.digipodium.basics2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);


    FloatingActionButton fab = view.findViewById(R.id.fab);
    ImageView imgShare = view.findViewById(R.id.imgShare);
    final CardView card1 = view.findViewById(R.id.card1);
    CardView card2 = view.findViewById(R.id.card2);

    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            card1.animate().scaleY(0)
                    .setDuration(100)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();
        }
    });
    imgShare.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=ShareCompat.IntentBuilder.from(getActivity())
                    .setType("text/Plain")
                    .setText("not sharing real stuff")
                    .setSubject("sharing is caring")
                    .getIntent();
            startActivity(i);

        }
    });

}
}

