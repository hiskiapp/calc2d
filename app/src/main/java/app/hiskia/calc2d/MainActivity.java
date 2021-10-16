package app.hiskia.calc2d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rengwuxian.materialedittext.validation.RegexpValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.p)
    EditText p;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.l)
    EditText l;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.square)
    Button square;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.triangle)
    Button triangle;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.circle)
    Button circle;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.large)
    TextView large;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.around)
    TextView around;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @OnClick(R.id.square)
    public void setSquare() {
        if(p.getText().toString().length()==0) {
            p.setError("Panjang wajib diisi!");
        }else if(l.getText().toString().length()==0){
            l.setError("Lebar wajib diisi!");
        }else {
            p.setError(null);
            l.setError(null);

            Integer length = Integer.parseInt(p.getText().toString());
            Integer width = Integer.parseInt(l.getText().toString());
            int large_result = length * width;
            int around_result = 2 * (length + width);
            large.setText(Double.toString(round(large_result, 2)));
            around.setText(Double.toString(round(around_result, 2)));
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @OnClick(R.id.triangle)
    public void setTriangle() {
        if(p.getText().toString().length()==0) {
            p.setError("Alas wajib diisi!");
        }else if(l.getText().toString().length()==0){
            l.setError("Tinggi wajib diisi!");
        }else {
            p.setError(null);
            l.setError(null);

            double base = Integer.parseInt(p.getText().toString());
            double width = Integer.parseInt(l.getText().toString());
            double large_result = (0.5 * base * width);
            double side = Math.sqrt(Math.pow(base/2, 2) + Math.pow(width, 2));
            double around_result = base + (side * 2);
            large.setText(Double.toString(round(large_result, 2)));
            around.setText(Double.toString(round(around_result, 2)));
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @OnClick(R.id.circle)
    public void setCircle() {
        if(p.getText().toString().length()==0) {
            p.setError("Diameter wajib diisi!");
        }else {
            p.setError(null);
            l.setError(null);

            double phi = 3.14;
            double diameter = Integer.parseInt(p.getText().toString());
            double radius = diameter / 2;
            double large_result = phi * radius * radius;
            double around_result = phi * diameter;
            large.setText(Double.toString(round(large_result, 2)));
            around.setText(Double.toString(round(around_result, 2)));
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}