package com.example.JustJava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    float totalPrice;
    String Name = "";
    int n = 0;
    String[] toppings = new String[4];

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
        if (quantity != 0) {
            quantity--;
        } displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        calculatePrice();
        isChecked();
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
        TextView getName = findViewById(R.id.name_edit_text);
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
        String priceMessage;
        if (quantity != 0) {
            if (Name.equals("")) {
                priceMessage = "Name: Anonymous";
            } else {priceMessage = "Name: " + Name;}
            priceMessage += "\nQuantity: " + quantity;
            if (n != 0)
                priceMessage += "\nToppings: " + Arrays.toString(toppings);
            else
                priceMessage += "\nToppings: None Added";
            priceMessage += "\nTotal: $" + totalPrice;
            priceMessage += "\nThank You!";
            return priceMessage;
        }return priceMessage = "Insert Quantity of Coffee";
    }

    private void isChecked() {
        CheckBox chocolateChips = findViewById(R.id.chocolate_chips_check_box);
        CheckBox sprinkles = findViewById(R.id.sprinkles_check_box);
        CheckBox whippedCream = findViewById(R.id.whipped_cream_check_box);
        if (chocolateChips.isChecked()) {
            toppings[0] = "Chocolate chips";
            n++;
            totalPrice += 0.5;
        }
        if (sprinkles.isChecked()) {
            toppings[1] = "Sprinkles";
            n++;
            totalPrice += 0.5;
        }
        if (whippedCream.isChecked()) {
            toppings[2] = "Whipped Cream";
            n++;
            totalPrice += 0.5;
        }
    }
}