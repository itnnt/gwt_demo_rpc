package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("message")
public interface  MessageService extends RemoteService {

    Message getMessage(String input);
}
