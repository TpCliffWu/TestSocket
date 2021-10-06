package gov.sample.socketandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import gov.sample.socketandroid.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        OnListen = false;

        binding = FragmentSecondBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

    public boolean OnListen;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (OnListen) {

                    StopListen();
                } else {

                    StartListen();
                }

//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);


            }

            private void StartListen() {
                OnListen =true;
               binding.buttonListen.setText("Start Listen");
            }

            private void StopListen() {
                OnListen = false;
             binding.buttonListen.setText("Stop Listen");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}