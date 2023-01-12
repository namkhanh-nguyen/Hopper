package com.hopper;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Timer;
import java.util.TimerTask;

@Route("")
public class Main extends VerticalLayout{

    private ContentDatabase contentDatabase;
    private TextField userInput = new TextField("Input your content here");

    private TextField KeyInput = new TextField("Enter your given key here");

    private Paragraph HopperKey = new Paragraph("Welcome to Hopper! Type your content in the box above.");

    private Paragraph wipeInstructions = new Paragraph("Type your key again in the box, then press Wipe to delete your content. Please note that your content will be automatically wiped after 5 minutes if you haven't used the Wipe button yourself");

    //outputGrid is where the user's uploaded text is returned
    private Grid<Content> outputGrid = new Grid<>(Content.class);
    private Binder<Content> binder = new Binder<>(Content.class);

    /**
     *
     * @param contentDatabase
     */

    public Main(ContentDatabase contentDatabase){
        this.contentDatabase = contentDatabase;

        binder.forField(userInput).bind(Content::getUserInput,Content::setUserInput);

        //Button to return submitted content
        var retrieveButton = new Button("Retrieve");
        retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        retrieveButton.addClickListener(e -> {
            retrieveOutput(KeyInput.getValue());

            TimerTask timedWipe = new TimerTask() {
                @Override
                public void run() {
                    contentDatabase.deleteById(KeyInput.getValue());
                }
            };
            Timer timer = new Timer("Timer");
            timer.schedule(timedWipe,300000L);

            KeyInput.clear();
        });

        //Test button to wipe content after an x amount of time
        var wipeButton = new Button("Wipe");
        retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        wipeButton.addClickListener(e -> {
            //delay = time in milliseconds, default is 10000 ms/ 10s
            contentDatabase.deleteById(KeyInput.getValue());
        });

        outputGrid.setColumns("id", "userInput");
        add(submitUserContent(), retrieveButton, outputGrid, wipeButton);


    }

    public Component submitUserContent(){

        var layout = new VerticalLayout();
        var uploadButton = new Button("Upload");
        uploadButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(userInput, uploadButton, KeyInput, HopperKey, wipeInstructions);

        binder.bindInstanceFields(this);

        uploadButton.addClickListener(click -> {
            try{
                var content = new Content();
                binder.writeBean(content);
                binder.readBean(new Content());
                contentDatabase.save(content);

                userInput.clear();
                HopperKey.setText("Your HopperKey is: " + content.getId() + ". Type your key in the second box, then click Retrieve.");

            } catch (ValidationException e) {
                //
            }


        });

        return layout;
    }
    private void retrieveOutput(String Id){
        outputGrid.setItems(contentDatabase.findById(Id).stream());
    }
}
