package com.example.qauntifiedself.model;

import java.util.regex.Pattern;

import android.widget.EditText;

public class Validation {
	 private static final String REQUIRED_MSG = "required";

	public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {
		 
	        String text = editText.getText().toString().trim();
	        // clearing the error, if it was previously set by some other values
	        editText.setError(null);
	 
	        // text required and editText is blank, so return false
	        if ( required && !hasText(editText) ) return false;
	 
	        // pattern doesn't match so returning false
	        if (required && !Pattern.matches(regex, text)) {
	            editText.setError(errMsg);
	            return false;
	        };
	 
	        return true;
	    }
	
	  public static boolean hasText(EditText editText) {
		  
	        String text = editText.getText().toString().trim();
	        editText.setError(null);
	        // length 0 means there is no text
	        if (text.length() == 0) {
	            editText.setError(REQUIRED_MSG);
	            return false;
	        }
	 
	        return true;
	    }
	
}
