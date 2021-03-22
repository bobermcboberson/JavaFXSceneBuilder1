package TextEditor;

import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    public Button saveButton;
    public TextField textField1;
    public TextArea myBigTextArea;
    public ListView myListView;
    public LocalDateTime myLocalDateTime;
    public DatePicker myDatePicker;
    // When the button is pressed
    public void userSavedText() {
        // Grab the date selected from the DatePicker
        LocalDate myLocalDate = myDatePicker.getValue();
        // Grab the time (ISO-8601 format)
        myLocalDateTime = LocalDateTime.now();
        // Converts the time into a format like: (Monday, January 1, 2000 12:00:00 PM)
        String convertedDateTime = myLocalDateTime.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a"));
        // Grab the text from the text box/text field and saves it as textToSave1
        String textToSave1 = textField1.getText();
        // Set the text area to display the saved text from textToSave1 and the time when it was saved
        myBigTextArea.setText(textToSave1 + " was saved on: "+ convertedDateTime);
        // Set the listview to display one line that shows the saved text from textToSave1 and the selected Date
        myListView.getItems().add(textToSave1 + ": " + myLocalDate);
        myBigTextArea.setDisable(false);
        textField1.setText("");
        saveButton.setText("SAVED");
        saveButton.setDisable(true);
        // Prints out useful information
        System.out.println("User typed: " + textToSave1 + " on " + convertedDateTime + "/" + myLocalDateTime);
        System.out.println("Saved in listview: " + textToSave1 + ": " + myLocalDate);
    }
}