package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity  {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.whipped);
        boolean isWhipped = checkBox1.isChecked();
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.choco);
        boolean isChoco = checkBox2.isChecked();
        int  c = isChoco ? 2 : 0 ;
        int  wc = isWhipped ? 1 : 0 ;
        int t = c + wc + 5;
        int price=calculatePrice(t);

        EditText editText = (EditText) findViewById(R.id.name);
        String n = editText.getText().toString();
        String priceMessage=createOrderSummary(n,price,isWhipped,isChoco);

        //displayMessage(priceMessage);

        //displayPrice(quantity * 5);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+n);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    private int calculatePrice(int a){

        return quantity*a;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        if (quantity != 100) {
            quantity++;
            displayQuantity(quantity);
        }
        else{
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        }
    }

    private String createOrderSummary(String n, int p,boolean isWhipped, boolean isChoco){

        return "Name: "+n+"\nAdd whipped cream? "+isWhipped+"\nAdd chocolate? "+isChoco+"\nQuantity: "+quantity+"\nTotal: $"+p+"\nThank you!" ;
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity != 1) {
            quantity--;
            displayQuantity(quantity);
        }
        else{
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This method displays the given quantity value on the screen.
      */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }
}