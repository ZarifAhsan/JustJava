package com.example.JustJava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;

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
        display(quantity);
        displayCoffeePrice(quantity * 5);
        displayPaperCupPrice(quantity * 2);
    }


    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity--;
        display(quantity);
        displayCoffeePrice(quantity * 5);
        displayPaperCupPrice(quantity * 2);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        double numberOfCoffees = quantity;
        double totalPrice = (numberOfCoffees * 5) + (numberOfCoffees * 1);
        String priceMessage = "$" + (int) totalPrice + "\nThank You!";
        displayTotalPrice(totalPrice);
        displayMessage(priceMessage);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given price on the screen.
     */

    private void displayCoffeePrice(double number) {
        TextView priceTextView = findViewById(R.id.coffeePrice_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    /**
     * This method displays the given price of Paper cup on the screen.
     */
    private void displayPaperCupPrice(double number) {
        TextView priceTextView = findViewById(R.id.paperCupPrice_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    /**
     * This method displays the total price on the screen.
     */
    private void displayTotalPrice(double number) {
        TextView priceTextView = findViewById(R.id.totalPrice_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.totalPrice_text_view);
        priceTextView.setText(message);
    }
}