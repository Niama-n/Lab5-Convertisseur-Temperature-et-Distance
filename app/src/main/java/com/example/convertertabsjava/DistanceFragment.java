package com.example.convertertabsjava;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {
    private RadioGroup distGroup;
    private RadioButton kmBtn;
    private EditText input;
    private Button convertBtn;
    private TextView resultText;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);
        // Bind UI components
        distGroup = view.findViewById(R.id.rg_dist_selection);
        kmBtn = view.findViewById(R.id.rb_km_to_miles);
        input = view.findViewById(R.id.et_dist_input_field);
        convertBtn = view.findViewById(R.id.btn_convert_dist_action);
        resultText = view.findViewById(R.id.tv_dist_result_output);

        // Set up conversion logic
        convertBtn.setOnClickListener(v -> {
            String txt = input.getText() != null ? input.getText().toString() : "";
            if (TextUtils.isEmpty(txt)) {
                Toast.makeText(getContext(), "Veuillez saisir une valeur", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                double val = Double.parseDouble(txt);
                // Perform conversion and display result
                double res = kmBtn.isChecked() ? val * 0.621371 : val / 0.621371;
                resultText.setText(String.format("%.2f", res));
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Entrée invalide", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}