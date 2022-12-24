package com.hopper;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Route("")
public class Main extends VerticalLayout{

    private ContentDatabase contentDatabase;
    private TextField userInput = new TextField("Input your content here");

    private Grid<Content> outputGrid = new Grid<>(Content.class);
    private Binder<Content> binder = new Binder<>(Content.class);


    public Main(ContentDatabase contentDatabase){
        this.contentDatabase = contentDatabase;

        var retrieveButton = new Button("Retrieve");
        retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        retrieveButton.addClickListener(e -> {
            retrieveOutput();
        });

        add(submitUserContent(), outputGrid, retrieveButton);
    }
    public Component submitUserContent(){

        var layout = new VerticalLayout();
        var uploadButton = new Button("Upload");
        uploadButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(userInput, uploadButton);

        binder.bindInstanceFields(this);

        uploadButton.addClickListener(click -> {
            try{
                var content = new Content();
                binder.writeBean(content);
                binder.readBean(new Content());
                contentDatabase.save(content);

                userInput.clear();

            } catch (ValidationException e) {
                //
            }


        });

        return layout;
    }
    private void retrieveOutput(){
        outputGrid.setItems(contentDatabase.findAll());
    }
}
