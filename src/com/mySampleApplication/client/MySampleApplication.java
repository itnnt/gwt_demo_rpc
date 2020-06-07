package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    private MessageServiceAsync messageService = GWT.create(MessageService.class);

    private class MessageCallBack implements AsyncCallback<Message> {
        @Override
        public void onFailure(Throwable caught) {
            /* server side error occured */
            Window.alert("Unable to obtain server response: " + caught.getMessage());
        }

        @Override
        public void onSuccess(Message result) {
            /* server returned result, show user the message */
            Window.alert(result.getMessage());
        }
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        /*create UI */
        final TextBox txtName = new TextBox();
        txtName.setWidth("200");
        txtName.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    /* make remote call to server to get the message */
                    messageService.getMessage(txtName.getValue(), new MessageCallBack());
                }
            }
        });
        Label lblName = new Label("Enter your name: ");

        Button buttonMessage = new Button("Click Me!");

        buttonMessage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                /* make remote call to server to get the message */
                messageService.getMessage(txtName.getValue(), new MessageCallBack());
            }
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(lblName);
        hPanel.add(txtName);
        hPanel.setCellWidth(lblName, "130");

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(10);
        vPanel.add(hPanel);
        vPanel.add(buttonMessage);
        vPanel.setCellHorizontalAlignment(buttonMessage,
                HasHorizontalAlignment.ALIGN_RIGHT);

        DecoratorPanel panel = new DecoratorPanel();
        panel.add(vPanel);

        // Add widgets to the root panel.
        RootPanel.get("gwtContainer").add(panel);
    }

}
