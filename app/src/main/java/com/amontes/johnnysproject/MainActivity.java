package com.amontes.johnnysproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    // Class member variables.
    //private TextView quantity;  <--We don't need to reference this static View object.
    private TextView quantityTextView;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate these once. It probably works the way you had it, but why create a new instance every time a method is fired????
        //quantity = (TextView) findViewById(R.id.quantity_text_view); <-- Again, no need for this.
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView = (TextView) findViewById(R.id.price_text_view);

    }

    // Tool Bar tom foolery*************************************************************************
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch(id){

            case R.id.action_easter:
                goToEasterEgg();

        }

        return true;

    }
    //**********************************************************************************************

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Just grab the current quantity.
        //int quantity = 5;
        //display(quantity);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        displayPrice(quantity * 5);
    }

    // This method is called when the + button is clicked
    public void increment(View view){
        /* read quantity text view
            assign to variable
            variable++
            display(variable)
         */
        int newQuantity = Integer.parseInt(quantityTextView.getText().toString());
        newQuantity++;
        display(newQuantity);
    }

    // This method is called when the - button is clicked
    public void decrement(View view){
        /* read quantity text view
            assign to variable
            if > 0 variable--
            display(variable)
         */
        int newQuantity = Integer.parseInt(quantityTextView.getText().toString());
        if (newQuantity > 0) {
            newQuantity--;
        }
        display(newQuantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {

        // TextView is expecting a String.
        quantityTextView.setText(String.valueOf(number));
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    protected void goToEasterEgg(){

        Intent easterIntent = new Intent(this, EasterEggActivity.class);
        startActivity(easterIntent);

    }

}
