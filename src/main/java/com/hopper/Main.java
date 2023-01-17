package com.hopper;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

/**
 * Obviously the main method.
 * @author Nam Khanh Nguyen (RickAndMhorti), Lukas Oswald, Paulus Bintang Timur (Paulusdew)
 */
@Route("")
public class Main extends VerticalLayout{

    private final ContentDatabase contentDatabase;

    private final H1 hopperHeader = new H1("Hopper");
    private final TextArea userInput = new TextArea("Input your content here");
    private final Paragraph textLimit = new Paragraph("(Limit: 255 characters)");
    private final TextField keyInput = new TextField("Enter your key here");
    private final Paragraph instructionText = new Paragraph("Type your key and press Retrieve.");
    private final H2 hopperKey = new H2("keys1234");
    private final Paragraph wipeNotice = new Paragraph("Please note that your content will be automatically wiped after 3 minutes regardless");
    private final Grid<Content> outputGrid = new Grid<>(Content.class);
    private final Binder<Content> binder = new Binder<>(Content.class);

    /**
     * Elements can be added under this method to appear on the website
     * @param contentDatabase is the initialised database
     */
    public Main(ContentDatabase contentDatabase){

        this.contentDatabase = contentDatabase;

        binder.forField(userInput).bind(Content::getUserInput,Content::setUserInput);

        addClassNames("main-view");
        userInput.addClassNames("input-field");


        //Button to return submitted content
        var retrieveButton = new Button("Retrieve");
        retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        /**
         * Upon submitting the content, a 3-minute timer begins before the content is then deleted.
         * The delay in timer.schedule(timedWipe,180000L) is a Long, in milliseconds
         */

        retrieveButton.addClickListener(e -> {

            retrieveOutput(keyInput.getValue());

            keyInput.clear();
        });

        /**
         * Wipe button instantly deletes a user's submitted content
         */

        var wipeButton = new Button("Wipe");
        wipeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        wipeButton.addClickListener(e -> {
            contentDatabase.deleteById(keyInput.getValue());
        });

        /**
         * Output grid is the table where the content is returned
         */

        outputGrid.setColumns("userInput");
        add(submitUserContent(), retrieveButton, outputGrid, wipeNotice, wipeButton);
    }

    /**
     * Sends the user's content to the running database and return it in the table
     * @return the table, including the content if the user has given the ID
     */
    public Component submitUserContent(){

        var layout = new VerticalLayout();
        var uploadButton = new Button("Upload");
        uploadButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(hopperHeader, userInput, textLimit, uploadButton, keyInput, instructionText, hopperKey);

        binder.bindInstanceFields(this);

        uploadButton.addClickListener(click -> {
            try{
                var content = new Content();
                binder.writeBean(content);
                binder.readBean(new Content());
                contentDatabase.save(content);

                timedWipe(content.getId());

                userInput.clear();
                instructionText.setText("Your Hopper key is: ");
                hopperKey.setText(content.getId());


            } catch (ValidationException e) {
                //
            }


        });

        return layout;
    }

    /**
     * Accesses the database and returns an item based on the given ID
     * @param Id is accessed in Main, can't be accessed here as it cannot retrieve the ID
     */
    private void retrieveOutput(String Id){
        Stream C = contentDatabase.findById(Id).stream();
        if(C.findAny().isPresent() == true){
        outputGrid.setItems(contentDatabase.findById(Id).stream());
        instructionText.setText("Input your key again, then press 'Wipe' to delete your content");}
        else{
            instructionText.setText("No such key found!");
        }
    }

    /**
     * Method to add a 3-minute countdown before any submitted content is automatically deleted.
     * the schedule() method uses Long, time in milliseconds, so e.g. 10000L is 10000 milliseconds, or 10 seconds
     * @param Id is given when the user submits content above
     */
    private void timedWipe(String Id){
        TimerTask timedWipe = new TimerTask() {
            @Override
            public void run() {
                contentDatabase.deleteById(Id);
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(timedWipe,180000L);
    }

}
