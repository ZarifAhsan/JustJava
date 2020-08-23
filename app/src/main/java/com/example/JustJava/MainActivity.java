package com.example.JustJava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int totalPrice;
    String Name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        calculatePrice();
        getName();
        displayMessage(createOrderSummary());
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private void getName() {
        TextView getName = findViewById(R.id.name);
        Name = getName.getText().toString();
    }

    /**
     * Calculates the price of the order.
     */
    private void calculatePrice() {
        totalPrice = (quantity * 5);
    }

    /**
    * Creates the order summary
    */
    private String createOrderSummary() {
        String priceMessage = "Name: " + Name;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + totalPrice;
        priceMessage += "\nThank You!";
        return priceMessage;
    }
}