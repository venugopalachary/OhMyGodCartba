package com.ohmygodcart.android.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ohmygodcart.android.R;

import org.json.JSONObject;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import java.awt.font.TextAttribute;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener  {

    TextView subTotal,discount,shipping,total;
    double amount= 0.0;
    Button paymentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        amount=getIntent().getDoubleExtra("amount",0.0);

       subTotal=findViewById(R.id.sub_total);
       discount=findViewById(R.id.discount);
        shipping=findViewById(R.id.shipping);
        total=findViewById(R.id.total_amt);
        paymentBtn=findViewById(R.id.pay_btn);


        subTotal.setText(amount+"$");

        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentMethod();
            }
        });

    }

    private void paymentMethod() {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_live_yoggonx4XZrTXB");
        final Activity activity = PaymentActivity.this;

        try {
            JSONObject options = new JSONObject();
            //Set Company Name
            options.put("name", "My E-Commerce App");
            //Ref no
            options.put("description", "Reference No. #123486");
            //Image to be display
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_9A33XWu170gUtm");
            // Currency type
            options.put("currency", "INR");
            //double total = Double.parseDouble(mAmountText.getText().toString());
            //multiply with 100 to get exact amount in rupee
            amount = 1000 * 100;
            //amount
            options.put("amount", amount);
            JSONObject preFill = new JSONObject();
            //email
            preFill.put("email", "developer.kharag@gmail.com");
            //contact
            preFill.put("contact", "7489347378");

            options.put("prefill", preFill);

            checkout.open(activity, options);
        } catch (Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(this, "Payment Cancel", Toast.LENGTH_SHORT).show();
    }
}