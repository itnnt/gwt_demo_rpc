package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.Message;
import com.mySampleApplication.client.MessageService;

public class MessageServiceImpl extends RemoteServiceServlet
        implements MessageService {
    private static final long serialVersionUID = 1L;

    @Override
    public Message getMessage(String input) {
        String messageString = "Hello " + input + "!";
        Message message = new Message();
        message.setMessage(messageString);
        return message;
    }
}
